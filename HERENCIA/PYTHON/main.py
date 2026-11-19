from personaje import Personaje
from guerrero import Guerrero
from mago import Mago
from arquero import Arquero

# ---------- Prueba 1: sobrecarga simulada del Mago ----------
muneco = Guerrero("Muñeco", 500, 0, armadura=0)   # NUEVO: ya no se puede usar Personaje
mago_prueba = Mago("Merlín", 70, 12, mana=20)

mago_prueba.atacar(muneco)                    # básico: 12 de daño, no gasta maná
mago_prueba.atacar(muneco, "rayo")            # hechizo: 24 de daño, maná 20 -> 10
mago_prueba.atacar(muneco, "bola de fuego")   # sin maná suficiente (necesita 15)
mago_prueba.atacar(muneco, "teletransporte")  # hechizo desconocido
mago_prueba.atacar(muneco)                    # el básico sigue funcionando sin maná

# ---------- Prueba 2: combate entre las tres clases ----------
guerrero = Guerrero("Thorin", 120, 18, armadura=8)
mago = Mago("Gandalf", 70, 12, mana=25)
arquero = Arquero("Legolas", 90, 14, flechas=2)

mago.atacar(guerrero, "rayo")   # hechizo de 24, la armadura absorbe 8 -> recibe 16
arquero.atacar(guerrero)        # 14 - 8 -> recibe 6
guerrero.atacar(mago)

print(guerrero)
print(mago)
print(arquero)

# ---------- Recursos agotados ----------
mago.atacar(arquero, "rayo")    # maná 15 -> 5
mago.atacar(arquero, "rayo")    # sin maná suficiente
mago.atacar(arquero)            # el básico no necesita maná
arquero.atacar(mago)
arquero.atacar(mago)
arquero.atacar(mago)            # sin flechas

# ---------- NUEVO: habilidades especiales (polimorfismo) ----------
for p in [guerrero, mago, arquero]:
    p.habilidad_especial()      # cada uno ejecuta la suya

# ---------- NUEVO: Personaje ya no se puede instanciar ----------
try:
    Personaje("Aldeano", 50, 5)
except TypeError as e:
    print("Correcto, no se puede instanciar:", e)