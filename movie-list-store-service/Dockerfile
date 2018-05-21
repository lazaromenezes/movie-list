FROM openjdk:8-jre
ARG SERVICE_PORT=9080

LABEL Description="Starts Movie List store service"

COPY ./build/libs/movie-list-store-service.jar /opt/movie-list/movie-list-store-service.jar

WORKDIR /opt/movie-list

ENV STORE_SERVICE_PORT=$SERVICE_PORT
ENV CASSANDRA_CONTACT_POINT=0.0.0.0
ENV SPRING_PROFILES_ACTIVE=inmemory

EXPOSE $SERVICE_PORT

CMD java -jar ./movie-list-store-service.jar

