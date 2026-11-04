package rpgmanager;

public class Personaje {

    private String nombre;
    private int vidaMaxima;
    private int vida;
    private int fuerza;

    public Personaje(String nombre, int vidaMaxima, int fuerza) {
        this.nombre = nombre;
        this.vidaMaxima = Math.max(1, vidaMaxima);
        this.fuerza = fuerza;
        this.vida = this.vidaMaxima; // empieza con la vida completa
    }

    // --- Getters ---
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getFuerza() {
        return fuerza;
    }

    // --- Setter con validación (equivalente al @vida.setter de Python) ---
    public void setVida(int valor) {
        // Nunca baja de 0 ni supera la vida máxima
        this.vida = Math.max(0, Math.min(valor, this.vidaMaxima));
    }

    // --- Métodos básicos ---
    public void recibirDano(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("El daño no puede ser negativo");
        }
        setVida(this.vida - cantidad); // pasa por el setter, no por this.vida
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public void atacar(Personaje objetivo) {
        if (!estaVivo()) {
            System.out.println(nombre + " está muerto y no puede atacar.");
            return;
        }
        System.out.println(nombre + " ataca a " + objetivo.getNombre()
                + " y le causa " + fuerza + " de daño.");
        objetivo.recibirDano(fuerza);
    }

    @Override
    public String toString() {
        String estado = estaVivo() ? "vivo" : "muerto";
        return nombre + " [" + vida + "/" + vidaMaxima + " HP] (" + estado + ")";
    }
}