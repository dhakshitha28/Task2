import java.util.Scanner;

public class TaskUtil {
    public static boolean checkDescription(UserInterface userAddress) {//this is the similar method for add,update,list and  delete// this is the static method so this method does not need the object
        boolean thereIsNoAnyValue = true;
        for (int i = 0; i < userAddress.getTasks().length; i++) {
            if (userAddress.getTasks()[i] != null) {
                System.out.println("********************");
                System.out.print(i + 1);
                System.out.print(".");
                String title =userAddress.getTasks()[i].getTitle();
                System.out.print("Title:");
                System.out.println(title);
                String description =userAddress.getTasks()[i].getDescription();
                System.out.print(" Description:");
                System.out.println(description);
                System.out.print(" Status:");
                System.out.println(userAddress.getTasks()[i].getStatus());
                System.out.println("********************");
                thereIsNoAnyValue = false;
            }
            if (userAddress.getTasks()[i] == null) {
                continue;
            }
        }
        return thereIsNoAnyValue;
    }
    public static int getTheChoice(String printStatement, UserInterface currentUser, Scanner sc) throws Exception{
        System.out.println(printStatement);
        String value=sc.nextLine();
        if(value.equals("exit")){
            throw new Exception();
        }
        try {
            Integer choiceToUpdateAndDeleteDescription = new Integer(value);
            if (choiceToUpdateAndDeleteDescription < currentUser.getTasks().length) {
                if (currentUser.getTasks()[choiceToUpdateAndDeleteDescription - 1] != null) {
                    return choiceToUpdateAndDeleteDescription;
                } else {
                    return -1;
                }
            } else {
                return -2;
            }
        } catch (Exception e) {
            System.out.println("Invalided input for make changes");
            return -3;
        }
    }
    public static void printTheStatus(){
        System.out.println("-------STATUS--------");
        System.out.println("1.To Do");
        System.out.println("2.In Progress");
        System.out.println("3.Done");
    }
    //task description method
    public static void setTheTaskDescription(String title,String description,UserInterface currentUsername) {
        for (int i = 0; i < currentUsername.getTasks().length; i++) {
            if (currentUsername.getTasks()[i] != null) {
                if (currentUsername.getTasks()[i].getTitle().equals(title)) {
                    currentUsername.getTasks()[i].setDescription(description);
                }
            }
        }
    }
    public static void printStatus(UserInterface currentUsername,String status,String printStatement){
        boolean thereIsNoValue = true;
        int count=0;
        for (int i = 0; i < currentUsername.getTasks().length; i++) {
            if (currentUsername.getTasks()[i] != null && currentUsername.getTasks()[i].getStatus().equals(status)) {
                count++;
                System.out.println("-------TITLE-------");
                System.out.print(count);
                System.out.print(" .");
                System.out.println(currentUsername.getTasks()[i].getTitle());
                String description = currentUsername.getTasks()[i].getDescription();
                System.out.print(" Description:");
                System.out.println(description);
                System.out.print(" Status:");
                System.out.println(currentUsername.getTasks()[i].getStatus());
                thereIsNoValue = false;
            }
            if (currentUsername.getTasks()[i] == null) {
                continue;
            }
        }
        if (thereIsNoValue) {
            System.out.println(printStatement);
        }
    }

}
