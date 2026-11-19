package rpgmanager;

public interface Combatiente {
    String getNombre();                      // ver nota abajo
    void atacar(Combatiente objetivo);
    void recibirDano(int cantidad);
    boolean estaVivo();
}