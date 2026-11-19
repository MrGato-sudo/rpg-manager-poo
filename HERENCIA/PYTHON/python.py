from abc import ABC, abstractmethod   # NUEVO
from inventario import Inventario


class Personaje(ABC):                 # NUEVO: hereda de ABC
    def __init__(self, nombre, vida_maxima, fuerza):
        self.nombre = nombre
        self.__vida_maxima = max(1, vida_maxima)
        self.__inventario = Inventario()
        self.fuerza = fuerza
        self.__vida = self.__vida_maxima

    @property
    def vida(self):
        return self.__vida

    @vida.setter
    def vida(self, valor):
        self.__vida = max(0, min(valor, self.__vida_maxima))

    @property
    def vida_maxima(self):
        return self.__vida_maxima
    
    @property
    def inventario(self):
        return self.__inventario

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

    @abstractmethod                    # NUEVO
    def habilidad_especial(self):      # NUEVO
        pass                           # NUEVO

    def __str__(self):
        estado = "vivo" if self.esta_vivo() else "muerto"
        return f"{self.nombre} [{self.__vida}/{self.__vida_maxima} HP] ({estado})"