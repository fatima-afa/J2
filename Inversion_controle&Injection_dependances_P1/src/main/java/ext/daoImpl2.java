package ext;

import dao.Idao;

public class daoImpl2 implements Idao {
    @Override
    public double getData() {
        System.out.println("version capteurs");
        double tmp =80;
        return tmp;
    }
}
