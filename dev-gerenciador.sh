#!/bin/bash
cd Gerenciador && ./gradlew installDist %% cd ..
docker compose run gerenciador