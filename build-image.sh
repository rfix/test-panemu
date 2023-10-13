cd service-registry
mvn clean package
docker build -t service-registry .
cd ..

cd gateway
mvn clean package
docker build -t gateway .
cd ..

cd main-app
mvn clean package
docker build -t main-app .
cd ..

cd external-service
mvn clean package
docker build -t external-service .
cd ..

cd api2-service
mvn clean package
docker build -t api2-service .