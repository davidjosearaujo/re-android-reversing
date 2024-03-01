# You can use this VM to analyze the environment

Vagrant.configure("2") do |config|
  config.vm.box = "kalilinux/rolling"

  # You can tweek your VM's CPU cores and memory
  config.vm.provide "virtualbox" do |v|
    v.cpus = 2
    v.memory = 4
  end

  # Defining an envrionment variable with a directory path when 
  # calling 'vagrant up' will result ins the import of that directory
  if ENV['DIR'] != nil
    config.vm.provision "file", source: ENV['DIR'], destination: "/home/vagrant/imported"
  end

  # If you don't need GUI... pros usually don't ;)
  if ENV['HEADLESS'] == "YES"
    config.vm.provider "virtualbox" do |v|
      v.gui = false
    end
  end
end

# You can call this like:
# $ DIR=./testing HEADLESS=YES vagrant up