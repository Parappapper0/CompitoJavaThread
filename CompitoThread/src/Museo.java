public class Museo {

    private final int posti;
    private int postiInUso;
    private int inAttesa;

    public Museo(int posti) {
        this.posti = posti;
        postiInUso = 0;
        inAttesa = 0;
    }

    public synchronized void entra () {
        
        inAttesa++;

        while(postiInUso == posti) {
            try{
                wait();
            }catch(Exception ex) {}
        }

        inAttesa--;

        postiInUso++;
        System.out.print("\u001B[31m" + Thread.currentThread().getName() + " entra nel museo (posti rimanenti: " + (posti - postiInUso) + "/" + posti + ")");
        System.out.println("\u001B[34m -- Persone in attesa: " + inAttesa);
    }

    public synchronized void esci () {
        
        postiInUso--;
        System.out.println("\u001B[32m" + Thread.currentThread().getName() + " esce dal museo (posti rimanenti: " + (posti - postiInUso) + "/" + posti + ")");
        notifyAll();
    }
}
