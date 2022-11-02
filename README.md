# Yet Another Linux Distro - Build Repository

## Build

```
$ git clone https://github.com/meisteg/yald-build.git
$ cd yald-build
$ ./repo-mgr.sh install
$ ./repo-mgr.sh init
$ ./run-build.sh
```

### Supported machines

- raspberrypi3-64

## Links
https://docs.yoctoproject.org/dev-manual/index.html
https://www.lancesimms.com/RaspberryPi/HackingRaspberryPi4WithYocto_Introduction.html


Use ip command to bring up the wifi interface:
sudo ip link set wlan0 up
/sbin/ifconfig wlan0 up
iw commands

iw dev wlan0 scan