FROM openjdk:8u131-jdk-alpine

MAINTAINER HARISH KUMAR SINHA "harish.k.sinha@gmail.com"

EXPOSE 8090

WORKDIR /usr/local/bin/

COPY ./build/libs/xcomsrvc-0.0.1-SNAPSHOT.jar xcomsrvc.jar

CMD ["java","-jar","xcomsrvc.jar"]