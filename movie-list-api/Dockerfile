FROM openjdk:8-jre
ARG SERVICE_PORT=80
ARG STORE_SERVICE_API
LABEL Description="Starts Movie List API"

COPY ./build/libs/movie-list-api.jar /opt/movie-list/movie-list-api.jar

WORKDIR /opt/movie-list

ENV API_PORT=$SERVICE_PORT
ENV STORE_SERVICE_API=$STORE_SERVICE_API

EXPOSE $SERVICE_PORT

CMD java -jar ./movie-list-api.jar

