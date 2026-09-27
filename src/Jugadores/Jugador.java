package Jugadores;

import Things.Personajes;
import Functional_Things.IndiceAtributos;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class Jugador {

    // Se inicializa el Personaje Secreto de cada unio de los jugadores, este no tiene setters directos y es privado
    private Personajes personajeSecreto;
    // Se inicializa el conjunto de cadidatios para cada uno de los jugadores
    private Set<Personajes> candidatosPropios;

    //cada vez que se crea un jugador nuevo,
    // se le arma su propio tablero de candidatos copiando todos los personajes de la lista
    public Jugador(List<Personajes> listaCompleta) {
        this.candidatosPropios = new LinkedHashSet<>(listaCompleta);
    }

    // Se establece que cada jugador debe elegir a su Personaje Secreto de la foirma que sea
    protected abstract Personajes elegirPersonajeSecreto(List<Personajes> personajesDisponibles);

    public void iniciarPersonajeSecreto(List<Personajes> personajesDisponibles) {
        this.personajeSecreto = elegirPersonajeSecreto(personajesDisponibles);
    }

    // Hace un get del personaje secreto
    public Personajes getPersonajeSecreto() {
        return this.personajeSecreto;
    }
    // Hace un set de los personajes que quedan como candidatos
    public Set<Personajes> getCandidatosPropios() {
        return this.candidatosPropios;
    }

    // Responde true o false de si el atributo por el cual se esta preguntando pertenece al personaje secreto
    public boolean tieneAtributo(String categoria, String valor) {
        return this.personajeSecreto.get_Atributo(categoria).equals(valor);
    }

    // Aca define, si te responde true, se queda con los personajes de la lista del diccionario de ese atributo
    // Si devuelve false, descarta los de la lista de ese atributo
    public void descartarPorAtributo(String valor, boolean tieneElAtributo, IndiceAtributos indice) {
        List<Personajes> conEseValor = indice.buscarPorAtributo(valor);
        if (tieneElAtributo) {
            this.candidatosPropios.retainAll(conEseValor);
        } else {
            this.candidatosPropios.removeAll(conEseValor);
        }
    }
}
