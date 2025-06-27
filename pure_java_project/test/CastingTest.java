public class CastingTest {
    public static void testDouble() {
        double d = 5.7;
        int i = (int) d;
        System.out.println("Double to int: " + i);
    }

    public static void testCasting() {
        int i = 10;
        double d = i;
        System.out.println("Int to double: " + d);
    }
}