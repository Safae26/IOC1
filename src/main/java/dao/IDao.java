package dao;

// La couche Dao est fermée à la modification, car les classes dao ne dépendent pas des autres classes, que de l'interface IDao
// Elle ouverte à l'extension, car il y a une interface
// Donc à n'importe quel moment, on peut créér de nouvelles classes
// Pour la couche métier aussi
public interface IDao {
    double getData();
}
