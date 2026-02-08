import java.util.List;

public interface UserInterface {
    public String getUserName();
    public List<TaskInterface> getTask();
    public void setTask(List<TaskInterface> task);
}
