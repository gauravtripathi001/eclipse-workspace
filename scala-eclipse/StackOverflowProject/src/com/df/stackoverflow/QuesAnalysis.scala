//2. Monthly questions count – provide the distribution of number of questions asked per month
package com.df.stackoverflow

import scala.xml.XML

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

import java.text.SimpleDateFormat
import java.lang.String
import org.apache.spark.sql.SparkSession

object QuesAnalysis {
	def main(args: Array[String]) = {
			System.setProperty("hadoop.home.dir", "C:\\Users\\gaurav tripathi\\Downloads\\Spark Training\\hadoop-2.5.0")
			System.setProperty("spark.sql.warehouse.dir", "file:/C:/Users/gaurav tripathi/Downloads/Spark Training/spark-2.0.2-bin-hadoop2.7/spark-warehouse")

			val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
      val format2 = new SimpleDateFormat("yyyy-MM");

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
			.flatMap {line => {
			  val xml = XML.loadString(line)
			  xml.attribute("CreationDate")
			  }
			}
			.map { line => {
        (format2.format(format.parse(line.toString())).toString(), 1)
			}
			}
			.reduceByKey(_ + _)
			
			result.foreach { println }

			spark.stop
	}
}