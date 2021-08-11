# Create Marketing Preferences Microservice

This is the create preference microservice that is responsible to create and update Marketing preferences of customers.
This microservice is written in Java/Spring Boot.

# Steps to run without docker

## Pre-requisites:

* Install Java 16 [Install open jdk 16 on your machine](https://openjdk.java.net/)
* Install Gradle [Install open jdk 16 on your machine](https://gradle.org/install/)

### Steps to run locally:

* Run ```gradle build```
* ```cd build/libs``` folder
* Run java -jar create-preference-service-1.0.0.jar

# Run unit tests

```gradle  test```

# Steps to run using docker:

* Install Docker [Install docker on your machine](https://www.docker.com/products/docker-desktop)

## Docker Build

```
docker build -t createpreference:lts .
```

## Docker Run

```
docker run -p 8080:8080 --init -e SPRING_PROFILES_ACTIVE='demo' --rm -d --name createpreference_service createpreference:lts
```

## Run non detach

```
docker run -p 8080:8080 --init -e SPRING_PROFILES_ACTIVE='demo' --rm --name createpreference_service createpreference:lts
```

## Check container logs

```
docker logs <image_name>
docker logs createpreference_service
```

## Kill container

```
docker kill <container-id>
docker rm createpreference_service
```
