package gestioncompte.xefi.com.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
    protected String proprietaire;
    protected List<Operation> operations;

    public Compte(String proprietaire) {
        this.proprietaire = proprietaire;
        this.operations = new ArrayList<>();
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void crediter(double montant) {
        Operation operation = new Operation(montant, Operation.Mouvement.Credit);
        operations.add(operation);
    }

    public void debiter(double montant) {
        Operation operation = new Operation(montant, Operation.Mouvement.Debit);
        operations.add(operation);
    }

    public void crediter(double montant, Compte compteADebiter) {
        this.crediter(montant);
        compteADebiter.debiter(montant);
    }

    public void debiter(double montant, Compte compteACrediter) {
        this.debiter(montant);
        compteACrediter.crediter(montant);
    }

    public double calculSolde() {
        double solde = 0.0;
        for (Operation operation : operations) {
            if (operation.getType() == Operation.Mouvement.Credit) {
                solde += operation.getMontant();
            } else if (operation.getType() == Operation.Mouvement.Debit) {
                solde -= operation.getMontant();
            }
        }
        return solde;
    }

    public abstract double calculBenefice();

    public double soldeFinal() {
        return calculSolde() + calculBenefice();
    }

    public void information() {
        System.out.println("Propriétaire: " + proprietaire);
        System.out.println("Solde: " + calculSolde());
        System.out.println("Découvert autorisé: " + getDecouvertAutorise());
        System.out.println("Opérations:");
        for (Operation operation : operations) {
            System.out.println("  - " + (operation.getType() == Operation.Mouvement.Credit ? "Crédit" : "Débit") + " de " + operation.getMontant());
        }
    }

    public abstract double getDecouvertAutorise();
}
