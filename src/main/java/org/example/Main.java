package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

       while(true){
        System.out.print("Enter command: ");
        String line = scanner.nextLine();
        String [] parts = line.split(" ",2);
        String command = parts[0];

        switch (command) {
            case "add":
                if (parts.length < 2) {
                    System.out.println("Usage: add <task description>");
                } else {
                    taskManager.addTask(parts[1]);
                }
                break;

            case "update":
                if(parts.length<3) {
                    System.out.println("Usage: update <id> <new description>");
                }else {
                    int id = Integer.parseInt(parts[1]);
             //       taskManager.updateTask(id, args[2]);
                }
                break;
            case "delete":
                if(parts.length<2) {
                    System.out.println("Usage: delete <id>");

                }else{
                    int id = Integer.parseInt(parts[1]);
                }
                break;
            default:
                System.out.println("Unknow comamnd: " + command);
        }

        }
        }

    }
    