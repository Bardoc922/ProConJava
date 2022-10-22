public class Abelles implements Runnable {
    SynchronizedPot pot;

    public Abelles(SynchronizedPot pot) {
        this.pot = pot;
    }

    // contador per saber el total produit
    public static int totprod = 0;

    @Override
    public void run() {
        long id = Thread.currentThread().getId() - 23;
        System.out.println("Abella" + id);

        // les abelles produeixen per sempre
        while (true) {
            pot.produir();
            System.out.println(id + " ha produit");
            totprod++;
        }
    }

}
