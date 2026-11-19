package rpgmanager;

public abstract class Personaje implements Combatiente {   // NUEVO: implements

    private String nombre;
    private int vidaMaxima;
    private int vida;
    private int fuerza;
    private final Inventario inventario;

    public Personaje(String nombre, int vidaMaxima, int fuerza) {
        this.nombre = nombre;
        this.vidaMaxima = Math.max(1, vidaMaxima);
        this.fuerza = fuerza;
        this.vida = this.vidaMaxima;
        this.inventario = new Inventario();
    }

    @Override                                              // NUEVO
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
    
    public Inventario getInventario() {
        return inventario;
    }

    public void setVida(int valor) {
        this.vida = Math.max(0, Math.min(valor, this.vidaMaxima));
    }

    @Override                                              // NUEVO
    public void recibirDano(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("El daño no puede ser negativo");
        }
        setVida(this.vida - cantidad);
    }

    @Override                                              // NUEVO
    public boolean estaVivo() {
        return this.vida > 0;
    }

    @Override                                              // NUEVO
    public void atacar(Combatiente objetivo) {             // antes: Personaje objetivo
        if (!estaVivo()) {
            System.out.println(nombre + " está muerto y no puede atacar.");
            return;
        }
        System.out.println(nombre + " ataca a " + objetivo.getNombre()
                + " y le causa " + fuerza + " de daño.");
        objetivo.recibirDano(fuerza);
    }

    public abstract void habilidadEspecial();

    @Override
    public String toString() {
        String estado = estaVivo() ? "vivo" : "muerto";
        return nombre + " [" + vida + "/" + vidaMaxima + " HP] (" + estado + ")";
    }
}