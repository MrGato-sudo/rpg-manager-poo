package rpgmanager;

public class Guerrero extends Personaje {

    private int armadura;

    public Guerrero(String nombre, int vidaMaxima, int fuerza, int armadura) {
        super(nombre, vidaMaxima, fuerza);
        this.armadura = Math.max(0, armadura);
    }

    public int getArmadura() {
        return armadura;
    }

    @Override
    public void recibirDano(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("El daño no puede ser negativo");
        }
        int danoReal = Math.max(0, cantidad - armadura);
        System.out.println(getNombre() + " bloquea " + (cantidad - danoReal)
                + " de daño con su armadura.");
        super.recibirDano(danoReal);
    }

    @Override                          // NUEVO: Grito de guerra
    public void habilidadEspecial() {
        armadura += 3;
        setVida(getVida() + 10);
        System.out.println(getNombre() + " lanza su grito de guerra. Armadura: "
                + armadura + ", vida: " + getVida());
    }

    @Override
    public String toString() {
        return super.toString() + " | Armadura: " + armadura;
    }
}