public class User {
    private String userName;
    private String [] description=new String[10];
    public User(String userName){
        this.userName=userName;
    }

    public String getUserName() {
        return userName;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }
}
