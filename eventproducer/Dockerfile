FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eventproducer.jar
ENTRYPOINT ["java","-jar","/eventproducer.jar"]