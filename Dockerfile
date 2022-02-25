FROM openjdk:11
EXPOSE 8080
COPY ./target/docker.jar /usr/local/lib/docker.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/docker.jar"]