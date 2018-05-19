FROM openjdk:8-jre
ARG STORE_SERVICE_API
LABEL Description="Starts Movie List API"

COPY ./build/libs/movie-list-api.jar /opt/movie-list/movie-list-api.jar

WORKDIR /opt/movie-list

ENV API_PORT=8080
ENV STORE_SERVICE_API=$STORE_SERVICE_API

EXPOSE 8080

CMD java -jar ./movie-list-api.jar

