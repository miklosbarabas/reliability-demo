# Reliability demo

This project was developed to demonstrate a Spring application using Micrometer.io and monitored with Prometheus and Grafana.
To showcase some of the features the application is using Spring Chaos Monkey* and a load-generator is created using Gatling. 
Grafana dashboards are provisioned to visualize the metrics collected by Prometheus.

## Getting started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

You must have [docker](https://docs.docker.com/) & [docker-compose](https://docs.docker.com/compose/) installed. 

### Building and running

1. Clone or download the repository

2. Build & Run

    At the root of the project:
    ```
    docker-compose up 
    ```
    or if you want to rebuild the docker images:
    ```
    docker-compose up --build
    ```
    This method is using Docker's MultiStage build which creates an intermediary container with the build dependencies 
    to build the artifact which is than copied to the run-container and a Docker image is created out of it.
    This way you do not have to install anything besides Docker and Docker Compose does that for you inside containers.

### Endpoints
  - the application API: http://localhost:8080/dummy
  - Swagger API documentation: http://localhost:8080/swagger-ui.html
  - Prometheus: http://localhost:9090
  - Grafana: http://localhost:3000


## Chaos Monkey
Chaos Monkey for Spring Boot by Codecentric is being used to inject failures (assaults) to the application. 
There are endpoints provided from you can modify these on-the-fly. You can use all these from the Swagger in a convenient way.
A small modification has been introduced to this library by overriding the `AssaultProperties` class to be able to 
configure less frequent assaults than 10% (e.g. `chaos.monkey.assaults.level=100`).
## Built with

* [Spring](https://spring.io/) - The web framework
* [Micrometer](http://micrometer.io/) - Vendor-neutral application metrics facade
* [Chaos Monkey for Spring Boot](https://codecentric.github.io/chaos-monkey-spring-boot/) - Chaos Engineering tool for Spring
* [Maven](https://maven.apache.org/) - Dependency management
* [Grafana](https://grafana.com/) - Analytics & monitoring
* [Prometheus](https://prometheus.io/) - Monitoring backend
* [Gatling](https://gatling.io/) - Load & performance testing library
* [Docker](https://www.docker.com) & [Docker Compose](https://www.docker.com) - Containerization & orchestration


## Author

**Miklos Barabas** - [GitHub](https://github.com/miklosbarabas)
