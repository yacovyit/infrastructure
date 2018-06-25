sudo docker run -d \
--name kafka \
-p 7203:7203 \
-p 9092:9092 \
-e KAFKA_ADVERTISED_HOST_NAME=192.168.14.90 \
-e ZOOKEEPER_IP=192.168.14.90 \
ches/kafka