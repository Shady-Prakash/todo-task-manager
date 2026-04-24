package model;

public class Task {
  private int taskId;
  private String description;
  private String status;
  private Priority priority;
  private String assignedBy;
  private String assignedTo;

  public Task(int taskId, String description, Priority priority,
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

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public String getAssignedTo() {
    return assignedTo;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void display() {
    System.out.printf("%-5d %-20s %-12s %-10s %-20s %-20s\n",
        taskId, description, status, priority.name(), assignedBy, assignedTo);
  }
}