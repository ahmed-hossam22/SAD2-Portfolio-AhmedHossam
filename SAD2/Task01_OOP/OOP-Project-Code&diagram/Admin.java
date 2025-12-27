public class Admin extends User {
    private String adminId;

    public Admin(String id, String name, String email, String phone) {
        super(id, name, email, phone);
        this.adminId = "A-" + id;
    }

    @Override
    public String toString() {
        return "Admin " + name + " (" + adminId + ")";
    }
}