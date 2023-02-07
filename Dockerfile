FROM openjdk:18-alpine

LABEL Author="Nathan, Tudor, Cezar"

ADD src/main/java/Starter.java /opt/

RUN echo "Docker image for social media project"

WORKDIR /opt

RUN javac Starter.java && rm Starter.java

CMD java Starter