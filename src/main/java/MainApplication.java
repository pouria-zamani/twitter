import base.repository.impl.BaseRepositoryImpl;
import domain.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import util.ApplicationContext;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext.getApplicationRun().mainRun();
    }
}
