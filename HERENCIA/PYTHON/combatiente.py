from typing import Protocol, runtime_checkable


@runtime_checkable
class Combatiente(Protocol):
    nombre: str                                    # ver nota abajo

    def atacar(self, objetivo): ...
    def recibir_dano(self, cantidad): ...
    def esta_vivo(self): ...