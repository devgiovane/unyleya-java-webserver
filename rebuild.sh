#!/bin/bash

sudo rm -rf build/

./gradlew war

mv build/libs/api_unyleya-1.0.war build/libs/ROOT.war

docker-compose down

docker-compose up --build
