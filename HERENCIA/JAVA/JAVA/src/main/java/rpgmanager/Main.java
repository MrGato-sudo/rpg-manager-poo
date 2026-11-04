package rpgmanager;

public class Main {
    public static void main(String[] args) {
        Personaje heroe = new Personaje("Aria", 100, 15);
        Personaje orco = new Personaje("Grok", 60, 20);

        heroe.atacar(orco);
        orco.atacar(heroe);
        System.out.println(heroe);
        System.out.println(orco);

        heroe.setVida(999);          // se limita a 100
        System.out.println(heroe.getVida());
        orco.recibirDano(500);       // se limita a 0
        System.out.println(orco);    // Grok [0/60 HP] (muerto)
    }
}