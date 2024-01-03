# Camel Service
This services handles the integration between our services in our application. For the purpose of our assignment we will be using different types of communication protocols such as gRpc, Rest,
RabbitMQ, GraphQL and SOAP. This service will be responsible for the integration between the different services and the communication between them.

# Routes
We have implemented 2 routes, consisting of:
- Order Service -> Restaurant Service
  - This route gets the restaurant entites to check the order has correct items
- Camunda Service -> Restaurant Service
  - This route creates a restaurant entity in the database, after an application validation 

# Tech Stack
* Apache Camel
* RabbitMQ
