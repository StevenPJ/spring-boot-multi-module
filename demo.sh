#!/bin/bash

curl -X POST http://localhost:8080/chelsea/updates\?player\=kante\&action\=scored\&score\=1-0
sleep 1s
curl -X POST http://localhost:8080/arsenal/updates\?player\=ozil\&action\=missed\&score\=1-0
sleep 1s
curl -X POST http://localhost:8080/chelsea/updates\?player\=giroud\&action\=scored\&score\=2-0
sleep 1s
curl -X POST http://localhost:8080/arsenal/updates\?player\=ozil\&action\=scored\&score\=2-1