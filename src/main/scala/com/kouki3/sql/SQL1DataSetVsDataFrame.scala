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
    val df = spark.read.json("dir/resources/people.json")
  // des opérations non typées de DataFrame
    df.show()
    df.printSchema()
    df.select("name").show()

}
