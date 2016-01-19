Vagrant.configure("2") do |config|
  config.ssh.shell = "bash"

  config.vm.box = "ubuntu/wily64"
  config.vm.provision :shell, inline: "hostnamectl set-hostname docker-sample.local"
  config.vm.network "private_network", type: "dhcp"

  config.vm.provision "shell", path: "Vagrantfile.bootstrap.sh"

  config.vm.provider "virtualbox" do |v|
    v.memory = 2048
    v.cpus = 2
  end
end
