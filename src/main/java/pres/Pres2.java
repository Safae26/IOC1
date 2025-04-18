package pres;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import dao.IDao;
import metier.IMetier;

import java.io.File;

public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine(); // Au moment de l'exécution, il trouve la première ligne du fichier
        System.out.println(daoClassName);
        // On ne connait pas le nom de la classe au moment de la compilation

        // Instaciation dynamique
        // Charger la classe en mémoire
        Class cDao = Class.forName(daoClassName);

        // On crée un objet de cette classe
        IDao dao = (IDao) cDao.getConstructor().newInstance(); // new DaoImpl();
        // dynamique                            // Statique
        // C'est l'objet (Object) d'une classe qui implémente l'interface IDao
        //System.out.println(dao.getData());


        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao); // On injecte au moment de l'instanciation

        // En bref : Nom de la classe --> charger la classe en mémoire --> créer des instances => Spring fait tout ça
        // Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
        // setDao.invoke(metier, dao); // Injection des dépendances dynmamique
        // Statique metier.setDao(dao);
        System.out.println(metier.calcul()); // Modifier le config.txt pour basculer
    }
}
