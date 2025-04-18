package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao") // Crée-moi un objet de cette classe au démarrage
// Cette annotation est utilisée pour n'importe quelle classe. Mais de préférence il faut utiliser des annotations pour chaque couche.
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        System.out.println("Version Base de Données");
        double data = 34;
        return data;
    }
}
