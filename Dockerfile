FROM openjdk:17-slim
LABEL authors="wonseok"
VOLUME /tmp
COPY build/libs/configserver-0.0.1-SNAPSHOT.jar configserver.jar
ENTRYPOINT ["java", "-jar", "configserver.jar"]