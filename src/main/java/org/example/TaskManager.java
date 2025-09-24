package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {


    Gson gson = new Gson();
    Type taskListType = new TypeToken<List<Task>>(){}.getType();

    private List<Task> tasks = new ArrayList<>();

    protected void loadJson() throws IOException {
        FileReader reader = new FileReader("src/tasks.json");
        tasks = gson.fromJson(reader,taskListType);
        reader.close();
    }

    void addTask(String args){

    }


}
