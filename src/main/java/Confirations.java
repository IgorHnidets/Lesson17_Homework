import components.DaoStudent;
import components.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

@Configuration
public class Confirations {

    DaoStudent daoStudent = new DaoStudent() {
        @Override
        public Student getStudentById(int id) {
            Session session = getSession();
            TypedQuery<Student> query = session.createQuery("select user from Student user where user.id = :id", Student.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }

        @Override
        public List<Student> getAllStudents() {
            Session session = getSession();
            TypedQuery<Student> query = session.createQuery("select user from Student user", Student.class);
            return query.getResultList();
        }

        @Override
        public void add(Student student) {
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            session.close();
        }

        @Override
        public void remove(int id) {
            Student student = getStudentById(id);
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.remove(student);
            transaction.commit();
            session.close();
        }
    };

    public static Session getSession() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.openSession();
    }
}
