# Multi Module Spring Boot Demo

## Overview
This app has a central application that receives and prints football match updates from two clubs: Arsenal and Chelsea.
The two clubs have their own mechanism for generating updates, however they both publish the updates to the central service using a predefined contract.

### Demo
To build and run the application, from the root: 
```
./mvnw clean package
java -jar application/target/application-0.0.1-SNAPSHOT.jar
```  
You can then send a few example events, to each club
```
./demo.sh
```
Each club then publishes the events to the application
```
CFC: kante scored. SCORE: 1-0
ARS: ozil missed. SCORE: 1-0
CFC: giroud scored. SCORE: 2-0
ARS: ozil scored. SCORE: 2-1
```

To run the 'jms' demo, run the below
```
git checkout jms
./mvnw clean package
docker-compose up -d
docker logs -f application
```
and then run the same demo and compare results
```
./demo.sh
```

### Modules
The application defines an event listener on the `MatchUpdate` type. Each club exposes their own HTTP endpoints to receive updates
from their staff at the game, however they compose their own `MatchUpdate` instances and publish them onto the event stream.
On the `master` branch, events are published using [Springs Event mechanism](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#context-functionality-events), and the two clubs systems are published as JARs whose components are loaded into the main applications Spring Context.

On the `jms` branch, the clubs apps become independently deployable, using JMS for event publishing.