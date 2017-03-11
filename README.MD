# Running

1. movie-list-api

  ```bash
  cd ./movie-list-api
  ../gradlew bootRun
  ```

2. movie-list-store-service

  1. For in memory store

    ```bash
    cd ./movie-list-store-service
    ../gradlew bootRun
    ```

  2. For cassandra store

    ```bash
    cd ./movie-list-store-service
    ```

    Edit the src/main/resources/application.properties to set the proper cassandra.contactPoint address, then

    ```bash
    PROFILE=cassandra ../gradlew/gradlew bootRun
    ```

3. movie-list-ui

  ```bash
  cd ./movie-list-ui
  npm install
  npm start
  ```

