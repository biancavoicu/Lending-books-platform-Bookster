package classes;

import java.util.List;

public class Loan {
    private User user;
    private List<Material> materials;

    public Loan(User user, List<Material> materials) {
        this.user = user;
        this.materials = materials;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "user: " + user +
                ", materials: " + materials +
                "}\n";
    }
}
