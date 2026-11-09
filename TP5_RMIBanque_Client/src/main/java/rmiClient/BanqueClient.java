package rmiClient;

import metier.Compte;
import rmiService.IBanque;

import javax.naming.InitialContext;

public class BanqueClient {

    public static void main(String[] args) {
        try {
            // JNDI : le contexte lit jndi.properties automatiquement
            InitialContext ctx = new InitialContext();
            IBanque stub = (IBanque) ctx.lookup("banqueService");

            // Creer des comptes
            Compte c1 = new Compte(1, 5000.0);
            Compte c2 = new Compte(2, 12000.0);

            System.out.println(stub.creerCompte(c1));
            System.out.println(stub.creerCompte(c2));

            // Tenter de creer un compte avec un code existant
            System.out.println(stub.creerCompte(new Compte(1, 3000.0)));

            // Consulter les comptes
            System.out.println(stub.getInfoCompte(1));
            System.out.println(stub.getInfoCompte(2));
            System.out.println(stub.getInfoCompte(99));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

