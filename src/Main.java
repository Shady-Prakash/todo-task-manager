import java.util.*;

import service.TaskManager;
import util.FileHandler;
import model.User;
import model.Task;

public class Main {
  public static void main(String[] args) {

    try (Scanner sc = new Scanner(System.in)) {
      TaskManager manager = new TaskManager();

      // Load data
      manager.getUsers().addAll(FileHandler.loadUsers("data/users.txt"));

      while (true) {
        System.out.println("\n===== TODO TASK MANAGER =====");
        System.out.println("1. Add User");
        System.out.println("2. View Users");
        System.out.println("3. Assign Task");
        System.out.println("4. View Tasks by User");
        System.out.println("5. Update Task Status");
        System.out.println("6. View Task Board");
        System.out.println("7. Exit");
        System.out.print("Choice: ");

        int choice = Integer.parseInt(sc.nextLine());
        ;

        try {
          switch (choice) {
            case 1:
              System.out.print("Enter ID: ");
              int id = Integer.parseInt(sc.nextLine());

              if (manager.isDuplicateId(id)) {
                System.out.println("❌ ID already exists! Try again.");
                break;
              }

              System.out.println("Enter First Name: ");
              String fname = sc.nextLine();

              System.out.println("Enter Last Name: ");
              String lname = sc.nextLine();

              System.out.print("Enter Email: ");
              String email = sc.nextLine();

              if (manager.isDuplicateEmail(email)) {
                System.out.println("❌ Email already exists! Try again.");
                break;
              }

              manager.addUser(new User(id, fname, lname, email));
              break;

            case 2:
              manager.viewUsers();
              break;

            case 3:
              System.out.print("Task ID: ");
              int tid = Integer.parseInt(sc.nextLine());

              System.out.print("Description: ");
              String desc = sc.nextLine();

              System.out.println("Priority: 1.HIGH 2.MEDIUM 3.LOW");
              int p = Integer.parseInt(sc.nextLine());

              String priority = switch (p) {
                case 1 -> "HIGH";
                case 2 -> "MEDIUM";
                case 3 -> "LOW";
                default -> "LOW";
              };

              manager.displayUsersList();
              System.out.print("Assigned By: ");
              User from = manager.getUserByIndex(Integer.parseInt(sc.nextLine()) - 1);

              manager.displayUsersList();
              System.out.print("Assigned To: ");
              User to = manager.getUserByIndex(Integer.parseInt(sc.nextLine()) - 1);

              if (from == null || to == null) {
                System.out.println("❌ Invalid selection!");
                break;
              }

              manager.assignTask(new Task(
                  tid,
                  desc,
                  priority,
                  from.getName(),
                  to.getName()));
              break;

            case 4:
              // System.out.print("Enter ID: ");
              // manager.deleteUser(sc.nextInt());
              // break;
              System.out.print("Enter Full Name: ");
              String name = sc.nextLine();
              manager.viewTasksByUser(name);

            case 5:
              System.out.print("Task ID: ");
              int t = Integer.parseInt(sc.nextLine());

              System.out.println("1.TODO 2.IN_PROGRESS 3.PENDING 4.COMPLETED");
              int c = Integer.parseInt(sc.nextLine());

              String status = switch (c) {
                case 1 -> "TODO";
                case 2 -> "IN_PROGRESS";
                case 3 -> "PENDING";
                case 4 -> "COMPLETED";
                default -> "TODO";
              };

              manager.updateTaskStatus(t, status);
              break;

            case 6:
              manager.displayBoard();
              break;

            case 7:
              FileHandler.saveUsers("data/users.txt", manager.getUsers());
              System.out.println("Saved. Exiting...");
              return;
          }
        } catch (Exception e) {
          System.out.println("Invalid input!");
          sc.nextLine(); // clear buffer
        }
      }
    }
  }
}