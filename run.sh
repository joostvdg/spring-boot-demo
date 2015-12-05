#!/bin/sh

IMAGE="spring-boot-demo"
NAME="spring-boot-demo-1"

RUNNING=`docker ps | grep -c $NAME`
if [ $RUNNING -gt 0 ]
then
   echo "Stopping $NAME"
   docker stop $NAME
fi

EXISTING=`docker ps -a | grep -c $NAME`
if [ $EXISTING -gt 0 ]
then
   echo "Removing $NAME"
  docker rm $NAME
fi

echo "Create new instance $NAME based on $IMAGE"
docker run --name $NAME -p 8888:8080 -d $IMAGE

echo "Tail the logs of the new instance"
sleep 10
docker logs $NAME