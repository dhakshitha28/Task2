import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {//all user
            User[] existingUser = new User[5];
            System.out.println("Welcome to the Task Tracker system!!");
            System.out.println("Enter your name:");
            String userName = scanner.nextLine();

            User currentUsername = new User(userName);

            for (int i = 0; i < existingUser.length; i++) {
                if (existingUser[i] != null) {
                    if (existingUser[i].equals(currentUsername.getUserName())) {
                        System.out.println("Welcome back");
                    }
                }
            }
            Integer choice = 0;
            while (choice != 4) {//one user
                System.out.println("What all you can do with me!!");
                System.out.println("1.Add Task");
                System.out.println("2.Update");
                System.out.println("3.Delete");
                System.out.println("4.Exit");
                System.out.println("Enter your choice");
                choice = new Integer(scanner.nextLine());
                if (choice == 1) {
                    boolean thereIsAnyElement = false;
                    for (int i = 0; i < currentUsername.getDescription().length; i++) {
                        if (currentUsername.getDescription()[i] != null) {
                            System.out.print(i + 1);
                            System.out.print(".");
                            System.out.println(currentUsername.getDescription()[i]);
                            thereIsAnyElement = true;
                        }
                        if (currentUsername.getDescription()[i] == null) {
                            continue;
                        }
                    }
                    if (!thereIsAnyElement) {
                        System.out.println("The file is empty");
                    }
                    System.out.println("Enter the Description");
                    String description = scanner.nextLine();
                    for (int i = 0; i < currentUsername.getDescription().length; i++) {
                        if (currentUsername.getDescription()[i] == null) {
                            currentUsername.getDescription()[i] = description;
                            break;
                        }
                    }

                } else if (choice == 2) {
                    boolean thereIsAnyElement = false;
                    for (int i = 0; i < currentUsername.getDescription().length; i++) {
                        if (currentUsername.getDescription()[i] != null) {
                            System.out.print(i + 1);
                            System.out.print(".");
                            System.out.println(currentUsername.getDescription()[i]);
                            thereIsAnyElement = true;
                        }
                        if (currentUsername.getDescription()[i] == null) {
                            continue;
                        }
                    }
                    if (!thereIsAnyElement) {
                        System.out.println("The file is empty");
                    }
                    System.out.println("Enter your choice to Update");
                    Integer updateChoice = new Integer(scanner.nextLine());
                    System.out.println("Enter your update description");
                    String updateDescription = scanner.nextLine();
                    currentUsername.getDescription()[updateChoice - 1] = updateDescription;
                    if (currentUsername.getDescription()[updateChoice - 1] == null) {
                        System.out.println("There is no value for update,you can able to stored the description in your choice");
                    }
                } else if (choice == 3) {
                    boolean thereIsAnyElement = false;
                    for (int i = 0; i < currentUsername.getDescription().length; i++) {
                        if (currentUsername.getDescription()[i] != null) {
                            System.out.print(i + 1);
                            System.out.print(".");
                            System.out.println(currentUsername.getDescription()[i]);
                            thereIsAnyElement = true;
                        }
                        if (currentUsername.getDescription()[i] == null) {
                            continue;
                        }
                    }
                    if (!thereIsAnyElement) {
                        System.out.println("The file is empty");
                    }
                    System.out.println("Enter your delete choice");
                    Integer deleteChoice = new Integer(scanner.nextLine());
                    currentUsername.getDescription()[deleteChoice - 1] = null;
                    for (int i = 0; i < currentUsername.getDescription().length; i++) {
                        if (currentUsername.getDescription()[i] != null) {
                            continue;
                        }
                        if (currentUsername.getDescription()[i] == null) {
                            for (int j = i + 1; j < currentUsername.getDescription().length; i++) {
                                currentUsername.getDescription()[i] = currentUsername.getDescription()[j];
                                currentUsername.getDescription()[j] = null;
                                break;
                            }
                        }
                    }
                } else if (choice == 4) {
                    boolean isAllReadyExising = false;
                    for (int i = 0; i < existingUser.length; i++) {
                        if (existingUser[i] != null) {
                            if (existingUser[i].equals(currentUsername.getUserName())) {
                                isAllReadyExising = true;
                            }
                        }
                        if (!isAllReadyExising) {
                            if (existingUser[i] == null) {
                                existingUser[i] = currentUsername;
                                break;
                            }
                        }
                    }
                    System.out.println("Thanks for using!!");
                } else {
                    System.out.println("Invalid Choice,pls enter the crt choice");
                }

            }
        }
    }
}
