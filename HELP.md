# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)


Run instructions from terminal:
1. ./mvnw install - In order to build the jar
2. docker build --build-arg JAR_FILE=target/\*.jar -t playersapp . - To build docker image
3. docker run -p 8081:8081 playersapp - To create and run container from the above image listening on port 8081

TODO if I had infinite time:
1. Local Cache
2. Pagination
3. Add Documentation
