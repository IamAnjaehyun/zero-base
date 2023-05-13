docker run -d \
--name fintech-mysql \
-e platform=linux/x86_64 \
-e MYSQL_ROOT_PASSWORD="fintech" \
-e MYSQL_USER="fintech" \
-e MYSQL_PASSWORD="fintech" \
-e MYSQL_DATABASE="fintech" \
-p 3306:3306 \
--network docker_fintech mysql:latest