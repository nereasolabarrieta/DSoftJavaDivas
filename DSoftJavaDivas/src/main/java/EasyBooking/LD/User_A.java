package EasyBooking.LD;

import ServiciosExternos.Print;

public class User_A implements Print
{
    private String name;
    private String last_name;
    private String email;
    private String password;
    private String password_new;

    public User_A(String name, String last_name, String email, String password, String password_new)
    {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.password_new = password_new;
    }

    public User_A(String email, String password) {
        this.email =email;
        this.password =password;
       
    }

    public User_A(String name, String last_name, String email) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_new() {
        return password_new;
    }

    public void setPassword_new(String password_new) {
        this.password_new = password_new;
    }

    @Override
    public void print() {
        System.out.println(
                "Printing A_User" + "\n" +
                "Name: " + getName() + "\n" +
                "Last name: " + getLast_name() + "\n" +
                "email: " + getEmail() + "\n" +
                "password: " + getPassword() + "\n" +
                "password_new:" + getPassword_new() + "\n"
        );
    }
}
