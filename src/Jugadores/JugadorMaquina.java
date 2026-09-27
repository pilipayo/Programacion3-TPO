package Jugadores;

import Things.Personajes;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JugadorMaquina extends Jugador {

    private Random num_random = new Random();

    public JugadorMaquina(List<Personajes> listaCompleta) {
        super(listaCompleta);
    }

    // Jugador maquina, sortea un personaje de la lista completa.
    @Override
    protected Personajes elegirPersonajeSecreto(List<Personajes> personajesDisponibles) {
        Personajes elegido = personajesDisponibles.get(num_random.nextInt(personajesDisponibles.size()));

        elegido.set_Elegido(); // lo marca como ELEGIDO (estado = SI)

        return elegido;

    }

    // Divide la lista en grupos de 3; lo que sobra se reparte en los ultimos (quedan de 3 o 4)

    private List<List<Personajes>> armarGrupos(List<Personajes> lista) {

        List<List<Personajes>> grupos = new ArrayList<>();

        int cantGrupos = lista.size() / 3;

        int resto = lista.size() % 3;

        int inicio = 0;

        for (int g = 0; g < cantGrupos; g++) {

            int tam = 3 + (g >= cantGrupos - resto ? 1 : 0);

            grupos.add(lista.subList(inicio, inicio + tam));

            inicio += tam;

        }

        return grupos;

    }



    // Responde si el elegido esta dentro de este grupo

    private boolean grupoTieneElegido(List<Personajes> grupo) {

        for (Personajes p : grupo) {

            if (p.get_Elegido()) return true;

        }

        return false;

    }



    // Texto con el primer y el ultimo id del grupo, ej: "0 y el 3"

    private String rango(List<Personajes> grupo) {

        return grupo.get(0).get_ID() + " y el " + grupo.get(grupo.size() - 1).get_ID();

    }



    // COMODIN: dice entre que ids esta el elegido

    public void comodin(List<Personajes> lista) {

        for (List<Personajes> grupo : armarGrupos(lista)) {

            if (grupoTieneElegido(grupo)) {

                System.out.println("El personaje está entre el " + rango(grupo));

            }

        }

    }
    // Busqueda lineal: revisa uno por uno hasta encontrarlo

    public Personajes resolverLineal(List<Personajes> lista) {

        for (Personajes p : lista) {

            System.out.println("Probando id=" + p.get_ID() + " " + p.get_Nombre() + "...");

            if (p.get_Elegido()) return p;

        }

        return null;

    }

    // Divide y conquista (recursivo): divide en grupos, se queda con el que tiene al elegido, descarta los otros y repite sobre ese grupo

    public Personajes resolverAgrupacion(List<Personajes> lista) {

        // Caso base: si quedan 4 o menos, los reviso uno por uno

        if (lista.size() <= 4) {

            return resolverLineal(lista);

        }

        // Dividir: armo los grupos

        for (List<Personajes> grupo : armarGrupos(lista)) {

            if (grupoTieneElegido(grupo)) {

                System.out.println("Está entre el " + rango(grupo) + ". Me acuerdo de este grupo.");

                // Conquistar: repito lo mismo solo sobre este grupo

                return resolverAgrupacion(grupo);

            } else {

                System.out.println("Descarto el grupo entre el " + rango(grupo) + ".");

            }

        }

        return null;


    }

    // GREEDY: elige la pregunta que parte a los candidatos lo mas cerca de la mitad,
    // asi con cualquier respuesta descarta la mayor cantidad posible
    public String[] elegirPregunta() {
        String[] mejor = null;
        int mejorDiferencia = Integer.MAX_VALUE;
        int total = getCandidatosPropios().size();

        for (Personajes p : getCandidatosPropios()) {
            for (Map.Entry<String, String> atributo : p.get_Atributos().entrySet()) {
                String categoria = atributo.getKey();
                String valor = atributo.getValue();

                // Cuenta cuantos candidatos tienen ese valor
                int cuantos = 0;
                for (Personajes q : getCandidatosPropios()) {
                    if (valor.equals(q.get_Atributo(categoria))) cuantos++;
                }
                if (cuantos == total) continue; // no sirve: todos lo tienen

                // Cuanto mas cerca de la mitad, mejor pregunta
                int diferencia = Math.abs(total - 2 * cuantos);
                if (diferencia < mejorDiferencia) {
                    mejorDiferencia = diferencia;
                    mejor = new String[] {categoria, valor};
                }
            }
        }
        return mejor; // null si ya le queda un solo candidato
    }

    // Decide: elige uno al azar entre los candidatos que le quedan
    public Personajes adivinar() {
        List<Personajes> quedan = new ArrayList<>(getCandidatosPropios());
        return quedan.get(num_random.nextInt(quedan.size()));
    }
}

