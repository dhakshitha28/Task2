import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager implements TaskManagerInterface {
    private UserInterface currentUsername;

    public TaskManager(UserInterface currentUsername) {
        this.currentUsername=currentUsername;

    }

    Scanner scanner = new Scanner(System.in);

    public void add() {
        int wantToAddAnotherTitle=0;
        boolean theAddWantTOExecute = true;
        while (theAddWantTOExecute == true) {
            try {
                wantToAddAnotherTitle++;
                System.out.println("If you wish to go to the main menu, type exit.");
                boolean check = TaskUtil.checkDescription(currentUsername);//the static method does not need the object to executed so we want to say what is the dataTyp then only the method get contract
                if (check) {
                    System.out.println("The file is empty");//from the boolean value which get for the checkDescription()  if and else is executing
                }
                System.out.println("Enter the Title");
                String title = scanner.nextLine();
                if (title.equals("exit")) {
                    throw new Exception();
                }

                TaskInterface task = new Task(title, null, "To Do");
                currentUsername.getTask().add(task);
//                for (int i = 0; i < currentUsername.getTasks().length; i++) {
//                    if (currentUsername.getTasks()[i] == null) {
//                        currentUsername.getTasks()[i] = task;
//                        break;
//                    }
//                    if (currentUsername.getTasks()[i] != null) {
//                        continue;
//                    }
//                }


                System.out.println("Do you want to ADD Description");
                System.out.println("1.Yes");
                System.out.println("2.No");
                System.out.println("Enter your  requirement :");
                String requirementForAddDescription = scanner.nextLine();
                if (requirementForAddDescription.equals("exit")) {
                    throw new Exception();
                }
                if (requirementForAddDescription.equals("1")) {
                    System.out.println("Enter your Description");
                    String description = scanner.nextLine();
                    if (description.equals("exit")) {
                        throw new Exception();
                    }
                    TaskUtil.setTheTaskDescription(title, description, currentUsername);
                    System.out.println("Task is successfully created with the description");

                } else if (requirementForAddDescription.equals("2")) {
                    System.out.println("Task is ADD successfully ");
                } else {
                    System.out.println("Your input for required Description is invalided,pls enter the crt otp ");
                }
                if(wantToAddAnotherTitle!=0){
                    System.out.println("Do you wanted to add Another Task?");
                    System.out.println("1.Yes");
                    System.out.println("2.No");
                    String anotherTask=scanner.nextLine();
                    if(anotherTask.equals("exit")){
                        throw new Exception();
                    }
                    if (anotherTask.equals("1")){
                        theAddWantTOExecute=true;
                    }
                    else if(anotherTask.equals("2")){
                        throw new Exception();
                    }
                    else {
                        System.out.println("Invalid Input For Add Another Task");
                    }
                }

            } catch (Exception e) {
                System.out.println("Successfully Exit From The ADD Task");
                theAddWantTOExecute = false;
            }
        }
    }

    public void list() {
        boolean theListWantToExecute = true;
        while (theListWantToExecute == true) {
            try {
                System.out.println("If you wish to go to the main menu, type exit.");
                System.out.println("1.List All the task");
                System.out.println("2.List ALL the Title");
                System.out.println("3.List All The TO DO");
                System.out.println("4.List ALL the In Progress");
                System.out.println("5.List All the Done");
                System.out.println("Enter the choice Which one you want to display");
                String choiceList = scanner.nextLine();
                if (choiceList.equals("exit")) {
                    throw new Exception();
                }
                if (choiceList.equals("1")) {
                    boolean check = TaskUtil.checkDescription(currentUsername);
                    if (check) {
                        System.out.println("The file is empty");
                    }
                } else if (choiceList.equals("2")) {
                    if(currentUsername.getTask().isEmpty()==true){
                        System.out.println("The Title is Empty");
                    }
                    else {
                        int size=currentUsername.getTask().size();
                        for(int i=0;i<size;i++){
                            System.out.println(i+1+"."+currentUsername.getTask().get(i));
                        }
                    }

//                    boolean thereIsNoTitle = true;
//                    for (int i = 0; i < currentUsername.getTasks().length; i++) {
//                        if (currentUsername.getTasks()[i] != null) {
//                            System.out.print(i + 1);
//                            System.out.print(" .");
//                            System.out.println(currentUsername.getTasks()[i].getTitle());
//                            thereIsNoTitle = false;
//                        }
//                        if (currentUsername.getTasks()[i] == null) {
//                            continue;
//                        }
//                    }
//                    if (thereIsNoTitle) {
//                        System.out.println("The Title is Empty");
//                    }
                } else if (choiceList.equals("3")) {
                    TaskUtil.printStatus(currentUsername, "To Do", "The (TO DO) Status task is empty");
                } else if (choiceList.equals("4")) {
                    TaskUtil.printStatus(currentUsername, "In progress", "The (In progress) Status task is empty");
                } else if (choiceList.equals("5")) {
                    TaskUtil.printStatus(currentUsername, "Done", "The (Done) Status task is empty");
                } else {
                    System.out.println("Your Choice For list is Invalided");
                }

            } catch (Exception e) {
                System.out.println("Successfully Exit From The LIST Task");
                theListWantToExecute = false;
            }
        }
    }

    public void update(){
        boolean thereUpdateWantToExecute = true;
        while (thereUpdateWantToExecute == true) {
        boolean check = TaskUtil.checkDescription(currentUsername);
        if (check) {
            System.out.println("The file is empty");
        } else {
                try {

                    int valueForUpdate = TaskUtil.getTheChoice("Enter your Choice for Update:", currentUsername, scanner);
                    if (valueForUpdate == -1) {
                        System.out.println("There is no value Update");
                    }
                    if (valueForUpdate == -2) {
                        System.out.println("Your place value for Update is invalided");
                    }
                    if (valueForUpdate != -1 && valueForUpdate != -2) {
                        if (valueForUpdate != -3) {
                            boolean theUserOptionIsExit = true;
                            while (theUserOptionIsExit) {
                                System.out.println("Which One you Want to Update?");
                                System.out.println("1.Title");
                                System.out.println("2.Description");
                                System.out.println("3.Status");
                                System.out.println("4.Exit from the update");
                                System.out.println("Enter your Choice which one you want to Update:");
                                String choiceForUpdate = scanner.nextLine();
                                if (choiceForUpdate.equals("exit")) {
                                    throw new Exception();
                                }
                                if (choiceForUpdate.equals("1")) {
                                    System.out.println("Enter your update Title");
                                    String updateTitle = scanner.nextLine();
                                    if (updateTitle.equals("exit")) {
                                        throw new Exception();
                                    }
                                    currentUsername.getTask().get(valueForUpdate - 1).setTitle(updateTitle);
                                    System.out.println("Title is successfully Updated");
                                } else if (choiceForUpdate.equals("2")) {
                                    System.out.println("Enter your update description");
                                    String updateDescription = scanner.nextLine();
                                    if (updateDescription.equals("exit")) {
                                        throw new Exception();
                                    }
                                    currentUsername.getTask().get(valueForUpdate - 1).setDescription(updateDescription);
                                    System.out.println("Description ia successfully updated");
                                } else if (choiceForUpdate.equals("3")) {
                                    TaskUtil.printTheStatus();
                                    System.out.println("Enter Your update Status");
                                    String choiceForUpdateStatus = scanner.nextLine();
                                    if (choiceForUpdateStatus.equals("exit")) {
                                        throw new Exception();
                                    }
                                    if (choiceForUpdateStatus.equals("1")) {
                                        currentUsername.getTask().get(valueForUpdate - 1).setStatus("To DO");
                                        System.out.println("To Do status is Successfully Updated");
                                    } else if (choiceForUpdateStatus.equals("2")) {
                                        currentUsername.getTask().get(valueForUpdate - 1).setStatus("In progress");
                                        System.out.println("In Progress status is Successfully Updated ");
                                    } else if (choiceForUpdateStatus.equals("3")) {
                                        currentUsername.getTask().get(valueForUpdate - 1).setStatus("Done");
                                        System.out.println("Done status is Successfully Updated ");
                                    } else {
                                        System.out.println("Invalided Input For update Status");
                                    }
                                } else if (choiceForUpdate.equals("4")) {
                                    theUserOptionIsExit = false;
                                } else {
                                    System.out.println("Invalided Input For update");
                                }
                            }
                        }

                    }
                }catch(Exception e){
                    System.out.println("Successfully Exit From The Update");
                    thereUpdateWantToExecute = false;
                }
            }
        }
    }
    public void delete(){
        boolean theDeleteWantToExecute = true;
        while (theDeleteWantToExecute==true) {
        boolean check =TaskUtil.checkDescription(currentUsername);
        if (check) {
            System.out.println("The file is empty");
        } else {
                int valueForDeleteTask = 0;
                try {
                    valueForDeleteTask = TaskUtil.getTheChoice("Enter your choice for delete Task", currentUsername, scanner);
                } catch (Exception e) {
                    System.out.println("Successfully Exit From The Delete");
                    theDeleteWantToExecute = false;
                }
                if (valueForDeleteTask == -1) {
                    System.out.println("There is no value delete");
                }
                if (valueForDeleteTask == -2) {
                    System.out.println("Your place value for delete is invalided");
                }
                if (valueForDeleteTask != -1 && valueForDeleteTask != -2) {
                    if (valueForDeleteTask != -3) {
                        currentUsername.getTask().get(valueForDeleteTask - 1)== null;
                        //Swap logic
                        for (int i = 0; i < currentUsername.getTask().length; i++) {
                            if (currentUsername.getTask()[i] != null) {
                                continue;
                            }
                            if (currentUsername.getTask()[i] == null) {
                                for (int j = i + 1; j < currentUsername.getTask().length; j++) {//i=swap;
                                    TaskInterface swap = currentUsername.getTask()[i];
                                    currentUsername.getTask()[i] = currentUsername.getTask()[j];
                                    currentUsername.getTask()[j] = swap;
                                    break;
                                }
                            }
                        }
                        System.out.println("Successfully Deleted");
                    }
                }
            }
        }
    }
    public void exit(){
            System.out.println("Thanks for using!!");
        }
    }
