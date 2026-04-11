package model;

public class Task {
  private int taskId;
  private String description;
  private String status; // TODO, IN PROGRESS, PENDING, COMPLETED
  private String priority; // HIGH, MEDIUM, LOW
  private String assignedBy;
  private String assignedTo;

  public Task(int taskId, String description, String priority,
      String assignedBy, String assignedTo) {
    this.taskId = taskId;
    this.description = description;
    this.priority = priority;
    this.assignedBy = assignedBy;
    this.assignedTo = assignedTo;
    this.status = "TODO";
  }

  public int getTaskId() {
    return taskId;
  }

  public String getStatus() {
    return status;
  }

  public String getAssignedTo() {
    return assignedTo;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void display() {
    System.out.printf("%-5d %-20s %-12s %-10s %-20s %-20s\n",
        taskId, description, status, priority, assignedBy, assignedTo);
  }
}