FROM dependency-cache:latest as build
WORKDIR /app
COPY ./ ./
RUN gradle clean build --no-daemon -i --stacktrace -x test

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/registration-0.0.1-SNAPSHOT.jar ./spring-boot-application.jar

ARG POSTGRES_HOSTS
ARG POSTGRES_DB
ARG POSTGRES_USER
ARG POSTGRES_PWD
ARG RABBIT_HOST
ARG RABBIT_PORT
ARG RABBIT_USERNAME
ARG RABBIT_PASSWORD
ARG SERVER_PORT
ARG RABBIT_QUEUE
ARG USER_SERVICE_HOSTS
ARG NGINX_PORT
ARG SCHEDULE_SERVICE_HOSTS

ENV POSTGRES_HOSTS = ${POSTGRES_HOSTS}
ENV POSTGRES_DB = ${POSTGRES_DB}
ENV POSTGRES_USER = ${POSTGRES_USER}
ENV POSTGRES_PWD = ${POSTGRES_PWD}
ENV RABBIT_HOST = ${RABBIT_HOST}
ENV RABBIT_PORT = ${RABBIT_PORT}
ENV RABBIT_USERNAME = ${RABBIT_USERNAME}
ENV RABBIT_PASSWORD = ${RABBIT_PASSWORD}
ENV SERVER_PORT = ${SERVER_PORT}
ENV RABBIT_QUEUE = ${RABBIT_QUEUE}
ENV USER_SERVICE_HOSTS = ${USER_SERVICE_HOSTS}
ENV NGINX_PORT = ${NGINX_PORT}
ENV SCHEDULE_SERVICE_HOSTS = ${SCHEDULE_SERVICE_HOSTS}

ENTRYPOINT ["java","-jar","./spring-boot-application.jar"]