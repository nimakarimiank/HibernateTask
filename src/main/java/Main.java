import database.databaseConfiguration;
import database.entities.Department;
import database.entities.Project;
import database.entities.subentities.Contact;
import database.entities.Employee;
import database.entities.subentities.Gender;
import database.entities.subentities.contactType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args){
    try {

        Session session =databaseConfiguration.Config();
        Transaction transaction = session.beginTransaction();
        //Read-Fulljoin
//        Query query = session.createQuery("select e.firstName,e.lastName,d.departmentName from Employee e " +
//                                                  "full join department d on e.department.id = d.id"
//                                                  );
//
//        List<Object[]> employees =(List<Object[]>) query.getResultList();
//        for (Object[] elem :
//                employees) {
//            System.out.println(elem[0]+" "+elem[1]+" "+elem[2]+" ");
//        }
//


        //Read-InnerJoin
        Query secondQuery = session.createQuery(" select d.departmentName, p.projectName from  department as  d , project as p inner join " +
                                                        "department.projects as dp on dp.id =p.id");
        List<Object[]> hqldepartmentsProjectsList = (List<Object[]>) secondQuery.getResultList();
        for (Object[] elem:hqldepartmentsProjectsList){
            System.out.println(elem[0]+ " "+ elem[1]);
        }
            //SQL JOIN ON DEPARTMENT - PROJECT - DEPARTMENT_PROJECT
//            Query thirdQuery  = session.createSQLQuery("select department.departmentname , project.projectname from department" +
//                                                               " join project_department on department.id = project_department.departments_id" +
//                                                               " join project on project_department.projects_id = project.id");
//            List<Object[]> sqldepartmentsProjectsList = (List<Object[]>) thirdQuery.getResultList();
//            for (Object[] elem:sqldepartmentsProjectsList){
//                System.out.println(elem[0]+ " "+ elem[1]);
//            }

//        select public.department.departmentname , public.project.projectname from public.department
//        join public.project_department on department.id = project_department.departments_id join public.project on project_department.projects_id = project.id
        transaction.commit();
        session.close();
    }
    catch (Exception e ){

        System.out.println(e.getMessage());
    }

    }

}
