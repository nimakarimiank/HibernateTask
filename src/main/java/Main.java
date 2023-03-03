import database.databaseConfiguration;
import database.entities.Employee;
import database.entities.Gender;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args){
    try {
        Session session =databaseConfiguration.Config();
        Transaction transaction =session.beginTransaction() ;
        Employee employee = new Employee(1, 2169514, 6219, "nima", "karimian", "ei9ubound", Gender.MALE);
        session.save(employee);
        transaction.commit();
        session.close();
    }
    catch (Exception e ){

        System.out.println(e.getMessage());
    }

    }

}
