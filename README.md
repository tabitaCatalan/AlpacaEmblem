*Metodologías de Diseño y programación*

# Alpaca Emblem

Juego de estrategia por turnos. Dos equipos formados por distintos tipos de unidades se enfrentan en un mapa. El objetivo del juego es dejar fuera de combate a una unidad especial del equipo contrario, llamada *Héroe*. Las unidades pueden equipar distintos ítems, y utilizarlos durante el combate. Los ítems tienen debilidades y fortalezas entre ellos.

## Reglas

### Unidades
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
- Unidades básicas:
  - **Archer:** Sólo pueden equiparse *Bows*.  <img src="images/archerEquipped.svg" title="Archer" width="50"/>
  - **Fighter:** Sólo pueden equiparse *Axes*. 
  - **Sword Master:** Sólo pueden equiparse *Swords*. <img src="images/swordMasterReady.svg" title="Sword Master" width="50"/>
- Unidades especiales:
  - **Alpaca:** No pueden equiparse ningún tipo de objeto, pero pueden cargar una cantidad ilimitada de ellos. <img src="images/alpaca.svg" title="Alpaca" width="50"/>
  - **Cleric:** Sólo pueden equiparse *Staffs* y no pueden realizar ataques. <img src="images/clericCombat.svg" title="Cleric" width="50"/>
  - **Hero:** Sólo puede equiparse *Spears*. Al ser derrotado, el jugador que perdió esta unidad pierde la partida (esto no está implementado aún).


### Objetos
Los objetos son elementos que una unidad puede ocupar sobre otra. Para ocupar un objeto, la unidad primero debe equipárselo. Cada objeto tiene un rango definido en [*minRange*, *maxRange*] y sólo pueden utilizarse en unidades que estén dentro de ese rango. El rango de un objeto está acotado inferiormente por 0 y el máximo debe ser estrictamente mayor que el mínimo.

### Mapa
El mapa se puede pensar como una grilla de dimensiones <img src="https://latex.codecogs.com/svg.latex?n&space;\times&space;n" title="n \times n" />, en la que cada casilla puede ser parte del mapa o no.
Más específicamente, el campo de juego se define como un grafo en el que cada nodo representa una celda del mapa. Las celdas pueden estar o no conectadas a otras celdas. Una celda está conectada a otra si son adyacentes: por ejemplo, la celda <img src="https://latex.codecogs.com/svg.latex?(0,0)" title="(0,0)" /> puede estar conectada con la <img src="https://latex.codecogs.com/svg.latex?(0,1)" title="(0,1)" />, referenciándose la una a la otra como vecinas, pero no podría estar conectada con la celda <img src="https://latex.codecogs.com/svg.latex?(1,1)" title="(1,1)" />.
La distancia entre todos los nodos que están directamente conectados es 1.

## Detalles de la Implementación

**Agregar diagrama UML**
- Para tratar con los distintos tipos de ítem se utiliza Double Dispatch.
- Se crea una clase <code>NullItem</code> (que no hace nada), que implementa la interfaz <code>IEquipableItem</code>. Se utiliza para tratar con las unidades que no tienen un ítem equipado. Tiene rango [0,0], y <code>power</code> 0.
- Las unidades no equipadas son vulnerables: recibirán daño aumentado. La Alpaca, por tanto, siempre recibe más daño.
- Se tiene una interfaz <code>IEquipableItem</code>, que define el comportamiento de un ítem estándar. Esta se implementa en la clase abstracta <code>AbstractItem</code>. Esta clase, a su vez, se separa en dos clases abstractas <code>AbstractWeapon</code>, para ítems que pueden atacar y que pueden reaccionar a ataques con un contrataque (como <code>Bow</code> o <code>Axe</code>), y <code>AbstractHealer</code>, para ítems que pueden sanar, pero que no pueden contratacar (como <code>Staff</code>).   
- Para el combate, se agregaron los métodos <code>actOn</code> and <code>reactTo</code> en <code>AbstractItem</code>, simplemente dejándolos en blanco (el comportamiento de un ítem por defecto). Se implementan en <code>AbstractWeapon</code> y <code>AbstractHealer</code> con sus correspondientes variaciones.
## Descripción de los tests

#### Test de Combate
Se crea la clase abstracta <code>CombatTest</code>, donde se implementa un campo de batalla con todas las unidades disponibles, a distancia 2 de una unidad de prueba (que cambiará en las diferentes extensiones de <code>CombatTest</code>). Las posiciones usadas se muestran en la imagen:
<img src="images/positionsCombatTest.svg" title="positionsCombatTest"/>


