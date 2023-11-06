FROM openjdk:8
EXPOSE 8089  
ADD target/devops-0.0.1.jar app.jar 
ENTRYPOINT ["java","-jar","app.jar"]