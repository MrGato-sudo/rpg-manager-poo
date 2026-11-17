from personaje import Personaje


class Mago(Personaje):
    COSTO_HECHIZO = 10

    def __init__(self, nombre, vida_maxima, fuerza, mana):
        super().__init__(nombre, vida_maxima, fuerza)
        self.mana = max(0, mana)

    def atacar(self, objetivo):
        if not self.esta_vivo():
            super().atacar(objetivo)  # reutiliza el mensaje de "está muerto"
            return
        if self.mana < self.COSTO_HECHIZO:
            print(f"{self.nombre} no tiene maná suficiente para lanzar un hechizo.")
            return
        self.mana -= self.COSTO_HECHIZO
        dano = self.fuerza * 2  # el hechizo pega el doble que un ataque normal
        print(f"{self.nombre} lanza un hechizo a {objetivo.nombre} y le causa {dano} de daño.")
        objetivo.recibir_dano(dano)

    def __str__(self):
        return f"{super().__str__()} | Maná: {self.mana}"