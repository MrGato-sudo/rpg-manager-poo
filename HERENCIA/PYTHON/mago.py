from personaje import Personaje


class Mago(Personaje):
    HECHIZOS = {
        "chispa":        {"costo": 5,  "multiplicador": 1.5},
        "rayo":          {"costo": 10, "multiplicador": 2},
        "bola de fuego": {"costo": 15, "multiplicador": 3},
    }

    def __init__(self, nombre, vida_maxima, fuerza, mana):
        super().__init__(nombre, vida_maxima, fuerza)
        self.mana = max(0, mana)

    def atacar(self, objetivo, hechizo=None):
        # Un solo método: el comportamiento depende de si llega o no "hechizo"
        if hechizo is None or not self.esta_vivo():
            super().atacar(objetivo)   # ataque básico heredado: sin maná
            return

        datos = self.HECHIZOS.get(hechizo.lower())
        if datos is None:
            print(f"{self.nombre} no conoce el hechizo '{hechizo}'.")
            return
        if self.mana < datos["costo"]:
            print(f"{self.nombre} no tiene maná para '{hechizo}' "
                  f"(necesita {datos['costo']}, tiene {self.mana}).")
            return

        self.mana -= datos["costo"]
        dano = int(self.fuerza * datos["multiplicador"])
        print(f"{self.nombre} lanza {hechizo} a {objetivo.nombre} y le causa {dano} de daño.")
        objetivo.recibir_dano(dano)

    def __str__(self):
        return f"{super().__str__()} | Maná: {self.mana}"