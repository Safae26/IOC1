package pres;

import ext.DaoImplV2;
import dao.IDao;
import metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {

        DaoImplV2 dao = new DaoImplV2(); // Cette classe Pres1 n'est pas fermée à la modification : couplage fort <-> fait appel à des classes,
        // donc ce n'est pas encore parfait!
        MetierImpl metier = new MetierImpl(dao);
        //metier.setDao(dao); // Injection des dépendances
        System.out.println("Résultat = "+metier.calcul());
        // Null Pointer Exception : Indique qu'au moment de l'exécution, on est en train de faire appel à la méthode
        // d'un objet qui est nul (pas créé)
    }
}



