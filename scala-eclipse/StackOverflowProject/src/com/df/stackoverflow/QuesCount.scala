//1. Count the total number of questions in the available data-set and collect the questions id of all the questions
package com.df.stackoverflow

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object QuesCount {
	def main(args: Array[String]) = {
			System.setProperty("hadoop.home.dir", "C:\\Users\\gaurav tripathi\\Downloads\\Spark Training\\hadoop-2.5.0")
			System.setProperty("spark.sql.warehouse.dir", "file:/C:/Users/gaurav tripathi/Downloads/Spark Training/spark-2.0.2-bin-hadoop2.7/spark-warehouse")

			val spark = SparkSession
				.builder
				.appName("AvgAnsTime")
				.master("local")
				.getOrCreate()
				
			//Read some example file to a test RDD
			val data = spark.read.textFile("C:\\Users\\gaurav tripathi\\Downloads\\Spark Training\\Posts.xml").rdd


			val result = data.filter{line => {line.trim().startsWith("<row")}			   
			}
			.filter { line => {line.contains("PostTypeId=\"1\"")}
			}
			
			result.foreach { println }
			println("Total Count: " + result.count())

			spark.stop
	}
}
//http://public-repo-1.hortonworks.com/hdp-win-alpha/winutils.exe