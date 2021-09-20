# nokiatest

Pre-requisite:

1. Docker should be installed and on running condition.
2. Maven should be available.

Build Process:
1. cd eventconsumer
2. mvn clean install -DskipTests
3. cd ../
4. mvn clean install -DskipTests
5. cd ..

Docker compose deployment:
1. docker-compose up --build -d

Minikube deployment:
1. apply -f zookeeper-service.yaml,zookeeper-deployment.yaml,kafka-service.yaml,kafka-deployment.yaml,apachecassandra-service.yaml,apachecassandra-deployment.yaml,producer-service.yaml,producer-deployment.yaml,consumer-service.yaml,consumer-deployment.yaml

Swagger API access:

http://localhost:8084/swagger-ui.html


