package metier;

import org.junit.Assert;
import org.junit.Test;

public class CalculTest {
    private Calcul calcul;
    @Test
    public void sommeTest(){
        calcul=new Calcul();
        double a=1;double b=1;
        double expected=2;
        double res=calcul.calcul(a,b);
        Assert.assertTrue(res==expected);
    }
}
