public abstract class User {
    protected String id;
    protected String name;
    protected String email;
    protected String phone;

    public User(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public void login() {
        System.out.println(name + " logged in.");
    }

    public void logout() {
        System.out.println(name + " logged out.");
    }

    @Override
    public String toString() {
        return "User " + name + " (ID: " + id + ")";
    }
}