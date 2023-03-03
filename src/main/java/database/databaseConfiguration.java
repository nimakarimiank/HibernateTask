package database;

import database.entities.Employee;
import database.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class databaseConfiguration {
    public static Session Config(){
        Configuration configuration = new Configuration();

        configuration.setProperties(getProperties());
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Users.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
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
        props.put("current_session_context_class","thread");
        props.put("hibernate.hbm2ddl.auto","create");
        props.put("show_sql","true");
        props.put("hibernate.default_schema","public");
        return props;
    }
}
