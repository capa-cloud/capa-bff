FROM adoptopenjdk/openjdk11:latest

RUN mkdir /work
WORKDIR /work

COPY ./src/ /work/

COPY target/capa-bff-example-dependency-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "capa-bff-example-dependency-0.0.1-SNAPSHOT.jar"]