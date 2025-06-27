public class ShortCircuitTest {
    public static void test() {
        int x = 0;
        if (x != 0 && 10 / x > 1) {
            System.out.println("Won't execute due to short-circuit.");
        } else {
            System.out.println("Short-circuit prevents division by zero.");
        }
    }
}