package com.kouki4.streaming

import com.kouki4.streaming.Notes1FirstExample.ssc
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Notes4UpdateStateByKey  extends App {
  val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
  val ssc = new StreamingContext(conf, Seconds(10))
  val lines = ssc.socketTextStream("localhost", 9999)
  val words = lines.flatMap(_.split(" "))
  val pairs = words.map(word => (word, 1))
  val wordCounts = pairs.reduceByKey(_ + _)
//  wordCounts.updateStateByKey[Int](updateFunction _)
  wordCounts.print()
  ssc.checkpoint("")
  ssc.start()
  ssc.awaitTermination()

}
