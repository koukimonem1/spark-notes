package com.kouki3.sql
import org.apache.spark.sql.SparkSession


object SQL1DataSetVsDataFrame extends App{

  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .master("local[*]")
    .getOrCreate()
  // For implicit conversions like converting RDDs to DataFrames
  import spark.implicits._
     spark.read.json("dir/resources/people.json")

}
