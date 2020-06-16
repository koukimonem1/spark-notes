package com.kouki1

import org.apache.spark.SparkConf

object Notes2YarnClusterManager {
  val conf = new SparkConf().setAppName("kouki-app").setMaster("yarn")

  /**
  There are two deploy modes that can be used to launch Spark applications on YARN :
           - Cluster mode, the Spark driver runs inside an application master process which is managed by YARN on the cluster
            => the client can go away after initiating the application
            => In spark submit write : --deploy-mode cluster
           - Client mode, the driver runs in the client process, and the application master is only used for requesting resources from YARN
            => In spark submit write : --deploy-mode client
         !!! In cluster mode, the driver runs on a different machine than the client, so SparkContext.addJar won’t work out of the box with files that are local to the client
            =>  To make files on the client available to SparkContext.addJar, include them with the --jars option in the launch command
           - The client will periodically poll the Application Master for status updates and display them in the console
           - The client will exit once your application has finished running
   */
}
