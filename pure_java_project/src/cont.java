public class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbr) {
        callbackReference = cbr;
    }
    void go() {
        callbackReference.increment();
    }
}
public class TestCallback {
    public static void main(String[] args) {
        Callee callee = new Callee();
        Caller caller = new Caller(callee);
        caller.go();
    }
}
