import java.util.*;

import service.TaskManager;
import util.FileHandler;
import model.User;
import model.Priority;
import model.Task;

public class Main {
  public static void main(String[] args) {

    try (Scanner sc = new Scanner(System.in)) {
      TaskManager manager = new TaskManager();

      // Load data
      manager.getUsers().addAll(FileHandler.loadUsers("data/users.txt"));

      User currentUser = null;
      while (true) {
        // ===== AUTH =====
        while (currentUser == null) {
          System.out.println("\n1.Sign Up 2.Sign In 3.Exit");
          int ch = Integer.parseInt(sc.nextLine());

          if (ch == 1) {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());

            if (manager.isDuplicateId(id)) {
              System.out.println("❌ ID already exists!");
              continue;
            }

            System.out.println("First Name: ");
            String fname = sc.nextLine();

            System.out.println("Last Name: ");
            String lname = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            if (manager.isDuplicateEmail(email)) {
              System.out.println("❌ Email already exists!");
              continue;
            }

            System.out.print("Username: ");
            String uname = sc.nextLine();

            if (manager.isDuplicateUsername(uname)) {
              System.out.println("❌ Username already exists!");
              continue;
            }

            System.out.print("Password: ");
            String pass = sc.nextLine();

            manager.register(new User(id, fname, lname, email, uname, pass));

          } else if (ch == 2) {

            System.out.print("Username: ");
            String u = sc.nextLine();

            System.out.print("Password: ");
            String p = sc.nextLine();

            currentUser = manager.login(u, p);

            if (currentUser == null)
              System.out.println("❌ Invalid login!");
            else
              System.out.println("✅ Welcome " + currentUser.getName());

          } else
            return;
        }

        // ===== MAIN MENU =====
        System.out.println("\n===== TODO TASK MANAGER =====");
        System.out.println("1. View Users");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");

        System.out.println("4. Assign Task");
        System.out.println("5. My Tasks");
        System.out.println("6. Update Task");
        System.out.println("7. Board");
        System.out.println("8. Update Priority");
        System.out.println("9. Logout");
        System.out.print("Choice: ");

        int choice = Integer.parseInt(sc.nextLine());

        try {
          switch (choice) {
            case 1:
              manager.viewUsers();
              break;

            case 2:
              System.out.print("UserID: ");
              int uid = Integer.parseInt(sc.nextLine());

              System.out.print("First Name: ");
              String fn = sc.nextLine();

              System.out.print("Last Name: ");
              String ln = sc.nextLine();

              System.out.print("New Email: ");
              String em = sc.nextLine();

              System.out.print("New Username: ");
              String usr = sc.nextLine();

              System.out.print("New Password: ");
              String pass = sc.nextLine();

              boolean updated = manager.updateUser(uid, fn, ln, em, usr, pass);

              if (updated) {
                FileHandler.saveUsers("data/users.txt", manager.getUsers());
              }
              break;

            case 3:
              System.out.print("UserID: ");
              int deleteId = Integer.parseInt(sc.nextLine());

              boolean deleted = manager.deleteUser(deleteId);

              if (deleted) {
                FileHandler.saveUsers("data/users.txt", manager.getUsers());
              }
              break;

            case 4:
              System.out.print("Task ID: ");
              int tid = Integer.parseInt(sc.nextLine());

              if (manager.isDuplicateTaskId(tid)) {
                System.out.println("❌ Task ID already exists!");
                break;
              }

              System.out.print("Description: ");
              String desc = sc.nextLine();

              System.out.println("1.HIGH 2.MEDIUM 3.LOW");
              Priority pr = switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> Priority.HIGH;
                case 2 -> Priority.MEDIUM;
                case 3 -> Priority.LOW;
                default -> Priority.LOW;
              };

              manager.displayUsersList();
              System.out.print("Assign To: ");
              User to = manager.getUserByIndex(Integer.parseInt(sc.nextLine()) - 1);

              if (to != null) {
                manager.assignTask(new Task(
                    tid, desc, pr,
                    currentUser.getName(),
                    to.getName()));
              }
              break;

            case 5:
              manager.viewTasksByUser(currentUser.getName());
              break;

            case 6:
              System.out.println("\n--- YOUR TASKS ---");
              manager.viewTasksByUser(currentUser.getName());

              System.out.print("Enter Task ID: ");
              int t = Integer.parseInt(sc.nextLine());

              System.out.println("1.TODO 2.IN_PROGRESS 3.PENDING 4.COMPLETED");
              int statusChoice = Integer.parseInt(sc.nextLine());

              String status = null;

              switch (statusChoice) {
                case 1:
                  status = "TODO";
                  break;
                case 2:
                  status = "IN_PROGRESS";
                  break;
                case 3:
                  status = "PENDING";
                  break;
                case 4:
                  status = "COMPLETED";
                  break;
                default:
                  System.out.println("❌ Invalid status!");
                  break;
              }

              manager.updateTaskStatus(t, status, currentUser.getName());
              break;

            case 7:
              manager.displayBoard();
              break;

            case 8:
              System.out.println("\n--- YOUR TASKS ---");
              manager.viewTasksByUser(currentUser.getName());

              System.out.print("Enter Task ID: ");
              int pid = Integer.parseInt(sc.nextLine());

              System.out.println("1.HIGH 2.MEDIUM 3.LOW");
              int pChoice = Integer.parseInt(sc.nextLine());

              Priority newPriority = switch (pChoice) {
                case 1 -> Priority.HIGH;
                case 2 -> Priority.MEDIUM;
                case 3 -> Priority.LOW;
                default -> Priority.LOW;
              };

              manager.updateTaskPriority(pid, newPriority, currentUser.getName());
              break;

            case 9:
              currentUser = null;
              System.out.println("👋 Logged out!");
              break;
          }

        } catch (Exception e) {
          System.out.println("Invalid input!");
          sc.nextLine(); // clear buffer
        }
      }
    }
  }
}