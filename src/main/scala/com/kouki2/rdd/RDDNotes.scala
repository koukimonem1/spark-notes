package com.kouki2.rdd

import org.apache.spark.{SparkConf, SparkContext}

object RDDNotes {
  def main(args: Array[String]): Unit = {
    /**
     * Only one SparkContext may be active per JVM. You must stop() the active SparkContext before creating a new one.
     */
    val conf = new SparkConf().setAppName("kouki-app").setMaster("local[4]")
    val sc = new SparkContext(conf)
    /**
     * By default, Spark creates one partition for each block of the file
     * We can also ask for a higher number of partitions by passing a larger value
     * !!! Note that you cannot have fewer partitions than blocks
     */
    val rdd = sc.textFile("transactions_20150114.txt", 2)
    val legnth = rdd.map(_.length).reduce((a, b) => a + b)
    print(legnth)
    val rdd1 = sc.wholeTextFiles("dir")
    rdd1.foreach(x => println(x._1 + ":\n" + x._2) + "\n\n\n")
    //For other Hadoop InputFormats, you can use the SparkContext.hadoopRDD method
    //sc.hadoopRDD
    // You can also use SparkContext.newAPIHadoopRDD for InputFormats based on the “new” MapReduce API
    // sc.newAPIHadoopRDD
  }
}
