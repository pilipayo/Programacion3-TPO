package Jugadores;

import Things.Personajes;
import java.util.List;
import java.util.Scanner;

public class JugadorHumano extends Jugador {

    public JugadorHumano(List<Personajes> listaCompleta) {
        super(listaCompleta);
    }

    // Jugador humano, pide el id por consola, valida que exista en la lista
    @Override
    protected Personajes elegirPersonajeSecreto(List<Personajes> personajesDisponibles) {
        Scanner teclado = new Scanner(System.in);
        Personajes elegido = null;

        while (elegido == null) {
            System.out.println("Elegi tu personaje secreto (el que el rival tiene que adivinar):");
            for (Personajes p : personajesDisponibles) {
                System.out.println(p.get_ID() + " - " + p.get_Nombre() + " " + p.get_Apellido());
            }
            System.out.print("Ingresa el numero (id) del personaje: ");

            if (teclado.hasNextInt()) {
                int idElegido = teclado.nextInt();
                elegido = buscarPorId(personajesDisponibles, idElegido);
                if (elegido == null) {
                    System.out.println("Ese numero no corresponde a ningun personaje de la lista. Probá de nuevo.");
                }
            } else {
                System.out.println("Eso no es un numero. Probá de nuevo.");
                teclado.next(); // descarta lo que se escribio mal para no quedar en loop infinito
            }
        }

        return elegido;
    }

    private Personajes buscarPorId(List<Personajes> lista, int id) {
        for (Personajes p : lista) {
            if (p.get_ID() == id) {
                return p;
            }
        }
        return null;
    }
}
