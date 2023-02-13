package pres;

import metier.Imetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class preSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("dao","metier");
        //si je connais pas le nom de bean exat je lui dit just donne moi un bean qui implement
        //l'interface Imetier
        Imetier metier=context.getBean(Imetier.class);
        System.out.println(metier.calcule());
    }
}
