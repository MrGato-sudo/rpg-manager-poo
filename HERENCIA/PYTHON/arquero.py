from personaje import Personaje


class Arquero(Personaje):
    def __init__(self, nombre, vida_maxima, fuerza, flechas):
        super().__init__(nombre, vida_maxima, fuerza)
        self.flechas = max(0, flechas)

    def atacar(self, objetivo):
        if not self.esta_vivo():
            super().atacar(objetivo)
            return
        if self.flechas == 0:
            print(f"{self.nombre} se quedó sin flechas.")
            return
        self.flechas -= 1
        print(f"{self.nombre} dispara una flecha a {objetivo.nombre} y le causa {self.fuerza} de daño.")
        objetivo.recibir_dano(self.fuerza)

    def recoger_flechas(self, cantidad):
        self.flechas += max(0, cantidad)

    def __str__(self):
        return f"{super().__str__()} | Flechas: {self.flechas}"