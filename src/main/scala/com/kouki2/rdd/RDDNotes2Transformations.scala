package com.kouki2.rdd

import org.apache.spark.{SparkConf, SparkContext}

object RDDNotes2Transformations {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("kouki-app").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("transactions_20150114.txt")

    /**
     * Transformations : creates a new dataset from an existing one.
     */
    // All transformations in Spark are lazy, in that they do not compute their results right away
    val rdd1 = rdd.map(x => x)
    // The transformations are only computed when an action requires a result to be returned to the driver program.
    rdd1.reduce((x, y) => x + y)
    // If an rdd may be recomputed many times, we should use persist (or cache) method
    rdd.persist()
  }
}
