public class Os implements Runnable {

    SynchronizedPot pot;
    int gana;

    public Os(SynchronizedPot pot, int gana) {
        this.pot = pot;
        this.gana = gana;
    }

    @Override
    public void run() {
        long id = Thread.currentThread().getId() - 23;
        System.out.println("Os" + id);

        // mentre te gana l'os va menjant
        while (gana != 0) {
            pot.menjar();
            gana--;
            System.out.println("Os " + id + " Ha menjat " + (10 - gana) + " de " + 10);

        }

        // posam un sleep per esperar que els altres fils es bloquetgin
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // mostram el total que han produit les abelles per assegurar que ha funcionat
        System.out.println(Abelles.totprod);
        System.exit(0);

    }

}
