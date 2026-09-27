import Functional_Things.GeneradorPersonajes;
import Functional_Things.IndiceAtributos;
import Jugadores.JugadorHumano;
import Jugadores.JugadorMaquina;
import Things.Personajes;
import java.util.ArrayList;
import java.util.Scanner;
Scanner teclado = new Scanner(System.in);
String otraVez;

void main() {
    IO.println("=== Adivina Quien ===");
    IO.println();
 do{
    // Generar la lista completa de personajes -- la MISMA lista se le pasa a los dos jugadores
    GeneradorPersonajes generador = new GeneradorPersonajes();
    ArrayList<Personajes> listaCompleta = generador.crear_Lista(10);

    IO.println("Personajes generados (" + listaCompleta.size() + "):");
    for (Personajes p : listaCompleta) {
        p.mostrar_Info();
        IO.println("---");
    }

    // Crear los dos jugadores con la misma lista completa.
    JugadorHumano jugadorHumano = new JugadorHumano(listaCompleta);
    JugadorMaquina jugadorMaquina = new JugadorMaquina(listaCompleta);

    // Eleccion Random del Personaje de la Maquina. [DEBUG] = Deciciones de la maquina
    IO.println("[DEBUG] La maquina esta eligiendo su personaje secreto...");
    jugadorMaquina.iniciarPersonajeSecreto(listaCompleta);
    Personajes secretoMaquina = jugadorMaquina.getPersonajeSecreto();
   // IO.println("[DEBUG] La maquina eligio -> id=" + secretoMaquina.get_ID()
    //        + " " + secretoMaquina.get_Nombre() + " " + secretoMaquina.get_Apellido());
    IO.println();
    // ===== Adivinar al ELEGIDO =====

    IO.println();

    IO.println("¡Hola! Ahora intentá adivinar quién es el ELEGIDO de la máquina.");

    int intentos = 3;

    boolean acerto = false;

    boolean comodinUsado = false;



    while (intentos > 0 && !acerto) {

        IO.println("Intentos restantes: " + intentos + " | Ingresá un id, o -1 para usar el comodín:");

        int id = teclado.nextInt();



        // -1 = comodin (no gasta intento)

        if (id == -1) {

            if (comodinUsado) {

                IO.println("Ya usaste el comodín.");

            } else {

                jugadorMaquina.comodin(listaCompleta);

                comodinUsado = true;

            }

            continue;

        }



        // Busca el personaje con ese id

        Personajes intento = null;

        for (Personajes p : listaCompleta) {

            if (p.get_ID() == id) intento = p;

        }



        if (intento == null) {

            IO.println("Ese id no existe.");

        } else if (intento.get_Elegido()) {

            IO.println("¡Acertaste!");

            intento.mostrar_Info();

            acerto = true;

        } else {

            IO.println(intento.get_Nombre() + ": no es el elegido");

            intentos--;

        }

    }



    // Si perdio, la maquina lo resuelve

    if (!acerto) {

        IO.println("Perdiste. ¿Querés que la máquina lo resuelva? 1 = lineal, 2 = divide y conquista, 0 = no");

        int opcion = teclado.nextInt();

        Personajes resultado = null;

        if (opcion == 1) resultado = jugadorMaquina.resolverLineal(listaCompleta);

        else if (opcion == 2) resultado = jugadorMaquina.resolverAgrupacion(listaCompleta);

        if (resultado != null) {

            IO.println("El elegido era:");

            resultado.mostrar_Info();

        }

    }
    // Eleccion de Personaje secreto del Jugador Humano
    IO.println("Ahora elegis vos tu personaje secreto:");
    jugadorHumano.iniciarPersonajeSecreto(listaCompleta);
    Personajes secretoHumano = jugadorHumano.getPersonajeSecreto();
    IO.println("[DEBUG] Elegiste -> id=" + secretoHumano.get_ID()
            + " " + secretoHumano.get_Nombre() + " " + secretoHumano.get_Apellido());
    IO.println();

    // Printea el largo del conjunto de cadidatos de cada uno de los jugadores
    IO.println("[DEBUG] Candidatos iniciales jugador humano: " + jugadorHumano.getCandidatosPropios().size());
    IO.println("[DEBUG] Candidatos iniciales maquina: " + jugadorMaquina.getCandidatosPropios().size());
    IO.println();



    // Prueba manual y unica. Categoria fija "velloFacial".
    IndiceAtributos indice = new IndiceAtributos(listaCompleta);

    String categoriaPrueba = "velloFacial";

    IO.println("Ingresa el valor a preguntar para " + categoriaPrueba
            + " (ej: barba corta, barba larga, sin barba ni bigote...):");
    String valorPrueba = teclado.nextLine().trim();

    boolean respuesta = jugadorMaquina.tieneAtributo(categoriaPrueba, valorPrueba);
    IO.println("[DEBUG] Respuesta: " + (respuesta ? "SI" : "NO"));
    IO.println();

    jugadorHumano.descartarPorAtributo(valorPrueba, respuesta, indice);

    IO.println("Candidatos que quedan (" + jugadorHumano.getCandidatosPropios().size() + "):");
    for (Personajes p : jugadorHumano.getCandidatosPropios()) {
        IO.println("  id=" + p.get_ID() + " " + p.get_Nombre() + " " + p.get_Apellido()
                + " -- " + categoriaPrueba + "=" + p.get_Atributo(categoriaPrueba));
    }
    // ===== Turno de la maquina: 3 preguntas y decide =====
    IO.println();
    IO.println("Ahora juega la máquina: va a hacer 3 preguntas sobre tu personaje.");
    for (int i = 1; i <= 3; i++) {
        String[] pregunta = jugadorMaquina.elegirPregunta();
        if (pregunta == null) break; // ya le queda uno solo, no necesita preguntar mas

        boolean resp = jugadorHumano.tieneAtributo(pregunta[0], pregunta[1]);
        IO.println("Pregunta " + i + ": ¿tu personaje tiene " + pregunta[0] + " = " + pregunta[1]
                + "? -> " + (resp ? "SI" : "NO"));

        jugadorMaquina.descartarPorAtributo(pregunta[1], resp, indice);
        IO.println("  Le quedan " + jugadorMaquina.getCandidatosPropios().size() + " candidatos.");

    }

    Personajes adivinado = jugadorMaquina.adivinar();
    IO.println("La máquina dice que tu personaje es: id=" + adivinado.get_ID()
            + " " + adivinado.get_Nombre() + " " + adivinado.get_Apellido());
    if (adivinado == secretoHumano) {
        IO.println("¡La máquina acertó!");
    } else {
        IO.println("La máquina se equivocó.");
    }
    IO.println();
    IO.println("¿Volvemos a jugar? S/N");
    otraVez = teclado.nextLine().trim();
    } while (otraVez.equalsIgnoreCase("S"));
    IO.println("¡Gracias por jugar!");

}
