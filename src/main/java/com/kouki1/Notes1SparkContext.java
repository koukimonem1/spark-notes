package com.kouki1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class Notes1SparkContext {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("kouki-app").setMaster("master");
        /**
         1- SparkContext Object coordinates the process in the cluster
          ** Driver program : the main program that contains the spark-context object
         2- SparkContext can connect to several types of cluster managers (Mesos, Yarn, Standalone)
         3- Cluster manager allocates resources for applications
         4- Once connected, Spark acquires executors on nodes in the cluster
          ** Executors are processes that run computations and store data for your application
         5- Spark sends your application code (defined by JAR or Python files passed to SparkContext) to the executors.
         6-  Finally, SparkContext sends tasks(like flatMap, map and reduceByKey...) to the executors to run
          ** A task is a command sent from the driver to an executor by serializing your Function object.
          ** The executor deserializes the command (this is possible because it has loaded your jar), and executes it on a partition
         7- When the driver quits, the executors shut down
         */
        JavaSparkContext sc = new JavaSparkContext(conf);
    }
}