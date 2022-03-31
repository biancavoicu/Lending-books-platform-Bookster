package classes;

import java.util.List;

public class Library {
    private String name;
    private String address;
    private String telephone;
    private String email;
    private List<Material> materials;

    public Library(String name, String address, String telephone, String email, List<Material> materials) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.materials = materials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name: '" + name + '\'' + '\n'+
                ", address: '" + address + '\'' + '\n'+
                ", telephone: '" + telephone + '\'' + '\n'+
                ", email: '" + email + '\'' + "\n" +
                ", materials: " + materials +
                "}\n";
    }
}
