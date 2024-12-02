package gestioncompte.xefi.com.models;

import java.util.ArrayList;
import java.util.List;

public class GestionComptes {
    private List<Compte> comptes;

    public GestionComptes() {
        this.comptes = new ArrayList<>();
    }

    public void ajouterCompte(Compte compte) {
        this.comptes.add(compte);
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void afficherComptes() {
        for (Compte compte : comptes) {
            compte.information();
            System.out.println("----");
        }
    }
}
