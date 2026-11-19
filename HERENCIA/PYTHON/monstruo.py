class Monstruo:
    def __init__(self, nombre, vida_maxima, dano):
        self.nombre = nombre
        self.__vida_maxima = max(1, vida_maxima)
        self.__vida = self.__vida_maxima
        self.dano = dano

    @property
    def vida(self):
        return self.__vida

    @vida.setter
    def vida(self, valor):
        self.__vida = max(0, min(valor, self.__vida_maxima))

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
        print(f"{self.nombre} ataca a {objetivo.nombre} y le causa {self.dano} de daño.")
        objetivo.recibir_dano(self.dano)

    def __str__(self):
        estado = "vivo" if self.esta_vivo() else "muerto"
        return f"{self.nombre} [{self.__vida}/{self.__vida_maxima} HP] ({estado})"