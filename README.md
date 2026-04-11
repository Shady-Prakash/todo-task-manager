# 📝 Todo Task Manager (Java)

A console-based **Task Manager application** built using Java that allows users to manage users and assign tasks with priority and status tracking — similar to a basic GitLab-style task board.

---

# 🚀 Getting Started

Follow these steps to run the project on your system.

---

## 📋 Prerequisites

Make sure you have:

- Java JDK 8 or higher  
- Git installed  
- Any IDE (VS Code / IntelliJ / Eclipse)

Check Java installation:

```
java -version
```
# 📥 Installation
# Step 1: Clone Repository

```
git clone https://github.com/your-username/todo-task-manager.git
cd todo-task-manager
```

# 📁 Project Structure

```
todo-task-manager/
│
├── data/
│   └── users.txt
│
├── src/
│   ├── model/
│   │   ├── Person.java
│   │   ├── User.java
│   │   └── Task.java
│   │
│   ├── service/
│   │   └── TaskManager.java
│   │
│   ├── util/
│   │   └── FileHandler.java
│   │
│   └── Main.java
│
├── bin/
├── .gitignore
└── README.md
```

# ⚙️ Dependency Management
This project uses core Java only:

No external libraries
No Maven or Gradle required
Uses built-in packages:
* `java.util.*`
* `java.io.*`

# 🛠️ Build & Run
# Step 1: Compile

```
javac -d bin src/**/*.java
```

# Step 2: Run
```
java -cp bin Main
```


# 🧑‍💻 Usage Guide

# Step 1: Launch Application

```
===== TODO TASK MANAGER =====
1. Add User
2. View Users
3. Assign Task
4. View Tasks by User
5. Update Task Status
6. View Task Board
7. Exit
```

# Step 2: Add Users

```
ID: 1
First Name: Prakash
Last Name: Mahat
Email: prakash@email.com
```

# Step 3: Assign Task

* Enter Task ID and Description
* Select Priority:
  * HIGH
  * MEDIUM
  * LOW
* Choose users from dropdown list
* Assign using:
  * Assigned By
  * Assigned To

# Step 4: Update Task Status
Available statuses:
* TODO
* IN_PROGRESS
* PENDING
* COMPLETED

# Step 5: View Tasks by User
* Enter full name
* Displays tasks assigned to that user

# Step 6: View Task Board
```
=========== TASK BOARD ===========

--- TODO ---
ID    Description         Status       Priority   Assigned By         Assigned To

--- IN_PROGRESS ---
...

--- PENDING ---
...

--- COMPLETED ---
...
```

# Step 7: Save & Exit
* Select option 7
* Data is saved automatically to:
`data/users.txt`


# 📌 Data Format
### users.txt
`id,firstName,lastName,email`

# 🧠 Concepts Used
* Object-Oriented Programming (OOP)
* Inheritance & Abstraction
* Java Collections (ArrayList)
* File Handling (Scanner, FileWriter)
* Exception Handling
* CLI-based UI Design

# Features
* User Management (Add / View)
* Task assignment between users
* Dropdown-style user selection
* Multi-stage task tracking
* Priority-based tasks
* Kanban-style task board

# 👨‍💻 Author
Prakash Mahat