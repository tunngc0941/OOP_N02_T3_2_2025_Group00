public class Flower {
    int petalCount = 0;
    String s = new String("null");
    Flower(int petals) {petalCount = petals; }
    Flower(String ss) {s = ss;}
    Flower(int petals, String s) {
        this(petals);
        this.s = s;
    } 
}
