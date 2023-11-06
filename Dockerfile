FROM openjdk:8
EXPOSE 8089  
ADD target/gestion-station-ski-SNAPSHOT-01.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]