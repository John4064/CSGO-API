FROM amazoncorretto:17.0.4
MAINTAINER Parkhurst
VOLUME /tmp
EXPOSE 5800
ARG JAR_FILE=target/app.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]