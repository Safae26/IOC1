package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresVersionSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ext", "metier"); // packages à scanner au démarrage
        IMetier metier = context.getBean(IMetier.class); // Ou : IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("RES = " + metier.calcul());

        // Spring controle les objets de l'app : pattern de l'inversion de controle : ce n'est plus mon app qui le fait, c'est spring
        // getBean : A chaque fois qu'on veut un objet.
        // Spring s'occupe du code technique (gestion de mémoire, cache, accès aux données,...)
        // Développeur s'occupe du code métier

    }
}
