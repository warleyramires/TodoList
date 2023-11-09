package entities;

import java.util.ArrayList;
import java.util.List;

public class TodoListApp {
    private ArrayList<Task> listTask = new ArrayList<>();

    public TodoListApp() {
    }

    public TodoListApp(ArrayList<Task> listTask) {
        this.listTask = listTask;
    }

    public ArrayList<Task> getListTask() {
        return listTask;
    }

    public void addTask(Task task) {
        listTask.add(task);
    }

    public void viewTasks(){
        for(Task task : listTask){
            System.out.println(task);
        }
    }

    public void markTaskAsDone(Task task, String newStatus){
        task.setStatus(newStatus);
    }

    public void removeTask(Task task){
        listTask.remove(task);
    }

    public Task findTaskByTitle(String title) {
        for (Task task : listTask) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }
        return null;
    }
    public Boolean removeTaskByTitle(String title) {
        Task taskToRemove = null;

        for (Task task : listTask) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove != null) {
            listTask.remove(taskToRemove);
            return true;
        } else {
            return false;
        }
    }


}
