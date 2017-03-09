# Running

1. movie-list-api
```bash
cd ./movie-list-api
mvn spring-boot:run
```

2. movie-list-store-service
```bash
cd ./movie-list-store-service
mvn cassandra:start spring-boot:run
```

3. ui
```bash
cd ./movie-list-ui
npm install
npm start
```
