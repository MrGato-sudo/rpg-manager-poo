package rpgmanager;

public class Monstruo implements Combatiente {

    private final String nombre;
    private final int vidaMaxima;
    private int vida;
    private final int dano;

    public Monstruo(String nombre, int vidaMaxima, int dano) {
        this.nombre = nombre;
        this.vidaMaxima = Math.max(1, vidaMaxima);
        this.vida = this.vidaMaxima;
        this.dano = dano;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int valor) {
        this.vida = Math.max(0, Math.min(valor, vidaMaxima));
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void recibirDano(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("El daño no puede ser negativo");
        }
        setVida(vida - cantidad);
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        if (!estaVivo()) {
            System.out.println(nombre + " está muerto y no puede atacar.");
            return;
        }
        System.out.println(nombre + " ataca a " + objetivo.getNombre()
                + " y le causa " + dano + " de daño.");
        objetivo.recibirDano(dano);
    }

    @Override
    public String toString() {
        String estado = estaVivo() ? "vivo" : "muerto";
        return nombre + " [" + vida + "/" + vidaMaxima + " HP] (" + estado + ")";
    }
}