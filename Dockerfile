FROM openjdk:8u191-jre-alpine3.8
EXPOSE 8080
# ADD .jar under target from host
# into this image
ADD target/SeleniumFramework.jar SeleniumFramework.jar
ENTRYPOINT ["java","-jar","SeleniumFramework.jar"]


