package gestioncompte.xefi.com.models;

public class Operation {
    private double montant;
    private Mouvement type;

    public enum Mouvement {
        Credit,
        Debit,
    }

    public Operation() {
        this.montant = 10;
        this.type = Mouvement.Debit;
    }

    public Operation(double montant, Mouvement mouvement) {
        this.montant = montant;
        this.type = mouvement;
    }
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Mouvement getType() {
        return type;
    }

    public void setType(Mouvement type) {
        this.type = type;
    }

}
