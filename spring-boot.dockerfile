FROM openjdk:18-alpine

LABEL Author="Nathan, Tudor, Cezars"

ADD target/socialMedia-0.0.1-SNAPSHOT.jar /opt/

RUN echo "We're going to build our first Spring Boot image"

WORKDIR /opt

CMD java -jar socialMedia-0.0.1-SNAPSHOT.jar