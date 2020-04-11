package com.kouki2.rdd

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object RDDNotes5Persistence {
  def main(args: Array[String]): Unit = {
    //When you persist an RDD, each node stores any partitions of it that it computes in memory and reuses them in other actions on that dataset (or datasets derived from it)
    // The first time it is computed in an action, it will be kept in memory on the nodes
    // Spark’s cache is fault-tolerant – if any partition of an RDD is lost, it will automatically be recomputed using the transformations that originally created it
    //cache() method = MEMORY_ONLY
    val conf = new SparkConf().setAppName("kouki-app").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("transactions_20150114.txt")
// See : https://spark.apache.org/docs/latest/rdd-programming-guide.html#rdd-persistence
    rdd.persist(StorageLevel.MEMORY_ONLY)
    rdd.persist(StorageLevel.MEMORY_AND_DISK)
    rdd.persist(StorageLevel.MEMORY_ONLY_SER)
    rdd.persist(StorageLevel.MEMORY_AND_DISK_SER)
    rdd.persist(StorageLevel.DISK_ONLY)
    rdd.persist(StorageLevel.OFF_HEAP)
    // Spark also automatically persists some intermediate data in shuffle operations (e.g. reduceByKey),
    // even without users calling persist. This is done to avoid recomputing the entire input if a node fails during the shuffle.
    // We still recommend users call persist on the resulting RDD if they plan to reuse it.


    //Spark automatically monitors cache usage on each node and drops out old data partitions in a least-recently-used (LRU) fashion
    // to manually remove an RDD instead of waiting for it to fall out of the cache, use the RDD.unpersist() method
    rdd.unpersist()
  }
}
