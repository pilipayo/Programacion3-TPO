package Jugadores;

import Things.Personajes;
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
        return personajesDisponibles.get(num_random.nextInt(personajesDisponibles.size()));
    }
}
