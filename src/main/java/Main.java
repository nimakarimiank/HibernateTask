import database.databaseConfiguration;
import database.entities.Department;
import database.entities.Project;
import database.entities.subentities.Contact;
import database.entities.Employee;
import database.entities.subentities.Gender;
import database.entities.subentities.contactType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args){
    try {

        Session session =databaseConfiguration.Config();
        Transaction transaction = session.beginTransaction();
        //Insert
        new Employee().readEmployees(2);
        //Fetch Data
        //

        transaction.commit();
        session.close();
    }
    catch (Exception e ){

        System.out.println(e.getMessage());
    }

    }

}
