import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManagerInterface userManager=new UserManager();
        while (true) {//all user
            UserInterface currentUser=userManager.login();
            TaskManagerInterface taskManager=new TaskManager(currentUser);
            Integer choice = 0;
            while (choice != 5) {//one user
                System.out.println("What all you can do with me!!");
                System.out.println("1.Add Task");
                System.out.println("2.List of all Task");
                System.out.println("3.Update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                try {
                    System.out.println("Enter your choice");
                    choice = new Integer(scanner.nextLine());

                    if (choice == 1) {
                        taskManager.add();
                        }
                    else if (choice == 2) {
                        taskManager.list();

                    } else if (choice == 3) {
                        taskManager.update();
                       }

                else if (choice == 4) {
                    taskManager.delete();
                        }
                else if (choice == 5) {
                    taskManager.exit();
                }
                    else {
                    System.out.println("Invalid Choice,pls enter the crt choice");
                }
                } catch (Exception e) {
                    System.out.println("Invalid Input,Pls enter the valid Input");
                }
            }
        }
    }

    }