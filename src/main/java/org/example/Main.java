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
                    System.out.println("Usage: add <task description>");
                } else {
                    taskManager.addTask(args[1]);
                }
                break;
            case "delete":
                if(args.length < 2){
                    System.out.println("Usage: delete <task id>");
                }else{
                    taskManager.deleteTask(args[1]);
                }
                break;
            case "update":
                if(args.length <3){
                    System.out.println("Usage: update <task id> <updated description>");
                }else{
                    taskManager.updateTask(args[1],args[2]);
                }
                break;
            case "list":
                if (args.length == 1) {
                    taskManager.listTasks();
                } else if (args.length == 2) {
                    taskManager.listTasks(args[1]);
                } else {
                    System.out.println("Usage: list [todo|in_progress|done]");
                }
                break;

            default:
                System.out.println("Unknown command: " + command);
        }
    }
}

    