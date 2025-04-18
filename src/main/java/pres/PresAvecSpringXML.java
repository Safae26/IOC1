package pres;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import metier.IMetier;

public class PresAvecSpringXML {
    public static void main(String[] args) {
        // Démarrer Spring
        ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = springContext.getBean(IMetier.class);
        System.out.println("Résultat : " + metier.calcul());

        // Dans Spring, on a la version XML et annotation
        // Les Frameworks préfèrent l'injection de dépendances avec le constructeur
    }
}
