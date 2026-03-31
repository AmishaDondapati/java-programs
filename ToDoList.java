package java_tasks;
import java.util.*;
import java.io.*;

public class ToDoList
{
	static Map<String, List<Task>> dateWiseTasks = new HashMap<>();
    static final String FILE_NAME = "src/java_tasks/tasks.txt";

    public static void main(String[] args) 
    {

        loadTasksFromFile();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== TO-DO LIST MENU =====");
            System.out.println("1. Add Tasks (Date wise)");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Multiple Tasks as Completed");
            System.out.println("4. Edit Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTasks(sc);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markMultipleCompleted(sc);
                    break;
                case 4:
                    editTask(sc);
                    break;
                case 5:
                    saveTasksToFile();
                    System.out.println("Tasks saved. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    // ================= ADD TASKS =================
    static void addTasks(Scanner sc) 
    {

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.println("Enter tasks separated by comma (,)");
        String input = sc.nextLine();

        String[] tasksArray = input.split(",");

        dateWiseTasks.putIfAbsent(date, new ArrayList<>());

        for (String t : tasksArray) 
        {
            dateWiseTasks.get(date).add(new Task(t.trim(), false));
        }

        System.out.println("Tasks added successfully!");
    }

    // ================= VIEW TASKS =================
    static void viewTasks() {

        if (dateWiseTasks.isEmpty()) 
        {
            System.out.println("No tasks available.");
            return;
        }

        for (String date : dateWiseTasks.keySet()) 
        {
            System.out.println("\n📅 " + date);

            List<Task> tasks = dateWiseTasks.get(date);

            for (int i = 0; i < tasks.size(); i++) 
            {
                Task task = tasks.get(i);
                String mark = task.isCompleted ? "✔" : " ";
                System.out.println((i + 1) + ". [" + mark + "] " + task.title);
            }
        }
    }

    // ================= MARK MULTIPLE COMPLETED =================
    static void markMultipleCompleted(Scanner sc) 
    {

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        if (!dateWiseTasks.containsKey(date)) 
        {
            System.out.println("No tasks found for this date.");
            return;
        }

        List<Task> tasks = dateWiseTasks.get(date);

        for (int i = 0; i < tasks.size(); i++) 
        {
            String mark = tasks.get(i).isCompleted ? "✔" : " ";
            System.out.println((i + 1) + ". [" + mark + "] " + tasks.get(i).title);
        }

        System.out.println("Enter task numbers to mark completed (comma separated)");
        String input = sc.nextLine();

        String[] numbers = input.split(",");

        for (String num : numbers) 
        {
            try {
                int index = Integer.parseInt(num.trim()) - 1;
                if (index >= 0 && index < tasks.size()) 
                {
                    tasks.get(index).isCompleted = true;
                }
            } catch (NumberFormatException e) 
            {
                System.out.println("Invalid number.");
            }
        }

        System.out.println("Selected tasks marked as completed ✔");
    }

    // ================= EDIT TASK =================
    static void editTask(Scanner sc) 
    {

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        if (!dateWiseTasks.containsKey(date)) 
        {
            System.out.println("No tasks found for this date.");
            return;
        }

        List<Task> tasks = dateWiseTasks.get(date);

        for (int i = 0; i < tasks.size(); i++) 
        {
            System.out.println((i + 1) + ". " + tasks.get(i).title);
        }

        System.out.print("Enter task number to edit: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < tasks.size()) 
        {
            System.out.print("Enter new task title: ");
            String newTitle = sc.nextLine();
            tasks.get(index).title = newTitle;
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // ================= SAVE TO FILE =================
    static void saveTasksToFile() 
    {

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) 
        {

            for (String date : dateWiseTasks.keySet()) 
            {
                for (Task task : dateWiseTasks.get(date)) 
                {
                    pw.println(date + "|" + task.title + "|" + task.isCompleted);
                }
            }

        } catch (IOException e) 
        {
            System.out.println("Error saving tasks.");
        }
    }

    // ================= LOAD FROM FILE =================
    static void loadTasksFromFile() 
    {

        File file = new File(FILE_NAME);

        if (!file.exists())
            return;

        try (Scanner sc = new Scanner(file)) 
        {

            while (sc.hasNextLine()) 
            {
                String line = sc.nextLine();
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    String date = parts[0];
                    String title = parts[1];
                    boolean completed = Boolean.parseBoolean(parts[2]);

                    dateWiseTasks.putIfAbsent(date, new ArrayList<>());
                    dateWiseTasks.get(date).add(new Task(title, completed));
                }
            }

        } catch (IOException e) 
        {
            System.out.println("Error loading tasks.");
        }
    }
}



class Task 
{
    String title;
    boolean isCompleted;

    Task(String title, boolean isCompleted) 
    {
        this.title = title;
        this.isCompleted = isCompleted;
    }
}
