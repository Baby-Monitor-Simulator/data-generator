FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

#IMAGE AANMAKEN
#docker build datageneratorbw

#IMAGE RUNNEN
#docker run -p 8000:8080 datageneratorbw
