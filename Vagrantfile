# You can use this VM to analyze the environment

# You can call this like:
# $ DIR=./testing HEADLESS=YES vagrant up
# or
# $ FILE=test.txt HEADLESS=YES vagrant up

Vagrant.configure("2") do |config|
  config.vm.box = "kalilinux/rolling"

  # You can define a single file to import to the machine or ...
  if ENV['FILE'] != nil
    config.vm.provision "file", source: ENV['FILE'], destination: "/home/vagrant/imported/"+ENV['FILE']
  end

  # ... you can import an entire directory
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