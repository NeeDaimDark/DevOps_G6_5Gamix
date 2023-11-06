FROM openjdk:8
EXPOSE 8089
ADD target/kaddem-SNAPSHOT-01.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]