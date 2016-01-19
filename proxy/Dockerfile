FROM ubuntu:wily

RUN apt-get update && apt-get install -y apache2

COPY apache2.conf /apache2.conf
RUN mkdir /logs

ENV APACHE_LOCK_DIR /tmp
ENV APACHE_PID_FILE /tmp/apache2.pid
ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /logs

CMD apache2 -f /apache2.conf -DFOREGROUND

VOLUME /logs
EXPOSE 80
