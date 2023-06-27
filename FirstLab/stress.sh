#!/bin/bash
seq 0 5000 | xargs -P4 -I{} curl http://localhost:8080/task?str=шалаш &
wait