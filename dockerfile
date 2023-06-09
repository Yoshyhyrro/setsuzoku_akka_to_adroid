FROM openjdk:11

RUN apt-get update && apt-get install -y \
  akka-stream \
  scala

CMD java -jar my-akka-stream-app.jar
