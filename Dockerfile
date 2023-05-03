FROM openjdk:17-alpine

COPY target/dockerT-0.0.1-SNAPSHOT.jar dockerT-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","./dockerT-0.0.1-SNAPSHOT.jar"]