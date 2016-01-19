#!/bin/bash
set -e

apt-get update
apt-get install -y software-properties-common make git

# Install docker-engine
# We use the linux-image-extra to enable AUFS storage driver which is much more performant
apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
echo "deb https://apt.dockerproject.org/repo ubuntu-trusty main" > /etc/apt/sources.list.d/docker.list
apt-get update
apt-get install -y linux-image-extra-$(uname -r) docker-engine
gpasswd -a vagrant docker
cat <<EOF > /etc/default/docker
DOCKER_OPTS="--storage-driver=aufs"
EOF
service docker restart

# Install docker-compose
curl -L https://github.com/docker/compose/releases/download/1.5.2/docker-compose-Linux-x86_64 > /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose

# Install Java
add-apt-repository ppa:openjdk-r/ppa
apt-get update
apt-get install -y openjdk-8-jdk

# Install Maven
apt-get install -y maven

# Automatically switch to /vagrant on login
cat <<EOF > /home/vagrant/.profile
cd /vagrant
EOF

# Create the network for this sample
docker network create todo-network
