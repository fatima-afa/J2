package pres;

import dao.Idao;
import metier.Imetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner=new Scanner(new File("config.txt"));
        String daoClasseName=scanner.nextLine();
        Class cdao=Class.forName(daoClasseName);
        Idao dao= (Idao) cdao.newInstance();
        System.out.println(dao.getData());

        String metierClassName=scanner.nextLine();
        Class cmetier=Class.forName(metierClassName);
        Imetier metier= (Imetier) cmetier.newInstance();
        //metier.setDao(dao)
        Method method =cmetier.getMethod("setIdao",Idao.class);
        method.invoke(metier,dao);

        System.out.println("resultat : "+metier.calcule());
    }
}
