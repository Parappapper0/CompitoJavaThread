public class Main {
    public static void main(String[] args) throws Exception {
        
        Museo louvre = new Museo(5);

        for(int i = 0; i < 50; i++) {

            String nome = "Turista " + (i + 1);
            Turista t = new Turista(nome, louvre);
            t.start();
        }
    }
}
