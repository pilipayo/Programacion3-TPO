//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Functional_Things;

import Things.Personajes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GeneradorPersonajes {
    ArrayList<Personajes> lista_Personajes = new ArrayList();
    Random num_random = new Random();
    List<String> generos = List.of("femenino", "masculino");
    List<String> nombres_masculinos = List.of("Alejandro", "Andrés", "Agustín", "Adrián", "Alberto", "Alfredo", "Álvaro", "Amadeo", "Aníbal", "Antonio", "Ariel", "Arturo", "Augusto", "Bautista", "Benjamín", "Bruno", "Camilo", "Carlos", "César", "Cristian", "Damián", "Daniel", "Darío", "David", "Diego", "Domingo", "Eduardo", "Elías", "Emanuel", "Emilio", "Enrique", "Ernesto", "Esteban", "Ezequiel", "Facundo", "Fabián", "Federico", "Felipe", "Fernando", "Flavio", "Francisco", "Franco", "Gabriel", "Gastón", "Gerardo", "Germán", "Gonzalo", "Gregorio", "Guillermo", "Gustavo", "Héctor", "Hernán", "Horacio", "Hugo", "Ignacio", "Ismael", "Iván", "Jacobo", "Javier", "Jeremías", "Jerónimo", "Joaquín", "Joel", "Jorge", "José", "Juan", "Julián", "Julio", "Lautaro", "Leandro", "Leonardo", "Lorenzo", "Lucas", "Luciano", "Luis", "Manuel", "Marcelo", "Marcos", "Mariano", "Martín", "Mateo", "Matías", "Mauricio", "Maximiliano", "Miguel", "Nahuel", "Nicolás", "Néstor", "Octavio", "Omar", "Orlando", "Oscar", "Pablo", "Patricio", "Pedro", "Rafael", "Ramiro", "Raúl", "Ricardo", "Roberto", "Rodrigo", "Rogelio", "Rubén", "Salvador", "Samuel", "Santiago", "Sebastián", "Sergio", "Simón", "Teodoro", "Tobías", "Tomás", "Valentín", "Vicente", "Víctor", "Walter", "Wilfredo", "Xavier", "Yago", "Abel", "Adolfo", "Agapito", "Baltasar", "Benicio", "Blas", "Cayetano", "Claudio", "Conrado", "Dante", "Eliseo", "Fausto", "Feliciano", "Humberto", "Iñaki", "Lisandro", "Máximo", "Nazareno", "Renato", "Silvio", "Ulises", "Valeriano", "Evaristo", "Lázaro", "Román", "Silvestre", "Tadeo", "Tristán", "Gaspar");
    List<String> nombres_femeninos = List.of("Abril", "Adriana", "Agustina", "Alba", "Alejandra", "Alicia", "Amanda", "Amelia", "Ana", "Andrea", "Ángela", "Antonella", "Antonia", "Ariana", "Ariadna", "Aurora", "Bárbara", "Beatriz", "Belén", "Bianca", "Brenda", "Camila", "Candela", "Candelaria", "Carolina", "Catalina", "Celeste", "Cecilia", "Clara", "Claudia", "Constanza", "Cristina", "Daniela", "Débora", "Delfina", "Diana", "Dolores", "Elena", "Elisa", "Elizabeth", "Emilia", "Emma", "Erica", "Estela", "Eva", "Fabiana", "Fátima", "Fernanda", "Fiorella", "Florencia", "Francisca", "Gabriela", "Gema", "Genoveva", "Graciela", "Guadalupe", "Helena", "Inés", "Irene", "Isabel", "Josefina", "Juana", "Julia", "Juliana", "Julieta", "Karen", "Karina", "Laura", "Leticia", "Lidia", "Liliana", "Lola", "Lorena", "Lourdes", "Lucía", "Luciana", "Lucrecia", "Luz", "Magdalena", "Maite", "Malena", "Manuela", "Marcela", "Margarita", "Mariana", "Marina", "Marisol", "Marta", "Martina", "Mercedes", "Micaela", "Milagros", "Mónica", "Mora", "Nadia", "Natalia", "Noelia", "Norma", "Olivia", "Ornella", "Pamela", "Patricia", "Paula", "Paz", "Pilar", "Priscila", "Raquel", "Renata", "Rocío", "Romina", "Rosa", "Sabrina", "Salomé", "Sandra", "Sara", "Silvia", "Sofía", "Sol", "Susana", "Tatiana", "Teresa", "Valentina", "Valeria", "Vanesa", "Verónica", "Victoria", "Violeta", "Virginia", "Viviana", "Xiomara", "Yanina", "Yésica", "Zoe", "Aitana", "Alma", "Angélica", "Berenice", "Celina", "Coral", "Estefanía", "Evangelina", "Felisa", "Georgina", "Jazmín", "Leonor", "Lisandra", "Melina", "Penélope", "Rebeca");
    List<String> apellidos = List.of("García", "González", "Rodríguez", "Fernández", "López", "Martínez", "Sánchez", "Pérez", "Gómez", "Martín", "Díaz", "Moreno", "Muñoz", "Álvarez", "Romero", "Alonso", "Gutiérrez", "Navarro", "Torres", "Domínguez", "Vázquez", "Ramos", "Ramírez", "Vázquez", "Serrano", "Blanco", "Suárez", "Molina", "Morales", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marín", "Sanz", "Iglesias", "Núñez", "Medina", "Garrido", "Santos", "Castillo", "Cortés", "Lozano", "Guerrero", "Cano", "Prieto", "Méndez", "Cruz", "Flores", "Cabrera", "Reyes", "Vega", "Pascual", "Campos", "Fuentes", "Carrasco", "Díez", "Caballero", "Nieto", "Vidal", "Durán", "Santiago", "Mora", "Vicente", "Arias", "Carmona", "Crespo", "Román", "Pastor", "Sáez", "Velasco", "Moya", "Soler", "Parra", "Esteban", "Bravo", "Gallardo", "Rojas", "Merino", "Rey", "Pardo", "Mateo", "Valencia", "Montero", "Navarro", "Nieto", "Pérez", "Varela", "Montes", "Ibañez", "Márquez", "Aguilar", "Giménez", "Vera", "Santana", "Quintana", "Sáez", "Lorenzo", "Hidalgo", "Gimeno", "Durán", "Mora", "Vicente", "Benítez", "Mendoza", "Aguirre", "Ponce", "Villar", "Pascual", "Márquez", "Cabrera", "Escobar", "Correa", "Roldán", "Miranda", "Parra", "Maldonado", "Carmona", "Guzmán", "Acosta", "Ferrer", "Vargas", "Soto", "Cáceres", "Pineda", "Pastor", "Bravo", "Montoya", "Moya", "Trujillo", "Valle", "Cordero", "Nieto", "Rivas", "Salas", "Castaño", "Márquez", "Solís", "Zamora", "Benítez", "Peña", "Rosales", "Bustos", "Coronado", "Aparicio", "Calderón", "Palacios", "Espinosa", "Beltrán", "Carvajal", "Figueroa", "Márquez", "Santamaría", "Ocampo", "Escudero", "Montenegro", "Valdés", "Pizarro", "Aranda", "Castañeda", "Bermúdez", "Villanueva", "Zúñiga", "Segovia", "León", "Farias", "Mansilla", "Ferreyra", "Quiroga", "Sosa", "Peralta", "Godoy", "Maidana", "Ledesma", "Ojeda", "Acosta", "Lucero", "Toledo", "Cáceres", "Páez", "Funes", "Bustos", "Vega", "Molina", "Sarmiento", "Arce", "Almada", "Roldán", "Coronel", "Zárate", "Márquez", "Barrionuevo", "Cardozo", "Ferreyra", "Acuña", "Perdomo", "Galarza", "Leguizamón", "Villalba", "Cáceres", "Benítez", "Encina", "Báez", "Cejas", "Bustamante");
    List<String> cabello = List.of("calvo", "entradas pronunciadas", "pelo corto", "pelo largo", "pelo muy largo", "rapado", "rulos", "ondas", "lacio", "flequillo", "despeinado");
    List<String> estadoCivil = List.of("soltero", "en pareja", "casado", "divorciado", "viudo");
    List<String> mascotas = List.of("ninguna", "perro", "gato", "pájaro", "pez", "conejo", "hámster", "tortuga");
    List<String> transporte = List.of("camina", "bicicleta", "motocicleta", "auto", "camioneta", "colectivo", "tren", "subte", "taxi", "remís");
    List<String> musica = List.of("rock", "pop", "rap", "jazz", "electrónica", "música clásica", "metal", "folklore", "tango", "cumbia", "reguetón");
    List<String> hobbies = List.of("leer", "cocinar", "jugar videojuegos", "ir al gimnasio", "correr", "andar en bicicleta", "nadar", "jugar fútbol", "jugar tenis", "escuchar música", "tocar un instrumento", "dibujar", "pintar", "fotografía", "viajar", "acampar", "hacer senderismo", "programar", "ver películas");
    List<String> profesiones = List.of("ingeniero", "programador", "médico", "abogado", "contador", "arquitecto", "profesor", "periodista", "fotógrafo", "diseñador", "electricista", "mecánico", "carpintero", "plomero", "policía", "militar", "bombero", "chef", "panadero", "agricultor", "veterinario", "piloto", "conductor", "empresario", "vendedor", "investigador", "estudiante", "artista", "músico", "actor", "deportista", "arquitecto", "electricista", "técnico", "periodista", "desempleado");
    List<String> accesorios = List.of("ninguno", "anteojos", "anteojos de sol", "reloj", "pulsera", "collar", "anillo", "aros", "piercing en la nariz", "piercing en la ceja", "piercing en la oreja", "gorra", "sombrero", "bufanda", "corbata");
    List<String> altura = List.of("muy bajo", "bajo", "altura promedio", "alto", "muy alto");
    List<String> velloFacial = List.of("sin barba ni bigote", "barba corta", "barba larga", "bigote fino", "bigote grueso", "bigote con barba", "patillas largas");
    List<String> colorOjos = List.of("marrones", "marrón claro", "negros", "verdes", "verde claro", "azules", "azul claro", "grises");
    Map<String, List<String>> atributosDisponibles = new HashMap();
    Map<String, List<String>> nombresPorGenero = new HashMap();

    public GeneradorPersonajes() {
        this.nombresPorGenero.put("femenino", this.nombres_femeninos);
        this.nombresPorGenero.put("masculino", this.nombres_masculinos);
        this.atributosDisponibles.put("cabello", this.cabello);
        this.atributosDisponibles.put("mascotas", this.mascotas);
        this.atributosDisponibles.put("estadoCivil", this.estadoCivil);
        this.atributosDisponibles.put("transporte", this.transporte);
        this.atributosDisponibles.put("musica", this.musica);
        this.atributosDisponibles.put("hobbies", this.hobbies);
        this.atributosDisponibles.put("profesiones", this.profesiones);
        this.atributosDisponibles.put("accesorios", this.accesorios);
        this.atributosDisponibles.put("altura", this.altura);
        this.atributosDisponibles.put("velloFacial", this.velloFacial);
        this.atributosDisponibles.put("colorOjos", this.colorOjos);
    }

    public ArrayList<Personajes> crear_Lista(int cant_personajes) {
        for(int i = 0; i < cant_personajes; ++i) {
            String genero = (String)this.generos.get(this.num_random.nextInt(this.generos.size()));
            List<String> nombresPosibles = (List)this.nombresPorGenero.get(genero);
            String nombre = (String)nombresPosibles.get(this.num_random.nextInt(nombresPosibles.size()));
            String apellido = (String)this.apellidos.get(this.num_random.nextInt(this.apellidos.size()));
            int edad = this.num_random.nextInt(100);
            Personajes personaje = new Personajes(i, nombre, apellido, edad, genero);
            this.lista_Personajes.add(personaje);

            for(Map.Entry<String, List<String>> categoriaConValores : this.atributosDisponibles.entrySet()) {
                String categoria = (String)categoriaConValores.getKey();
                List<String> valoresPosibles = (List)categoriaConValores.getValue();
                String valorElegido = (String)valoresPosibles.get(this.num_random.nextInt(valoresPosibles.size()));
                personaje.agregar_Atributo(categoria, valorElegido);
            }
        }

        return this.lista_Personajes;
    }
}
