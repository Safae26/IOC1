package metier;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


// Cette classe est prête à fonctionner avec n'importe quelle classe qui implémente IDao
// Donc on aura pas besoin de changer quelque chose au niveau du code, si on veut basculer
// de la based de données vers le WebService
// C'est fermée à la modification, et l'avantage du couplage faible.
@Service // Alias vers l'annotation Component
// @Controller : pour le web
public class MetierImpl implements IMetier{
    // Il y a l'injection via le setter (propriété) et le constructeur.
    // @Autowired // Affecte à la variable dao un objet de type IDao (injection automatique), mais Spring préfère l'injection via le constructeur, car cette méthode est deprecated
    @Qualifier("vws") // Autowired est 'deprecated' : car c'est une injection sur le champs directement, passe par la variable et pas le setter ou constructeur => violation d'encapsulation de POO
    private IDao dao; // Couplage faible : dépend des interfaces et pas des implémentations.

    // Pas besoin de autowired : Injection via le construteur : méthode la plus optimisée
    public MetierImpl(@Qualifier("vc") IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData(); // Pour le compilateur, syntaxiquement c'est bon.
        // Mais il ne sait pas si on va utiliser DaoImpl ou DaoImplV2.
        // Donc c'est das la phase d'exécution quand va affecter à la variable dao une valeur.
        // Et par la suite, à l'aide de l'injection des dépendances, on affecte un objet à la variable dao,
        // c'est à ce moment-là quand va préciser quelle méthode à utiliser (elle vient de quelle classe)
        double res = data * 10;
        return res;
    }

    /* Permet d'injecter dans la variable dao un objet de type IDao (un objet d'une classe qui implémente l'interface IDao)
    * */
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    // Dans la P.O.A, les proxy sot branchés via les méthodes et pas les variables.
    // Sépare le code métier du code technique : P.O.A
    // L'I de C est basé la P.O.A
    // SpringBoot (basé sur l'auto conf) : Framework basé sur spring : on ne crée pas bcq de fichiers de conf nous-meme
    // Kibernetes : pour la scalabilité horizontale : démarrer pls instances dans pls machines
    // Spring garantit la scalabilité verticale : optimise la gestion de la mémoire lors de la création des objets.
    // bcq d'objets en mémoire inutiles
    // pattern adaptable, stratégie
    // // Soring..

}
