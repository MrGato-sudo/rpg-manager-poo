package rpgmanager;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ---------- Prueba 1: sobrecarga del Mago ----------
        Personaje muneco = new Personaje("Muñeco", 500, 0);
        Mago magoPrueba = new Mago("Merlín", 70, 12, 20);

        magoPrueba.atacar(muneco);                    // básico: 12 de daño, no gasta maná
        magoPrueba.atacar(muneco, "rayo");            // hechizo: 24 de daño, maná 20 -> 10
        magoPrueba.atacar(muneco, "bola de fuego");   // sin maná suficiente (necesita 15)
        magoPrueba.atacar(muneco, "teletransporte");  // hechizo desconocido
        magoPrueba.atacar(muneco);                    // el básico sigue funcionando sin maná

        // ---------- Prueba 2: combate entre las tres clases ----------
        Guerrero guerrero = new Guerrero("Thorin", 120, 18, 8);
        Mago mago = new Mago("Gandalf", 70, 12, 25);
        Arquero arquero = new Arquero("Legolas", 90, 14, 2);

        mago.atacar(guerrero, "rayo");   // 24, la armadura absorbe 8 -> recibe 16
        arquero.atacar(guerrero);        // 14 - 8 -> recibe 6
        guerrero.atacar(mago);

        System.out.println(guerrero);
        System.out.println(mago);
        System.out.println(arquero);

        // ---------- Polimorfismo ----------
        List<Personaje> grupo = Arrays.asList(guerrero, mago, arquero);
        for (Personaje p : grupo) {
            System.out.println(p);
        }
    }
}