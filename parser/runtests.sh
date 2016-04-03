#!/bin/bash
#Compiles and runs all tests
for i in {1..7};
do
    ./antlr3 camle "test$i.w"
    if ((i == 5))
    then
        ./assmule -j "test$i.ass"
    else
        ./assmule "test$i.ass"
    fi
done
