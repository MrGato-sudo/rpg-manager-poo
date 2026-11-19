package rpgmanager;

public class Arquero extends Personaje {

    private int flechas;

    public Arquero(String nombre, int vidaMaxima, int fuerza, int flechas) {
        super(nombre, vidaMaxima, fuerza);
        this.flechas = Math.max(0, flechas);
    }

    public int getFlechas() {
        return flechas;
    }

    @Override
public void atacar(Combatiente objetivo) {      // antes: Personaje objetivo
        if (!estaVivo()) {
            super.atacar(objetivo);
            return;
        }
        if (flechas == 0) {
            System.out.println(getNombre() + " se quedó sin flechas.");
            return;
        }
        flechas--;
        System.out.println(getNombre() + " dispara una flecha a " + objetivo.getNombre()
                + " y le causa " + getFuerza() + " de daño.");
        objetivo.recibirDano(getFuerza());
    }

    public void recogerFlechas(int cantidad) {
        flechas += Math.max(0, cantidad);
    }

    @Override                          // NUEVO: Recolectar flechas
    public void habilidadEspecial() {
        recogerFlechas(5);
        System.out.println(getNombre() + " recolecta 5 flechas. Flechas: " + flechas);
    }

    @Override
    public String toString() {
        return super.toString() + " | Flechas: " + flechas;
    }
}