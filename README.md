# Docker Sample

This repository contains a small sample app running fully in Docker containers. Setup is powered with Docker compose. The TODO app itself is from [Shekhar Gulati](https://github.com/shekhargulati/todoapp-spark).

This repository was created as part of a introduction workshop for Docker. [Here](https://goo.gl/ZNKnmf) you can find the [slides](https://goo.gl/ZNKnmf).

![Docker Logo](https://camo.githubusercontent.com/3482fc32e1f4cad0c44039c8f01e1e270e6894ee/687474703a2f2f692e696d6775722e636f6d2f4b6764574c64682e706e67)

## Used technologies

- The backend is written in **Java 8** with the help of the [**Spark Framework**](http://sparkjava.com/) and uses [**Apache Maven**](https://maven.apache.org/) as a build tool.
- The backend depends on [**MongoDB**](https://www.mongodb.org/) for data storage.
- The frontend is written in **Javascript** and [**AngularJS**](https://angularjs.org/) and is served by a [**Nginx**](http://nginx.org/) instance.
- The proxy uses an [**Apache HTTPD 2.4**](https://httpd.apache.org/) to serve the backend API and the frontend under the same URL. Also it enabled loadbalancing the backend independently from the fronted.
- Each component of the stack runs in its own [**Docker container**](https://www.docker.com/docker-engine). The containers are on a common [**Docker network**](https://docs.docker.com/engine/userguide/networking/dockernetworks/).
- [**Docker compose**](https://docs.docker.com/compose/) is used to simplify the configuration of the containers.

## How to setup your DEV machine

1. Install [VirtualBox](https://www.virtualbox.org/wiki/Downloads) and [Vagrant](https://www.vagrantup.com/downloads.html).
2. Clone repository `git clone https://https://github.com/foxylion/docker-sample.git`

## How to start the DEV environment

1. Open a console in the cloned repository.
2. Run the command `vagrant up`
3. SSH into the DEV environment `vagrant ssh`

## Build the Docker containers

1. Run `docker-compose build`

## Run the application

1. Find out the IP of your DEV environment `ifconfig | grep "inet "`
2. Start the Docker containers `docker-compose up -d`
3. See the running containers `docker ps`
4. Connect to the TODO-App `http://[dev-ip]:80/` (e.g. http://192.168.20.55/)

## Storage of the data

The Mongo-DB instance running in a Docker containers stores its data into `/var/lib/todo` on the DEV environment so it is persisted during recreations of the containers.

