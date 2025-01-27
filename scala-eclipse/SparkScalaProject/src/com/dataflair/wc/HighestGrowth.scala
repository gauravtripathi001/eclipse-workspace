//1.Which country has the highest urban population
package com.dataflair.wc

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import java.lang.Long

object HighestGrowth {
	def main(args: Array[String]) = {

   		if (args.length < 2) {
        System.err.println("Usage: UrbanPopulation <Input-File> <Output-File>");
        System.exit(1);
      }

			val spark = SparkSession
				.builder
				.appName("HighestGrowth")
				.getOrCreate()
				
			val data = spark.read.csv(args(0)).rdd
			
			val result = data.map { line => {
			  
			  val population = String.valueOf(line.get(9)).replaceAll(",", "")
			  
			  var popNum = 0L
			  if(population=="null")
			    popNum=0L
			  else if (population.length() > 0)
			    popNum = Long.parseLong(population)
			  
			  (line.getString(0),popNum)
			}}
			.groupByKey()
			.map(rec => {(rec._1,((rec._2.max-rec._2.min).toFloat/(rec._2.max+rec._2.min).toFloat))})
			.sortBy(rec => (rec._2),false)
			.first

			spark.sparkContext.parallelize(Seq(result)).saveAsTextFile(args(1))
			
			spark.stop
	}
}
//bin/spark-submit --class com.df.wbi.UrbanPopulation ../wbJob.jar ../World_Bank_Indicators.csv wb-out-002