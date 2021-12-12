FROM openjdk:17.0.1-slim
COPY target/mail_sender-0.0.1-SNAPSHOT.jar mail-sender-app.jar
ENTRYPOINT ["java","-jar","/mail-sender-app.jar"]