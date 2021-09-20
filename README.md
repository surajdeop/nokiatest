# nokiatest

Pre-requisite:

1. Docker should be installed and on running condition.
2. Maven should be available.



How to build project?

mvn clean install -DskipTests

apply -f zookeeper-service.yaml,zookeeper-deployment.yaml,kafka-service.yaml,kafka-deployment.yaml,apachecassandra-service.yaml,apachecassandra-deployment.yaml,producer-service.yaml,producer-deployment.yaml,consumer-service.yaml,consumer-deployment.yaml