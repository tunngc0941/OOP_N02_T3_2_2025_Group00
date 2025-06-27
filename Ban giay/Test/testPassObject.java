import Number;
import PassObject;

package Test;
public class testPassObject{



    public static void testHanh(){
        Number n = new Number();
        n.i=14;
        PassObject.f(n);
        System.out.println(n.i);
    }
}