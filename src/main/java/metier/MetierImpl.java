package metier;
import dao.IDao;
import ext.DaoImplV2;


// Cette classe est prête à fonctionner avec n'importe quelle classe qui implémente IDao
public class MetierImpl implements IMetier {
    private IDao dao;

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