package com.kouki2.rdd

import org.apache.spark.{SparkConf, SparkContext}

object RDDNotes6SharedVariables {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("kouki-app").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("transactions_20150114.txt")
    // Broadcast variables allow the programmer to keep a read-only variable cached on each machine rather than shipping a copy of it with tasks

  }
}
