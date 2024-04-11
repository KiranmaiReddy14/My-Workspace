FROM openjdk:8-jdk-alpine
ADD target/webapp.jar webapp.jar
EXPOSE 9050
ENTRYPOINT ["java","-jar","/webapp.jar"]