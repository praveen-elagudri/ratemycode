from __future__ import print_function

import sys

from pyspark import SparkContext
from pyspark.streaming import StreamingContext
from pyspark.streaming.kafka import KafkaUtils

if __name__ == '__main__':

    sc = SparkContext(appName="PythonStreamingKafkaWordCount")
    ssc = StreamingContext(sc, 1)

    kstream = KafkaUtils.createDirectStream(ssc, topics = ['CodeSubmission'], \
    		kafkaParams = {"metadata.broker.list": '52.53.157.26:9092'})

    data = kstream.map(lambda x: x[1].encode("utf-8"))
    data.pprint()

    ssc.start()
    ssc.awaitTerminationOrTimeout(30)
    ssc.stop(stopGraceFully = True)

