import database.databaseConfiguration;
import database.entities.Department;
import database.entities.Project;
import database.entities.subentities.Contact;
import database.entities.Employee;
import database.entities.subentities.Gender;
import database.entities.subentities.contactType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    public static void innerJoin_Department() {
        TypedQuery<Department> query
                = databaseConfiguration.Config().createQuery(
                "SELECT d FROM Employee e INNER JOIN e.department.departmentName d", Department.class);
        List<Department> resultList = query.getResultList();
        resultList.stream().map(p-> {
            p.getDepartmentName();
            return p;
        });

    }
    public static void main(String[] args){
    try {

        Session session =databaseConfiguration.Config();
        Transaction transaction = session.beginTransaction();
        //Insert
        new Employee().readEmployees();
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
