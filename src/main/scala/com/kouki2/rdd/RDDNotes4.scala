package com.kouki2.rdd

import org.apache.spark.{SparkConf, SparkContext}

object RDDNotes4 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("kouki-app").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("transactions_20150114.txt")
    // Another common idiom is attempting to print out the elements of an RDD using rdd.foreach(println) or rdd.map(println).
    // On a single machine, this will generate the expected output and print all the RDD’s elements.
    // However, in cluster mode, the output to stdout being called by the executors is now writing to the executor’s stdout instead, not the one on the driver, so stdout on the driver won’t show these!
    rdd.foreach(println)

    // To print all elements on the driver,
    // one can use the collect() method to first bring the RDD to the driver node thus:
    rdd.collect().foreach(println)

    //This can cause the driver to run out of memory, though, because collect() fetches the entire RDD to a single machine;
    // if you only need to print a few elements of the RDD, a safer approach is to use the take(): rdd.take(100).foreach(println).

  }
}
