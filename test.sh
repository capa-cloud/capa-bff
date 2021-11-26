#!/usr/bin/env bash


checkJavaVersion=$(java -version)
if [[ $checkJavaVersion != *"1.8"* ]]; then
 export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.8.jdk/Contents/Home
fi

cd ./capa-bff-example-dependency/ && mvn clean && mvn package -Dmaven.test.skip=true

java -jar ./target/capa-bff-example-dependency-0.0.1-SNAPSHOT.jar

