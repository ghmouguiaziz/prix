FROM openjdk:17-alpine
EXPOSE 8094
ADD target/prix-0.0.1-SNAPSHOT.jar prix.jar
ENTRYPOINT ["java","-jar","prix.jar"]
