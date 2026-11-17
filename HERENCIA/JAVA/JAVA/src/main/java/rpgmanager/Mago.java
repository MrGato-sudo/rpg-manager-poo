package rpgmanager;

public class Mago extends Personaje {

    private static final int COSTO_HECHIZO = 10;

    private int mana;

    public Mago(String nombre, int vidaMaxima, int fuerza, int mana) {
        super(nombre, vidaMaxima, fuerza);
        this.mana = Math.max(0, mana);
    }

    public int getMana() {
        return mana;
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (!estaVivo()) {
            super.atacar(objetivo); // reutiliza el mensaje de "está muerto"
            return;
        }
        if (mana < COSTO_HECHIZO) {
            System.out.println(getNombre() + " no tiene maná suficiente para lanzar un hechizo.");
            return;
        }
        mana -= COSTO_HECHIZO;
        int dano = getFuerza() * 2; // el hechizo pega el doble que un ataque normal
        System.out.println(getNombre() + " lanza un hechizo a " + objetivo.getNombre()
                + " y le causa " + dano + " de daño.");
        objetivo.recibirDano(dano);
    }

    @Override
    public String toString() {
        return super.toString() + " | Maná: " + mana;
    }
}