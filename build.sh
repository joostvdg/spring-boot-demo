#!/bin/sh
TAGNAME="spring-boot-demo"

echo "Building new image with tag: $TAGNAME"
docker build --tag=$TAGNAME .