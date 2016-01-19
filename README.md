# Docker Sample

This repository contains a small sample app running fully in docker containers. Setup is powered with docker-compose.

The TODO app itself is from [Shekhar Gulati](https://github.com/shekhargulati/todoapp-spark).

![Docker Logo](https://camo.githubusercontent.com/3482fc32e1f4cad0c44039c8f01e1e270e6894ee/687474703a2f2f692e696d6775722e636f6d2f4b6764574c64682e706e67)

## How to setup your DEV machine

1. Install [VirtualBox](https://www.virtualbox.org/wiki/Downloads) and [Vagrant](https://www.vagrantup.com/downloads.html).
2. Clone repository `git clone https://https://github.com/foxylion/docker-sample.git`

## How to start the DEV environment

1. Open a console in the cloned repository.
2. Run the command `vagrant up`
3. SSH into the DEV environment `vagrant ssh`

## Build the docker containers

1. Run `docker-compose build`

## Run the application the DEV environment

1. Find out the IP of your DEV environment `ifconfig | grep "inet "`
2. Start the docker containers `docker-compose up -d`
3. See the running containers `docker ps`
4. Connect to the TODO-App `http://[dev-ip]:80/` (e.g. http://192.168.20.55/)

## Storage of the data

The Mongo-DB instance running in a docker containers stores its data into `/var/lib/todo` on the DEV environment so it is persisted during recreations of the containers.
