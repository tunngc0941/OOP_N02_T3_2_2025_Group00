public class SwitchCake {
    public static void switchCase() {
        int choice = 2;
        switch (choice) {
            case 1:
                System.out.println("Ban chon Chocolate.");
                break;
            case 2:
                System.out.println("Ban da chon Vanilla.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}