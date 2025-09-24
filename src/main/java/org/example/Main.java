package org.example;

public class Main {
    public static void main(String[] args) throws Exception{
        TaskManager taskManager = new TaskManager();

        if(args.length==0){
            System.out.println("Please provide a command :)");
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

            case "update":
                if(args.length<3) {
                    System.out.println("Usage: update <id> <new description>");
                }else {
                    int id = Integer.parseInt(args[1]);
                    taskManager.updateTask(id, args[2]);
                }
                break;
            case "delete":
                if(args.length<2) {
                    System.out.println("Usage: delete <id>");

                }
            default:
                System.out.println("Unknow comamnd: " + command);
        }

        }

    }
    