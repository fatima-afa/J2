package pres;

import dao.daoImpl;
import metier.metierImpl;

public class presStatique {
    public static void main(String[] args) {
        //injection des dépendances par instanctiation statique =>new
        daoImpl daoimp1=new daoImpl();
        metierImpl metier=new metierImpl(daoimp1);
        //metier.setIdao(daoimp1);
        System.out.println("Resultat : "+metier.calcule());
    }
}
