![](D:\projek\BE\test-panemu\imgtest.png)

- Api 1 = main-app
- Api 3 = external-service
- Api 2 = api2-service

## prepare
- create your database with the name api2 or something else
- open the docker-compose file and adjust the database name, username and password for your database

## run
- . build-image.sh
- docker-compose up

## test api
- json data 
    http://localhost:8080/main/data
- xml data
  http://localhost:8080/api2/post
