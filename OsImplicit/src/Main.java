public class Main {

    public int gana = 10;
    public final int cappot = 10;
    static final int os = 1;
    static final int abelles = 4;

    public static void main(String[] args) throws Exception {
        new Main().inicio();
    }

    public void inicio() {
        SynchronizedPot pot = new SynchronizedPot(10);
        Thread[] threads = new Thread[os + abelles];
        int t = 0, i;

        // cream el fils dels osos
        for (i = 0; i < os; i++) {
            threads[t] = new Thread(new Os(pot, gana));
            threads[t].start();
            t++;
        }

        // cream el fils de les abelles
        for (i = 0; i < abelles; i++) {
            threads[t] = new Thread(new Abelles(pot));
            threads[t].start();
            t++;
        }

    }

}
