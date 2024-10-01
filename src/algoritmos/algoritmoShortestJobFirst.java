package algoritmos;
import java.util.*;

/**
 * El objetivo es ejecutar primero el proceso con el menor tiempo de ejecución.
 * */


public class algoritmoShortestJobFirst {

	public static void main(String[] args) {
        List<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso(1, 3));
        procesos.add(new Proceso(2, 5));
        procesos.add(new Proceso(3, 2));

        //
        PriorityQueue<Proceso> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(p -> p.tiempoEjecucion));
        colaPrioridad.addAll(procesos);

        int tiempoActual = 0;
        while (!colaPrioridad.isEmpty()) {
            Proceso procesoActual = colaPrioridad.poll();
            System.out.println("Ejecutando proceso " + procesoActual.id + " durante " + procesoActual.tiempoEjecucion + " unidades de tiempo");
            tiempoActual += procesoActual.tiempoEjecucion;
        }
	}

}
