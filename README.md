The example project for StringBoot service

<div align="center">
    <img src="./assets/images/spring_boot_icon.png"/>
</div>

## Getting Started

## Project structure
```
.
├── service-A
│   ├── Dockerfile
│   ...
├── service-B
│   ├── Dockerfile
│   ...
├── service-C
│   ├── Dockerfile
│   ...
├── infrastructure
│   ├── docker-compose-jaeger.yaml
│   │
│   ├── docker-compose-zipkin.yaml
│   ...
├── docker-compose.yaml
|
└── README.md
```

## Prerequisites
- Make sure that you have Docker and Docker Compose installed
  - Windows or macOS:
    [Install Docker Desktop](https://www.docker.com/get-started)
  - Linux: [Install Docker](https://www.docker.com/get-started) and then
    [Docker Compose](https://github.com/docker/compose)

## Start infrastructure

- Start Zipkin

```shell script
$ docker-compose -f ./infrastructure/docker-compose-zipkin.yml up -d
```

or start Jaeger (stop Zipkin if have)

```shell script
$ cd infrastructure
$ docker-compose -f ./infrastructure/docker-compose-jaeger.yml up -d
```

## Start services
### Start services in local

- Start service-A 
```shell script
$ cd service-A
$ ../mvnw clean package
$ ../mvnw spring-boot:run
...
```

- Start service-B
```shell script
$ cd service-B
$ ../mvnw clean package
$ ../mvnw spring-boot:run
...
```

- Start service-C
```shell script
$ cd service-B
$ ../mvnw clean package
$ ../mvnw spring-boot:run
...
```

### Start services in docker 

```shell script
$ docker-compose up -d
```

## Run testing

```shell script
curl http://localhost:8081/greetb/1
curl http://localhost:8081/greetc/1
```

## Stop project

- Kill project if start in local mode
- Stop infrastructure & services in docker

```shell script
$ docker-compose -f ./infrastructure/docker-compose-zipkin.yml down
```

or

```shell script
$ docker-compose -f ./infrastructure/docker-compose-jaeger.yml down
```
## Contribute

## Reference
