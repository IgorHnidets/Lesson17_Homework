import components.DaoStudent;
import components.Student;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;


public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Confirations.class);
        context.refresh();
        Student student = new Student("Oleg",20);
        Confirations bean = context.getBean(Confirations.class);
        bean.daoStudent.add(new Student("Andriy",30));


    }


}
