FROM openjdk:8-jdk-alpine
COPY target/wp-aud-recap-0.0.1-SNAPSHOT.jar wp-aud-recap-0.0.1.jar
ENTRYPOINT ["java","-jar","/wp-aud-recap-0.0.1.jar"]