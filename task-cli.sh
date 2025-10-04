#!/bin/bash

INSTALL_DIR="/usr/local/share/task-cli"
JAR_FILE="$INSTALL_DIR/TaskTrackerCLI-1.0-SNAPSHOT-shaded.jar"

# User data directory
DATA_DIR="$HOME/.task-cli"
DATA_FILE="$DATA_DIR/tasks.json"

# Ensure data dir exists
if [ ! -d "$DATA_DIR" ]; then
    mkdir -p "$DATA_DIR"
fi

# Ensure tasks.json exists
if [ ! -f "$DATA_FILE" ]; then
    echo "[]" > "$DATA_FILE"
fi

# Run CLI
if [ -f "$JAR_FILE" ]; then
  java -jar "$JAR_FILE" "$@"
else
    echo "Error: Task CLI not installed correctly!"
    echo "Expected JAR at: $JAR_FILE"
    exit 1
fi
