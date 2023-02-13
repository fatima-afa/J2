package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class daoImpl implements Idao{
    @Override
    public double getData() {
        System.out.println("version base de donne");
        double temp=Math.random()*40;

        return temp;
    }
}
