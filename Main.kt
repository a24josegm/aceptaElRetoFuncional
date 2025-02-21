package Programacion01.PF.entrega

/*

problema acepta el reto estilo funcional


recuerda el ejercicio Va de modas que solucionamos funcionalmente.

Selecciona ahora tu un enunciado para resolver funcionalmente  de entre los siguientes  problemas:


K bucles sencillos de acepta el reto // K bucles dificultad media de acepta el reto

Y genera una solución que funcione en coderunner lo más funcional posible. Evita for, while, if imperativos etc.


EL ASCENSOR
Problema número 156
http://www.aceptaelreto.com/problem/statement.php?id=156

Las máquinas son incansables; una vez puestas en marcha, estarán funcionando sin quejarse por muchas veces que les pidas hacer lo mismo.

Pensemos en un ascensor, por ejemplo. Empieza el día en el bajo; el del primero le llama y le hace subir al quinto. Justo después le llaman en el segundo y le toca bajar a la planta baja. Luego el del tercero quiere ir a ver al del noveno... Al final del día ha hecho un largo recorrido de arriba a abajo, y de abajo a arriba. ¿Cuál es la longitud de ese recorrido?
Entrada

La entrada contiene distintos casos de prueba, cada uno en una línea. En cada una de ellas hay una secuencia de enteros. El primero marca el piso inicial en el que empieza el ascensor (el 0 marca la planta baja; no hay plantas por debajo de ella). A continuación aparecen parejas de enteros, cada uno de ellos representando el uso del ascensor por parte de un vecino, con el piso desde el que llama al ascensor y con el piso destino. La lista termina con un -1.

La entrada acaba con una línea en la que el ascensor comienza por debajo de la planta baja.
Salida

Para cada caso de prueba se mostrará una línea en la que aparecerá la longitud (en número de pisos) del recorrido completo del ascensor a lo largo del día.



Por ejemplo:
Entrada 	            Resultado

0 1 5 2 0 3 9 -1        19
5 5 4 -1                1
1 2 3 4 5 -1            4
-1                      0

 */


fun main() {
    val input = listOf(
        listOf(0, 1, 5, 2, 0, 3, 9, -1),
        listOf(5, 5, 4, -1),
        listOf(1, 2, 3, 4, 5, -1),
        listOf(-1)
    )

    input.forEach { case ->
        println(calculateElevatorJourney(case))
    }
}

fun calculateElevatorJourney(journey: List<Int>): Int {
    if (journey.first() == -1) return 0

    return journey
        .takeWhile { it != -1 }
        .windowed(2, 2, false)
        .map { (start, end) -> Math.abs(start - end) }
        .sum()
}