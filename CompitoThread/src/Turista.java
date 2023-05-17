public class Turista extends Thread {
    
    private Museo m;

    public Turista (String surname, Museo m) {

        super(surname);
        this.m = m;
    }

    @Override
    public void run() {

        try{
            sleep((int)(Math.random() * 2000) + 500); //0.5 - 2.5 secondi
        }catch(Exception ex) {}

        m.entra();

        try{
            sleep((int)(Math.random() * 3000) + 1000); //1 - 4 secondi
        }catch(Exception ex) {}

        m.esci();
    }
}
