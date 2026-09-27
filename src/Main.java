import Functional_Things.GeneradorPersonajes;
import Functional_Things.IndiceAtributos;
import Jugadores.JugadorHumano;
import Jugadores.JugadorMaquina;
import Things.Personajes;
import java.util.ArrayList;
import java.util.Scanner;

void main() {
    IO.println("=== Adivina Quien ===");
    IO.println();

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
    IO.println("[DEBUG] La maquina eligio -> id=" + secretoMaquina.get_ID()
            + " " + secretoMaquina.get_Nombre() + " " + secretoMaquina.get_Apellido());
    IO.println();

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
    Scanner teclado = new Scanner(System.in);

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
}
