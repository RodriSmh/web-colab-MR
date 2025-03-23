##las listas se pueden modificar
list=["Rodrigo","27"]

list[1]="Alonso"
print(list)
##las tuplas no se pueden modificar
Tupla=("Rodrigo","27")

Tupla[1]="Alonso"
print(Tupla)

##conjunto
conjunto={"hola"}

##diccionario
diccionario={
    'nombre' : 'rodrigo',
    'apellido': 'paez'
}
print(diccionario["nombre"])