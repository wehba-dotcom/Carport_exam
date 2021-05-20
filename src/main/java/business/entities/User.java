package business.entities;
public class User{



    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String name;
    private String email;
    private String adress;
    private String phonenumber;
    private double balance;
    private String role;
    private String password; // Should be hashed and secured

    public User(String name, String email, String adress, String phonenumber, double balance, String role, String password) {
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.phonenumber = phonenumber;
        this.balance = balance;
        this.role = role;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
