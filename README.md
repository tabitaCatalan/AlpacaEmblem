*Metodologías de Diseño y programación*

# Alpaca Emblem

Juego de estrategia por turnos. Dos equipos formados por distintos tipos de unidades se enfrentan en un mapa. El objetivo del juego es dejar fuera de combate a una unidad especial del equipo contrario, llamada *Héroe*. Las unidades pueden equipar distintos ítems, y utilizarlos durante el combate. Los ítems tienen debilidades y fortalezas entre ellos.

## Unidades
Actualmente el juego cuenta con 6 tipos de unidades, las cuales comparten las siguientes características:
- **Hit points:** Es la cantidad de daño que puede recibir la unidad antes de quedar fuera de combate (i.e. la unidad no puede seguir utilizándose y deja el campo de juego). Para esto, se tienen 2 contadores: uno que indica
los hit points máximos de la unidad, y otro que indica la cantidad actual.
- **Movement:** Representa la cantidad máxima de celdas del mapa que puede desplazarse una unidad. Esto significa
que en cada turno una unidad puede ubicarse en cualquier posición del mapa que se encuentre entre 0
y *movement* celdas de distancia desde su sitio actual.
- **Location:** Es la ubicación actual de una unidad en el mapa.
- **Items:** Es una lista con los objetos que porta la unidad. Además, dependiendo del tipo de objeto, algunas unidades podrán equiparse alguno de estos.

Exceptuando la Alpaca, todas las unidades pueden portar a lo más 3 objetos.
Los tipos de unidades se listan a continuación:
### Unidades básicas:
- **Archer:** Sólo pueden equiparse *Bows*.
- **Fighter:** Sólo pueden equiparse *Axes*.
- **Sword Master:** Sólo pueden equiparse Swords.
### Unidades especiales:
- **Alpaca:** No pueden equiparse ningún tipo de objeto, pero pueden cargar una cantidad ilimitada de ellos.
- **Cleric:** Sólo pueden equiparse Staffs y no pueden realizar ataques.
- **Hero:** Sólo puede equiparse Spears. Al ser derrotado, el jugador que perdió esta unidad pierde la partida (esto no está implementado aún).


## Objetos
Los objetos son elementos que una unidad puede ocupar sobre otra. Para ocupar un objeto, la unidad primero debe equipárselo. Cada objeto tiene un rango definido en [*minRange*, *maxRange*] y sólo pueden utilizarse en unidades que estén dentro de ese rango. El rango de un objeto está acotado inferiormente por 0 y el máximo debe ser estrictamente mayor que el mínimo.

## Mapa
El mapa se puede pensar como una grilla de dimensiones <img src="https://latex.codecogs.com/svg.latex?n&space;\times&space;n" title="n \times n" />, en la que cada casilla puede ser parte del mapa o no.
Más específicamente, el campo de juego se define como un grafo en el que cada nodo representa una celda del mapa y pueden estar o no conectada a otras celdas. Una celda está conectada a otra si están adyacentes (por ejemplo, la celda (0, 0) puede estar conectada con la (0, 1)) y se referencian una a otra como vecinos.
Para simplificar, puede asumir que la distancia entre todos los nodos que están directamente conectados tienen distancia 1 entre ellos.



## Detalles de la Implementación
- Para tratar con los distintos tipos de ítem se utiliza Double Dispatch.
- Se quiere usar un objeto NullItem (que no hace nada) para tratar con las unidades que no tienen un item equipado.

