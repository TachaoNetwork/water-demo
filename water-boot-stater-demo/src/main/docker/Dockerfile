FROM java:8u66-jdk
VOLUME /tmp
ADD water-boot-stater-demo-1.0.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]