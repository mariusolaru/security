FROM openjdk:8
ADD target/evaluation.jar evaluation.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "evaluation.jar"]