import java.util.Random;
public class randNum {
    public static int TestRN() {
        Random r = new Random();
        int num = r.nextInt(1000);
        return num;
    }
}
