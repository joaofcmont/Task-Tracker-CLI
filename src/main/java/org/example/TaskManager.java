package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {


    Gson gson = new Gson();
    Type taskListType = new TypeToken<List<Task>>(){}.getType();

    private List<Task> tasks = new ArrayList<>();
    private int id =0;

    protected void saveInFile() throws IOException {
        try (Writer writer = new FileWriter("src/tasks.json")) {
            gson.toJson(tasks, writer);
        }

    }

    protected void loadJson() throws IOException {
        File file = new File("src/tasks.json");
        if (file.exists() && file.length() != 0) {
            try (Reader reader = new FileReader(file)) {
                tasks = gson.fromJson(reader, taskListType);
            }
            if (!tasks.isEmpty()) {
                id = tasks.get(tasks.size() - 1).getId();
            }
        }
    }

    void addTask(String args) throws IOException {
        id++;
        Task newTask = new Task(id,args,Status.TODO);
        tasks.add(newTask);
        saveInFile();
        System.out.printf("%nTask added sucessfully with id: %d%n", id );
    }

    void deleteTask(String idStr) throws IOException {
        try {
            int taskId = Integer.parseInt(idStr);
            boolean removed = tasks.removeIf(task -> task.getId() == taskId);

            if (removed) {
                saveInFile();
                System.out.printf("Task with id %d deleted successfully%n", taskId);
            } else {
                System.out.printf("Task with id %d not found%n", taskId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid task ID. Please provide a valid number.");
        }
    }

    void listTasks() {
        listTasks(null); // Show all tasks by default
    }

    void listTasks(String statusFilter) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        List<Task> filteredTasks = new ArrayList<>();

        if (statusFilter == null) {
            filteredTasks = tasks;
        } else {
            Status filterStatus;
            try {
                filterStatus = Status.valueOf(statusFilter.toUpperCase());
                for (Task task : tasks) {
                    if (task.getStatus().equals(filterStatus)){
                        filteredTasks.add(task);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status filter. Use: TODO, IN_PROGRESS, or DONE");
                return;
            }
        }

        if (filteredTasks.isEmpty()) {
            System.out.println("No tasks found with status: " + statusFilter);
            return;
        }

        System.out.println("\nTasks" + ":");
        for (Task task : filteredTasks) {
            System.out.printf("%d. %s [%s]%n",
                    task.getId(),
                    task.getDescription(),
                    task.getStatus()
            );
        }
    }



}
