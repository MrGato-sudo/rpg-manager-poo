from guerrero import Guerrero
from mago import Mago
from arquero import Arquero

guerrero = Guerrero("Thorin", 120, 18, armadura=8)
mago = Mago("Merlín", 70, 12, mana=25)
arquero = Arquero("Legolas", 90, 14, flechas=2)

mago.atacar(guerrero)      # hechizo de 24, la armadura absorbe 8 -> recibe 16
arquero.atacar(guerrero)   # 14 - 8 -> recibe 6
guerrero.atacar(mago)

print(guerrero)
print(mago)
print(arquero)

# Recursos agotados
mago.atacar(arquero)       # 2.º hechizo, maná 5
mago.atacar(arquero)       # sin maná
arquero.atacar(mago)
arquero.atacar(mago)
arquero.atacar(mago)       # sin flechas

# Polimorfismo: todos son Personaje
for p in [guerrero, mago, arquero]:
    print(p)