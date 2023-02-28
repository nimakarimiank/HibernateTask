import database.databaseConfiguration;
import org.hibernate.Session;
import database.entities.Employees;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args){
        Employees nimakarimian = new Employees();

        Session session = databaseConfiguration.Config();
        nimakarimian.setLastName("afsar");
        nimakarimian.setFirstName("shakila");
        nimakarimian.setGender(false);
        nimakarimian.setEmailAddress("nimakauhbbasdfoiuhjbsdf@gmail.com");
        nimakarimian.setNationalId(169512639);
        nimakarimian.setAge(25);
        nimakarimian.setId(951);
        Transaction transaction = session.beginTransaction();

        session.persist(nimakarimian);
        transaction.commit();

    }
}
