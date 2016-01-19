FROM centos:7
MAINTAINER Jakob Jarosch <dev@jakobjarosch.de>

RUN yum install -y java-1.8.0-openjdk-devel
ENV JAVA_HOME /usr/lib/jvm/jre-1.8.0-openjdk

RUN yum install -y unzip

RUN curl -L http://www.eu.apache.org/dist/maven/maven-3/3.3.3/binaries/apache-maven-3.3.3-bin.zip > /tmp/maven.zip
RUN unzip /tmp/maven.zip
RUN chmod +x /apache-maven-3.3.3/bin/mvn
RUN ln -s /apache-maven-3.3.3/bin/mvn /usr/bin/mvn

COPY . /source
RUN cd /source && mvn package

CMD java -jar /source/target/todoapp-1.0-SNAPSHOT.jar

ENV MONGODB_HOST     mongo
ENV MONGODB_NAME     todo
ENV MONGODB_USERNAME mongo
ENV MONGODB_PASSWORD mongo

EXPOSE 8080
