import database.databaseConfiguration;
import database.entities.Department;
import database.entities.Project;
import database.entities.subentities.Contact;
import database.entities.Employee;
import database.entities.subentities.Gender;
import database.entities.subentities.contactType;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args){
    try {

        Session session =databaseConfiguration.Config();
        Transaction transaction = session.beginTransaction();
        Project project = new Project("Java Spring");
        Department department = new Department("IRISA");
        project.getDepartments().add(department);
        department.getProjects().add(project);
        session.persist(department);
        session.persist(project);
        //Insert

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
