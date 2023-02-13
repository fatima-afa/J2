package metier;

import dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class metierImpl implements Imetier{
   // @Autowired
    private Idao idao;

    public metierImpl(Idao idao) {
        this.idao = idao;
    }

    @Override
    public double calcule() {
        double res= idao.getData()*20;
        return res;
    }
    public void setIdao(Idao idao){
        this.idao=idao;
    }
}
