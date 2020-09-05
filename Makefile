
env:
	cd ./docker/ && docker-compose up

activemq:
	cd ./docker/ && docker-compose up activemq

mysql:
	cd ./docker/ && docker-compose up mysql mysql-adminer

