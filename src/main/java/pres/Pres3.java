package pres;

import dao.IDao;
import metier.IMetier;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donnez la classe de la couche DAO : ");
        String daoClassName = scanner.nextLine();
        System.out.println(daoClassName);


        Class cDao = Class.forName(daoClassName);


        IDao dao = (IDao) cDao.getConstructor().newInstance();


        System.out.println("Donnez la classe de la couche Métier : ");
        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

        Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
        setDao.invoke(metier, dao);
        System.out.println(metier.calcul());

        // Au lieu de copier-coller à chaque fois, on va utiliser Spring Framework basé sur l'inversion de controle
        // Il fait cette injection de dépendances.
    }
}



