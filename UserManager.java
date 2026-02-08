import java.util.Scanner;

public class UserManager implements UserManagerInterface{
    UserInterface[] existingUser = new UserInterface[5];

    public UserManager() {
    }

    Scanner scanner = new Scanner(System.in);

    public UserInterface login() {
        System.out.println("Welcome to the Task Tracker system!!");
        System.out.println("Enter your name:");
        String userName = scanner.nextLine();
        boolean thereIsAnyExistingUser = false;
        UserInterface currentUsername = null;
        for (int i = 0; i < existingUser.length; i++) {
            if (existingUser[i] != null) {
                if (existingUser[i].getUserName().equals(userName)) {
                    System.out.println("Welcome back!!");
                    currentUsername = existingUser[i];
                    thereIsAnyExistingUser = true;
                    break;
                }
            }
        }
        if (!thereIsAnyExistingUser) {
            currentUsername = new User(userName);
                for (int i = 0; i < existingUser.length; i++) {
                    if (existingUser[i] == null) {
                        existingUser[i] = currentUsername;
                        break;
                    }
                }
            }
        return currentUsername;
    }
}