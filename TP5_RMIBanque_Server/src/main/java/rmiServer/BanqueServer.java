package rmiServer;

import rmiService.BanqueImpl;

import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class BanqueServer {

    public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(1099);

            BanqueImpl od = new BanqueImpl();
            System.out.println(od.toString());

            // JNDI : le contexte lit jndi.properties automatiquement
            InitialContext ctx = new InitialContext();
            ctx.rebind("banqueService", od);

            System.out.println("Serveur RMI Banque demarre...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

