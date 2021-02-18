FROM mysql:5.7.33

COPY ./init_database.sql /tmp/
RUN cat /tmp/init_database.sql >> /docker-entrypoint-initdb.d/init.sql