package com.kouki3.sql
import org.apache.spark.sql.SparkSession


object SQL1DataSetVsDataFrame extends App{
println("koukiiiiiiiiiiiiiiiiii")
  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .master("local[*]")
    .getOrCreate()
  // For implicit conversions like converting RDDs to DataFrames
  import spark.implicits._
    val df = spark.read.json("/home/kouki/IdeaProjects/spark-notes/dir/resources/people.json")
  // des opérations non typées de DataFrame
    df.show()
    df.printSchema()
    df.select("name").show()

  // On peut érire des requete SQL directement, mais il faut tout d'abord enregistrer la DataFrame
  // en tant que Vue temporaire
  df.createOrReplaceTempView("people")
  val sqlDF = spark.sql("SELECT * FROM people")
  sqlDF.show()

}
