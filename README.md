Getting Started
Reference Documentation
For further reference, please consider the following sections:

Official Apache Maven documentation
Spring Boot Maven Plugin Reference Guide
Create an OCI image
Run instructions from terminal:

./mvnw install - In order to build the jar
docker build --build-arg JAR_FILE=target/*.jar -t playersapp . - To build docker image
docker run -p 8081:8081 playersapp - To create and run container from the above image listening on port 8081
TODO if I had infinite time:

Local Cache
Pagination
Add Documentation
