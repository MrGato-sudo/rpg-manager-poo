class Personaje:
    def __init__(self, nombre, vida_maxima, fuerza):
        self.nombre = nombre
        self.__vida_maxima = max(1, vida_maxima)
        self.fuerza = fuerza
        self.__vida = self.__vida_maxima 

    @property
    def vida(self):
        return self.__vida

    @vida.setter
    def vida(self, valor):
        # Nunca baja de 0 ni supera la vida máxima
        self.__vida = max(0, min(valor, self.__vida_maxima))

    @property
    def vida_maxima(self):
        return self.__vida_maxima

    # --- Métodos básicos ---
    def recibir_dano(self, cantidad):
        if cantidad < 0:
            raise ValueError("El daño no puede ser negativo")   
        self.vida = self.__vida - cantidad

    def esta_vivo(self):
        return self.__vida > 0

    def atacar(self, objetivo):
        if not self.esta_vivo():
            print(f"{self.nombre} está muerto y no puede atacar.")
            return
        print(f"{self.nombre} ataca a {objetivo.nombre} y le causa {self.fuerza} de daño.")
        objetivo.recibir_dano(self.fuerza)

    def __str__(self):
        estado = "vivo" if self.esta_vivo() else "muerto"
        return f"{self.nombre} [{self.__vida}/{self.__vida_maxima} HP] ({estado})"

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


    