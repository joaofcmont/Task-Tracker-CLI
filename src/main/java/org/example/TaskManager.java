package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
            // Restore id counter to the last task id
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


}
