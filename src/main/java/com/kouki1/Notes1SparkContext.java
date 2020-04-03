package com.kouki1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class Notes1SparkContext {
    public static void main(String[] args) {
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

         NB: ** Each application gets its own executor process which stay up for the duration of the whole application and run tasks in multiple threads
             ** The driver program must listen for and accept incoming connections from its executors throughout its lifetime
             ** Because the driver schedules tasks on the cluster, it should be run close to the worker nodes, preferably on the same local area network
         !!!! : Only one SparkContext may be active per JVM. You must stop() the active SparkContext before creating a new one.
         */
        JavaSparkContext sc = new JavaSparkContext();
    }
}
