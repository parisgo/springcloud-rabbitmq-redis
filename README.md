# springcloud-h2-rabbitmq-redis
Spring Boot/Cloud, H2, RabbitMQ, Redis


1: Start project **sctest-service** for Eureka Server
http://localhost:8761/
![enter image description here](https://raw.githubusercontent.com/parisgo/springcloud-rabbitmq-redis/master/docs/images/01.png)

2: Start project **sctest-app** for web application

3: Start project **sctest-cache** for add cache to Redis

now, we could find 2 services in Eureka
![enter image description here](https://raw.githubusercontent.com/parisgo/springcloud-rabbitmq-redis/master/docs/images/02.png)


**4: Test web application**   

![enter image description here](https://raw.githubusercontent.com/parisgo/springcloud-rabbitmq-redis/master/docs/images/03.png)

![enter image description here](https://raw.githubusercontent.com/parisgo/springcloud-rabbitmq-redis/master/docs/images/04.png)

**5: Check info in RabbitMQ**
![enter image description here](https://raw.githubusercontent.com/parisgo/springcloud-rabbitmq-redis/master/docs/images/05.png)

6: Check info in Redis
![enter image description here](https://raw.githubusercontent.com/parisgo/springcloud-rabbitmq-redis/master/docs/images/06.png)
