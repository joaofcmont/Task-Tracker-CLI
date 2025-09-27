package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskManager taskManager = new TaskManager();
        taskManager.loadJson();

        if (args.length == 0) {
            System.out.println("Usage: taskmanager <add|update|delete> [parameters]");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: taskmanager add <task description>");
                } else {
                    taskManager.addTask(args[1]);
                }
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}

    