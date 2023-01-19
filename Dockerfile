FROM amazoncorretto:17.0.4
MAINTAINER Parkhurst
COPY target/restapi-0.0.1-SNAPSHOT.jar restapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/restapi-0.0.1-SNAPSHOT.jar"]