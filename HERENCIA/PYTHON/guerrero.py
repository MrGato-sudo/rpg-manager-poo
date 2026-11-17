from personaje import Personaje


class Guerrero(Personaje):
    def __init__(self, nombre, vida_maxima, fuerza, armadura):
        super().__init__(nombre, vida_maxima, fuerza)
        self.armadura = max(0, armadura)

    def recibir_dano(self, cantidad):
        if cantidad < 0:
            raise ValueError("El daño no puede ser negativo")
        dano_real = max(0, cantidad - self.armadura)
        print(f"{self.nombre} bloquea {cantidad - dano_real} de daño con su armadura.")
        super().recibir_dano(dano_real)

    def __str__(self):
        return f"{super().__str__()} | Armadura: {self.armadura}"