//1.Which country has the highest urban population
package com.dataflair.wc

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import java.lang.Long

object HighestGDP {
	def main(args: Array[String]) = {

   		if (args.length < 2) {
        System.err.println("Usage: UrbanPopulation <Input-File> <Output-File>");
        System.exit(1);
      }

			val spark = SparkSession
				.builder
				.appName("HighestGDP")
				.getOrCreate()
				
			val data = spark.read.csv(args(0)).rdd
			
			val result = data.map { line => {
			  
			  val gdp = String.valueOf(line.get(18)).replaceAll(",", "")
			  val date=String.valueOf(line.get(1)).split("/")(2)
			  
			  var gdpNum = 0L
			  if(gdp=="null")
			    gdpNum=0L
			  else if (gdp.length() > 0)
			    gdpNum = Long.parseLong(gdp)
			  
			  (line.getString(0),gdpNum,date)
			}}
			

			spark.sparkContext.parallelize(Seq(result)).saveAsTextFile(args(1))
			
			spark.stop
	}
}
//bin/spark-submit --class com.df.wbi.UrbanPopulation ../wbJob.jar ../World_Bank_Indicators.csv wb-out-002