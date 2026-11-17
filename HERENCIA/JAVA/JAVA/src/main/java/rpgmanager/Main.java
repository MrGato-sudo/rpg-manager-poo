package rpgmanager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Thorin", 120, 18, 8);
        Mago mago = new Mago("Merlín", 70, 12, 25);
        Arquero arquero = new Arquero("Legolas", 90, 14, 2);

        mago.atacar(guerrero);      // hechizo de 24, la armadura absorbe 8 -> recibe 16
        arquero.atacar(guerrero);   // 14 - 8 -> recibe 6
        guerrero.atacar(mago);

        System.out.println(guerrero);
        System.out.println(mago);
        System.out.println(arquero);

        // Recursos agotados
        mago.atacar(arquero);       // 2.º hechizo, maná 5
        mago.atacar(arquero);       // sin maná
        arquero.atacar(mago);
        arquero.atacar(mago);
        arquero.atacar(mago);       // sin flechas

        // Polimorfismo: una lista de Personaje con tres tipos distintos
        List<Personaje> grupo = List.of(guerrero, mago, arquero);
        for (Personaje p : grupo) {
            System.out.println(p);  // cada uno ejecuta su propio toString()
        }
    }
}