#!/usr/bin/env sh

APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")

DIRNAME=$(dirname "$0")

CLASSPATH="$DIRNAME/gradle/wrapper/gradle-wrapper.jar"

exec java -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
