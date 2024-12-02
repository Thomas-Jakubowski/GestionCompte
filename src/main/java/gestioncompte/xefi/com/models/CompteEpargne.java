package gestioncompte.xefi.com.models;

public class CompteEpargne extends Compte {
    private double tauxAbondement;

    public CompteEpargne(String proprietaire, double tauxAbondement) {
        super(proprietaire);
        if (tauxAbondement < 0 || tauxAbondement > 1) {
            throw new IllegalArgumentException("Le taux d'abondement doit être compris entre 0 et 1.");
        }
        this.tauxAbondement = tauxAbondement;
    }

    @Override
    public double calculBenefice() {
        return calculSolde() * tauxAbondement;
    }

    @Override
    public double getDecouvertAutorise() {
        return 0;
    }

    @Override
    public void information() {
        super.information();
        System.out.println("Taux d'abondement: " + tauxAbondement * 100 + "%");
    }
}

