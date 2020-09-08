package com.kouki4.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Duration, Seconds, StreamingContext}

object Notes2FileStream extends App{
 val conf = new SparkConf()
   .setAppName("tester filestreaming")
   .setMaster("local[*]")
  val ssc = new StreamingContext(conf,Seconds(10))
 val fileStream = ssc.textFileStream("file:///home/kouki/IdeaProjects/spark-notes/dir/texts")
 fileStream.foreachRDD(rdd => rdd.foreach(println))
 ssc.start()
 ssc.awaitTermination()
}
