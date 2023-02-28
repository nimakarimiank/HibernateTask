package database;

import database.entities.Employees;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class databaseConfiguration {
    public static Session Config(){
        Configuration configuration = new Configuration();
        configuration.setProperties(getProperties());
        configuration.addAnnotatedClass(Employees.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
    private static Properties getProperties(){
        final String hostName = "localhost";
        final String portNumber = "5432";
        final String url = "jdbc:postgresql://"+hostName+":"+portNumber+"/employee";

        Properties props = new Properties();
        props.put("hibernate.connection.username","postgres");
        props.put("hibernate.connection.password","nimakarimian76");
        props.put("hibernate.connection.driver_class","org.postgresql.Driver");
        props.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.connection.url",url);
        props.put("hbm2ddl.auto","create");

        return props;
    }
}
