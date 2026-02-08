import java.util.List;
import java.util.ArrayList;

public class User implements UserInterface {
    private String userName;
    //private TaskInterface[] tasks = new TaskInterface[10];
    private List<TaskInterface> task=new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public List<TaskInterface> getTask() {
        return task;
    }

    public void setTask(List<TaskInterface> task) {
        this.task = task;
    }


    //public TaskInterface[] getTasks() {
       // return tasks;
    }