# How to run?

## Docker compose

```
cd docker
docker-compose up
```

## SpringBoot app
```
cd spring-boot
mvn spring-boot:run
```

## How to test
Curl from shell
```
curl --location --request POST 'localhost:8080/publish' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'message=message from spring boot'
```
