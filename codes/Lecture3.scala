// Databricks notebook source exported at Fri, 11 Nov 2016 20:05:36 UTC
for (i <- 0 to 9; j = i * 2 + 1) yield j

// COMMAND ----------

0 to 20 filter (_ % 2 == 1)

// COMMAND ----------

0L to 9L map (_ * 2 + 1)

// COMMAND ----------


