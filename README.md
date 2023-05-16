Project for testing spring actuator (incl. prometheus)

Requirements
* Spring Boot project v3.0.6
* Java v17

Endpoints:
* GET http://localhost:8080/api/v1/greet   -  get greeting message 

Actuator's endpoints:
* GET http://localhost:8080/actuator
* GET http://localhost:8080/actuator/health
* GET http://localhost:8080/actuator/prometheus
* GET http://localhost:8080/actuator/metrics
* GET http://localhost:8080/actuator/metrics/{requiredMetricName}