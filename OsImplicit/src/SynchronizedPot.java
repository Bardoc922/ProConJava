class SynchronizedPot {
    private int captot;
    private int quanact = 0;

    public SynchronizedPot(int captot) {
        this.captot = captot;
    }

    // clase productors
    synchronized public void produir() {
        while (quanact == captot) {
            try {
                this.wait();
            } catch (InterruptedException e) {

            }
        }
        quanact++;
        notifyAll();

    }

    // clase consumidors
    synchronized public void menjar() {
        while (captot != quanact) {
            try {
                notifyAll();
                this.wait();
            } catch (InterruptedException e) {

            }
        }
        quanact = 0;
        notifyAll();
    }
}