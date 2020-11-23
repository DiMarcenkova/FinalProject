package finalProject.models;

public class CustomerModel {
    private String email = "testemail@gmail.com";
    private String name = "Testname";
    private String surname = "Testsurname";
    private String phone = "21111111";

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
