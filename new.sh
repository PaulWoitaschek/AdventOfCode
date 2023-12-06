#!/bin/bash

set -e

./gradlew :prepare:installDist -q
./prepare/build/install/prepare/bin/prepare
