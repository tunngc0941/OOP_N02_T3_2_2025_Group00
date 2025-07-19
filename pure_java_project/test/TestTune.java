public class Test {
    public void test() {
        CellPhone noiseMaker = new CellPhone();
        Tune t;
        double d = Math.random();
        if (d > 0.5) 
            t = new Tune();
        else 
            t = new ObnoxiousTune();
            noiseMaker.ring(t);
    }
}