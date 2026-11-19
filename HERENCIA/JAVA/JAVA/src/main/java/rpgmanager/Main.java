package rpgmanager;

import java.util.Arrays;
import java.util.List;

public class Main {
    static void duelo(Combatiente a, Combatiente b) {
        for (int ronda = 1; ronda <= 10; ronda++) {
            System.out.println("--- Ronda " + ronda + " ---");
            a.atacar(b);
            if (!b.estaVivo()) break;
            b.atacar(a);
            if (!a.estaVivo()) break;
    }
        Combatiente ganador = a.estaVivo() ? a : b;
        System.out.println("Ganador: " + ganador.getNombre());
}
    public static void main(String[] args) {
        // ---------- Prueba 1: sobrecarga del Mago ----------
        Guerrero muneco = new Guerrero("Muñeco", 500, 0, 0);   // NUEVO: ya no new Personaje(...)
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

        // ---------- NUEVO: habilidades especiales (polimorfismo) ----------
        List<Personaje> grupo = Arrays.asList(guerrero, mago, arquero);
        for (Personaje p : grupo) {
            p.habilidadEspecial();       // cada uno ejecuta la suya
        }

        // Personaje p = new Personaje("Aldeano", 50, 5);
        // ^ Si quitas el comentario, NO compila: "Personaje is abstract; cannot be instantiated"
        // ---------- Reto 6: contrato Combatiente ----------
        Monstruo goblin = new Monstruo("Goblin", 60, 10);

        List<Combatiente> combatientes = Arrays.asList(guerrero, mago, arquero, goblin);
            for (Combatiente c : combatientes) {
        System.out.println(c.getNombre() + " vivo? " + c.estaVivo());
}

        duelo(new Guerrero("Thorin", 120, 18, 8), goblin);
    }
}