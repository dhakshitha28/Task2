import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] existingUser = new User[5];
        while (true) {//all user
            System.out.println("Welcome to the Task Tracker system!!");
            System.out.println("Enter your name:");
            String userName = scanner.nextLine();
            boolean thereIsAnyExistingUser = false;
            User currentUsername = null;
            for (int i = 0; i < existingUser.length; i++) {
                if (existingUser[i] != null) {
                    if (existingUser[i].getUserName().equals(userName)) {
                        System.out.println("Welcome back!!");
                        currentUsername = existingUser[i];
                        thereIsAnyExistingUser = true;
                        break;
                    }
                }
                if (existingUser[i] == null) {
                    continue;
                }
            }
            if (!thereIsAnyExistingUser) {
                currentUsername = new User(userName);
            }

            Integer choice = 0;
            while (choice !=5) {//one user
                System.out.println("What all you can do with me!!");
                System.out.println("1.Add Task");
                System.out.println("2.List of all Task");
                System.out.println("3.Update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                System.out.println("Enter your choice");
                choice = new Integer(scanner.nextLine());
                if (choice == 1) {
                    boolean check = Main.checkDescription(currentUsername);//the static method does not need the object to executed so we want to say what is the dataTyp then only the method get contract
                    if (check) {
                        System.out.println("The file is empty");//from the boolean value which get for the checkDescription()  if and else is executing
                    }
                    System.out.println("Enter the Description");
                    String description = scanner.nextLine();
                    for (int i = 0; i < currentUsername.getDescription().length; i++) {
                        if (currentUsername.getDescription()[i] == null) {
                            currentUsername.getDescription()[i] = description;
                            break;
                        }
                    }

                } else if (choice==2) {
                    boolean check = Main.checkDescription(currentUsername);
                    if (check) {
                        System.out.println("The file is empty");
                    }
                }
                else if (choice==3) {
                    boolean check = Main.checkDescription(currentUsername);
                    if (check) {
                        System.out.println("The file is empty");
                    } else {
                        try {
                            System.out.println("UPDATE:");
                          int valueForUpdate=Main.getTheChoice();
                            if (currentUsername.getDescription()[valueForUpdate - 1] == null) {
                                System.out.println("There is no value for update,you can able to stored the description in your choice");
                            } else {
                                System.out.println("Enter your update description");
                                String updateDescription = scanner.nextLine();
                                currentUsername.getDescription()[valueForUpdate - 1] = updateDescription;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalided Input ");
                            continue;
                        }
                    }
                } else if (choice==4) {
                   boolean check=Main.checkDescription(currentUsername);
                    if (check) {
                        System.out.println("The file is empty");
                    } else {
                        try {
                            System.out.println("DELETE");
                           int valueForDelete=Main.getTheChoice();
                            if(currentUsername.getDescription()[valueForDelete-1]==null){
                                System.out.println("There is no description for delete");
                            }
                            else {
                                currentUsername.getDescription()[valueForDelete - 1] = null;
                                for (int i = 0; i < currentUsername.getDescription().length; i++) {
                                    if (currentUsername.getDescription()[i] != null) {
                                        continue;
                                    }
                                    if (currentUsername.getDescription()[i] == null) {
                                        for (int j = i + 1; j < currentUsername.getDescription().length; j++) {//i=swap;
                                            String swap = currentUsername.getDescription()[i];
                                            currentUsername.getDescription()[i] = currentUsername.getDescription()[j];
                                            currentUsername.getDescription()[j] = swap;
                                            break;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Invalided Input");
                            continue;
                        }
                    }
                } else if (choice==5) {
                    boolean isAllReadyExising = false;
                    for (int i = 0; i < existingUser.length; i++) {
                        if (existingUser[i] != null) {
                            if (existingUser[i].getUserName().equals(currentUsername.getUserName())) {
                                isAllReadyExising = true;
                                break;
                            }
                        }
                    }
                    if (!isAllReadyExising) {
                        for (int i = 0; i < existingUser.length; i++) {
                            if (existingUser[i] == null) {
                                existingUser[i] = currentUsername;
                                break;
                            }
                        }

                        System.out.println("Thanks for using!!");
                    }
                    else {
                        System.out.println("Invalid Choice,pls enter the crt choice");
                    }
                }
            }
        }
    }
    static Scanner sc=new Scanner(System.in);
    public static boolean checkDescription(User userAddress) {//this is the similar method for add,update,list and  delete// this is the static method so this method does not need the object
        boolean thereIsNoAnyValue = true;
        for (int i = 0; i < userAddress.getDescription().length; i++) {
            if (userAddress.getDescription()[i] != null) {
                System.out.print(i + 1);
                System.out.print(".");
                System.out.println(userAddress.getDescription()[i]);
                thereIsNoAnyValue = false;
            }
            if (userAddress.getDescription()[i] == null) {
                continue;
            }
        }
        return thereIsNoAnyValue;
    }
    public static int getTheChoice(){
        System.out.print("Enter your choice ");
        Integer choiceToUpdateAndDelete = new Integer(sc.nextLine());
        return choiceToUpdateAndDelete;
    }
}




