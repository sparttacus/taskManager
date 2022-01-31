package apoio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("taskManagerPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static void fechaEntityManager(){
        emf.close();
    }
}
