package model;

public class Task {
  private int taskId;
  private String description;
  private String status; // Pending, Completed

  public Task(int taskId, String description) {
    this.taskId = taskId;
    this.description = description;
    this.status = "Pending";
  }

  public int getTaskId() {
    return taskId;
  }

  public void markCompleted() {
    status = "Completed";
  }

  public String toFileString() {
    return taskId + "," + description + "," + status;
  }

  public void display() {
    System.out.println("Task ID: " + taskId + ", Desc: " + description + ", Status: " + status);
  }
}