package app.models;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int id,employeeid;
    private String username;

    public User() {
    }

    public User(int id, int employeeid, String username, String password) {
        this.id = id;
        this.employeeid = employeeid;
        this.username = username;
        this.password = password;
    }

    private String password;
}