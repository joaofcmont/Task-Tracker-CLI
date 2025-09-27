#!/bin/bash

# Get the directory where the script is located
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Look for the main JAR file
JAR_FILE="$SCRIPT_DIR/target/TaskTrackerCLI-1.0-SNAPSHOT.jar"

# Fallback: look for task-cli.jar in current directory
if [ ! -f "$JAR_FILE" ] && [ -f "$SCRIPT_DIR/task-cli.jar" ]; then
    JAR_FILE="$SCRIPT_DIR/task-cli.jar"
fi

# Fallback: find any JAR in target
if [ ! -f "$JAR_FILE" ]; then
    JAR_FILE=$(find "$SCRIPT_DIR/target" -name "TaskTrackerCLI*.jar" -not -name "original-*" 2>/dev/null | head -1)
fi

if [ -f "$JAR_FILE" ]; then
    echo "Using JAR: $JAR_FILE"
    # Add the lib directory to classpath for dependencies
    LIB_DIR="$SCRIPT_DIR/target/lib"
    if [ -d "$LIB_DIR" ]; then
        java -cp "$JAR_FILE:$LIB_DIR/*" org.example.Main "$@"
    else
        java -jar "$JAR_FILE" "$@"
    fi
else
    echo "Error: No JAR file found!"
    echo "Please build the project first with 'mvn clean package'"
    echo "Looking for: $SCRIPT_DIR/target/TaskTrackerCLI-1.0-SNAPSHOT.jar"
    exit 1
fi