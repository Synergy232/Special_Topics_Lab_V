#!/usr/bin/env bash

cd docker/

docker build --network=host -t edu.cscc.special-topics/jenkins .
