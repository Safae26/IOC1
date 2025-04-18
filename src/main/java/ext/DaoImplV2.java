package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

// C'est une extension

@Component("vws") // Nom du bean
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Web Service");
        double data = 100;
        return data;
    }
}
