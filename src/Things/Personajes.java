//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Things;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Personajes {
    private String genero;
    private String nombre;
    private String apellido;
    private int edad;
    private int id;
    private Map<String, String> atributos = new LinkedHashMap();
    private boolean elegido = false;

    public Personajes(int id, String nombre, String apellido, int edad, String genero) {
        this.genero = genero;
        this.nombre = nombre;
        this.id = id;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void agregar_Atributo(String categoria, String valor) {
        this.atributos.put(categoria, valor);
    }

    public String get_Atributo(String categoria) {
        return (String)this.atributos.get(categoria);
    }

    public Map<String, String> get_Atributos() {
        return Collections.unmodifiableMap(this.atributos);
    }

    public int get_ID() {
        return this.id;
    }

    public String get_Genero() {
        return this.genero;
    }

    public String get_Nombre() {
        return this.nombre;
    }

    public String get_Apellido() {
        return this.apellido;
    }

    public int get_Edad() {
        return this.edad;
    }

    public boolean get_Elegido() {
        return this.elegido;
    }

    public void set_Elegido() {
        this.elegido = true;
    }

    public void mostrar_Info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Personaje ").append(this.id).append(":\n").append("Nombre:").append(this.nombre).append("\n").append("Apellido:").append(this.apellido).append("\n").append("Edad:").append(this.edad).append("\n").append("Genero:").append(this.genero).append("\n");

        for(Map.Entry<String, String> atributo : this.atributos.entrySet()) {
            sb.append((String)atributo.getKey()).append(":").append((String)atributo.getValue()).append("\n");
        }

        System.out.println(sb.toString());
    }
}