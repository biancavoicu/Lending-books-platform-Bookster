package entities;

public class User {
    private String name;
    private String email;
    private String telephone;
    private String companyName;

    public User(String name, String email, String telephone, String companyName) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.companyName = companyName;
    }

    public User() {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCompany() {
        return companyName;
    }

    public void setCompany(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "{" +
                "name: '" + name + '\'' + '\n'+
                ", email: '" + email + '\'' + '\n'+
                ", telephone: '" + telephone + '\'' + '\n'+
                ", company: " + companyName + '\n'+
                '}';
    }
}
