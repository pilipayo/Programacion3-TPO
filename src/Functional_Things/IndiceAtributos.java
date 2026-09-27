package Functional_Things;

import Things.Personajes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// El diccionario grande que veniamos hablando. Se arma UNA sola vez a
// partir de la lista completa de personajes (la misma para los dos
// jugadores), y despues es de SOLO LECTURA durante toda la partida --
// nadie le agrega ni le saca nada de aca. El descarte real pasa siempre
// sobre la lista propia de cada Jugador (candidatosPropios), nunca sobre
// esto. Ver Jugador.descartarPorAtributo().
public class IndiceAtributos {

    // clave = un valor de atributo tal cual ("barba corta", "rubio",
    // "femenino"...). valor = todos los Personajes de la lista completa
    // que tienen ese valor, sin importar de que categoria salio.
    private Map<String, List<Personajes>> indice = new HashMap<>();

    public IndiceAtributos(List<Personajes> listaCompleta) {
        for (Personajes p : listaCompleta) {
            for (Map.Entry<String, String> atributo : p.get_Atributos().entrySet()) {
                String valor = atributo.getValue();
                indice.computeIfAbsent(valor, k -> new ArrayList<>()).add(p);
            }
            // El genero tambien es una caracteristica que se puede
            // preguntar en el juego ("¿es mujer?"), asi que tambien
            // queda indexado igual que cualquier otro atributo. Avisame
            // si NO queres que el genero sea preguntable y lo saco.
            indice.computeIfAbsent(p.get_Genero(), k -> new ArrayList<>()).add(p);
        }
    }

    // Busqueda O(1): "dame a todos los que tienen tal valor". Si el
    // valor no existe (typo, o nunca salio en esta partida), devuelve
    // lista vacia en vez de null -- asi quien llama no tiene que andar
    // chequeando null antes de usarla.
    public List<Personajes> buscarPorAtributo(String valor) {
        return indice.getOrDefault(valor, new ArrayList<>());
    }
}
