package gestioncompte.xefi.com;
import gestioncompte.xefi.com.models.CompteCourant;
import gestioncompte.xefi.com.models.CompteEpargne;
import gestioncompte.xefi.com.models.GestionComptes;
import gestioncompte.xefi.com.models.Compte;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionComptes gestionDeComptes = new GestionComptes();

        while (true) {
            System.out.println("1. Créer un compte courant");
            System.out.println("2. Créer un compte épargne");
            System.out.println("3. Créditer un compte");
            System.out.println("4. Débiter un compte");
            System.out.println("5. Effectuer un virement");
            System.out.println("6. Afficher la liste des comptes");
            System.out.println("7. Trier les comptes");
            System.out.println("8. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Nom du propriétaire : ");
                    String nomCourant = scanner.next();
                    System.out.print("Découvert autorisé : ");
                    double decouvert = scanner.nextDouble();
                    gestionDeComptes.ajouterCompte(new CompteCourant(nomCourant, decouvert));
                    break;
                case 2:
                    System.out.print("Nom du propriétaire : ");
                    String nomEpargne = scanner.next();
                    System.out.print("Taux d'abondement (ex: 0.05 pour 5%) : ");
                    double tauxAbondement = scanner.nextDouble();
                    gestionDeComptes.ajouterCompte(new CompteEpargne(nomEpargne, tauxAbondement));
                    break;
                case 3:
                    System.out.print("Nom du propriétaire du compte à créditer : ");
                    String nomCrediter = scanner.next();
                    Compte compteCrediter = trouverCompte(nomCrediter, gestionDeComptes);
                    if (compteCrediter != null) {
                        System.out.print("Montant à créditer : ");
                        double montantCrediter = scanner.nextDouble();
                        compteCrediter.crediter(montantCrediter);
                    }
                    break;
                case 4:
                    System.out.print("Nom du propriétaire du compte à débiter : ");
                    String nomDebiter = scanner.next();
                    Compte compteDebiter = trouverCompte(nomDebiter, gestionDeComptes);
                    if (compteDebiter != null) {
                        System.out.print("Montant à débiter : ");
                        double montantDebiter = scanner.nextDouble();
                        compteDebiter.debiter(montantDebiter);
                    }
                    break;
                case 5:
                    System.out.print("Nom du propriétaire du compte à créditer : ");
                    String nomCrediterVirement = scanner.next();
                    Compte compteCrediterVirement = trouverCompte(nomCrediterVirement, gestionDeComptes);
                    System.out.print("Nom du propriétaire du compte à débiter : ");
                    String nomDebiterVirement = scanner.next();
                    Compte compteDebiterVirement = trouverCompte(nomDebiterVirement, gestionDeComptes);
                    if (compteCrediterVirement != null && compteDebiterVirement != null) {
                        System.out.print("Montant du virement : ");
                        double montantVirement = scanner.nextDouble();
                        compteCrediterVirement.crediter(montantVirement);
                        compteDebiterVirement.debiter(montantVirement);
                    }
                    break;
                case 6:
                    gestionDeComptes.afficherComptes();
                    break;
                case 7:
//                    gestionDeComptes.trierComptes();
//                    System.out.println("Comptes triés par solde.");
//                    break;
                case 8:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide.");
            }
        }

//        GestionComptes gestionDeComptes = new GestionComptes();
//
//        CompteCourant compteCourantNicolas = new CompteCourant("Nicolas", 2000); // Découvert autorisé de 2000 €
//        CompteCourant compteCourantJeremie = new CompteCourant("Jérémie", 500);   // Découvert autorisé de 500 €
//
//        CompteEpargne compteEpargneNicolas = new CompteEpargne("Nicolas", 0.025); // Taux d'abondement de 2.05%
//
//        gestionDeComptes.ajouterCompte(compteCourantNicolas);
//        gestionDeComptes.ajouterCompte(compteCourantJeremie);
//        gestionDeComptes.ajouterCompte(compteEpargneNicolas);
//
//        compteCourantNicolas.crediter(1000);
//
//        compteEpargneNicolas.crediter(200);
//
//        compteCourantNicolas.debiter(50);
//
//        compteCourantNicolas.crediter(100);
//
//        compteEpargneNicolas.crediter(100);
//
//        compteCourantJeremie.debiter(500);
//
//        compteCourantJeremie.debiter(200);
//
//        compteCourantNicolas.crediter(200);
//
//        gestionDeComptes.afficherComptes();
    }
    public static Compte trouverCompte(String proprietaire, GestionComptes gestionDeComptes) {
        for (Compte compte : gestionDeComptes.getComptes()) {
            if (compte.getProprietaire().equals(proprietaire)) {
                return compte;
            }
        }
        System.out.println("Compte non trouvé.");
        return null;
    }
}
