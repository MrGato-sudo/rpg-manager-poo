package rpgmanager;

public class Mago extends Personaje {

    private int mana;

    public Mago(String nombre, int vidaMaxima, int fuerza, int mana) {
        super(nombre, vidaMaxima, fuerza);
        this.mana = Math.max(0, mana);
    }

    public int getMana() {
        return mana;
    }

    // Versión 1: ataque básico (sin gastar maná). Sobrescribe el de Personaje.
    @Override
    public void atacar(Personaje objetivo) {
        super.atacar(objetivo);
    }

    // Versión 2: ataque con hechizo. Es una SOBRECARGA (método nuevo, sin @Override).
    public void atacar(Personaje objetivo, String hechizo) {
        if (hechizo == null || !estaVivo()) {
            atacar(objetivo); // básico; si está muerto, el padre imprime el mensaje
            return;
        }

        int costo = costoDe(hechizo);
        if (costo < 0) {
            System.out.println(getNombre() + " no conoce el hechizo '" + hechizo + "'.");
            return;
        }
        if (mana < costo) {
            System.out.println(getNombre() + " no tiene maná para '" + hechizo
                    + "' (necesita " + costo + ", tiene " + mana + ").");
            return;
        }

        mana -= costo;
        int dano = (int) (getFuerza() * multiplicadorDe(hechizo));
        System.out.println(getNombre() + " lanza " + hechizo + " a " + objetivo.getNombre()
                + " y le causa " + dano + " de daño.");
        objetivo.recibirDano(dano);
    }

    private static int costoDe(String hechizo) {
        switch (hechizo.toLowerCase()) {
            case "chispa":        return 5;
            case "rayo":          return 10;
            case "bola de fuego": return 15;
            default:              return -1; // hechizo desconocido
        }
    }

    private static double multiplicadorDe(String hechizo) {
        switch (hechizo.toLowerCase()) {
            case "chispa":        return 1.5;
            case "rayo":          return 2.0;
            case "bola de fuego": return 3.0;
            default:              return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Maná: " + mana;
    }
}