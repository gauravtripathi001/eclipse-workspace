package com.dataflair.wc;

import scala.Tuple2;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.Iterator;

public final class NumberSum2 {

	public static void main(String[] args) throws Exception {

		if (args.length < 2) {
			System.err.println("Usage: Java Number Sum <INP-PATH> <OUTPUT-PATH>");
			System.exit(1);
		}

		SparkSession spark = SparkSession.builder().appName("Java Number Sum").getOrCreate();

		JavaRDD<String> lines = spark.read().textFile(args[0]).javaRDD();

		/*
		 * 1 2 34 6 78 2 67 19 = 3285
		 * 43 545 56 86 79 2 42 34 = 4390
		 */
		JavaRDD<Integer> nos = lines.flatMap(new FlatMapFunction<String, Integer>() {
			@Override
			public Iterator<Integer> call(String s) {
				int sum = 0;
				String tokens [] = s.split(" ");
				for (String token : tokens)
				{
					sum += Integer.parseInt(token);
				}
				return Arrays.asList(new Integer(sum)).iterator();
				
				/* 1 2 34 6 78 2 67 19
				 * 1 
				 * 2 
				 * 34 
				 * 6 
				 * 78 
				 * 2 
				 * 67 
				 * 19
				 * 
				 * 43 545 56 86 79 2 42 34 = 4390
				 */

			}
		});

		JavaPairRDD<String, Integer> ones = nos.mapToPair(new PairFunction<Integer, String, Integer>() {
			@Override
			public Tuple2<String, Integer> call(Integer no) {
				return new Tuple2<String, Integer>("sum", no);
				
				/*
				 * sum, 2445
				 * sum, 43546
				 * sum, 6576
				 * sum, 12324
				 * sum, 43546
				 * sum, 56756
				 */
			}
		});
		
		JavaPairRDD<String, Integer> sum = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
			/*
			 * sum [234 23 534 6457 6576 673 338 367 867 8335 62342........]
			 */

			@Override
			public Integer call(Integer i1, Integer i2) {
				return i1 + i2;
//			        	234 + 23
//						257 + 534
//						1089 + 6457
				
			}
		});

		sum.values().saveAsTextFile(args[1]);

		spark.stop();
	}
}
//bin/spark-submit --class com.dataflair.ns.NumberSum ../sparkJob.jar ../numbers num-out-01