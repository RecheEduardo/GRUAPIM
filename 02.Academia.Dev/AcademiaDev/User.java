package AcademiaDev;

public abstract class User {
    private String name;
    private String email;

    // getters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
