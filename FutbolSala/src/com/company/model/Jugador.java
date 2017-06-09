package com.company.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by EBF10 on 19/05/2017.
 */
public class Jugador implements Serializable,Comparable<Jugador>,Comparator<Jugador> {

    private static final long serialVersionUID = -2196807447451158L;

    private String nombre;
    private String apellido;
    private String posicion;
    private int dorsal;
    private String equipo;
    private double altura;
    private double peso;
    private int goles;


    /**
     * ordena por equipos
     */
    public static Comparator<Jugador> ordenarPorEquiYGoles = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador o1, Jugador o2) {

            if (o1.getEquipo().equals(o2.getEquipo())) {

                return o1.getGoles() - o2.getGoles();

            } else {
                return o1.getEquipo().compareTo(o2.getEquipo());
            }
        }
    };


    //contructores

    public Jugador() {
    }

    public Jugador(String nombre) {
        setNombre(nombre);
    }

    public Jugador(String nombre, String apellido, String posicion, int dorsal, String equipo, double altura, double peso, int goles) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setPosicion(posicion);
        this.setDorsal(dorsal);
        this.setEquipo(equipo);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setGoles(goles);
    }

    //accesores

    /**
     * coge el valor nombre
     *
     * @return String
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * introduce el nombre del jugador
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * extrae el apellido del jugador
     *
     * @return String
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * introduce el apellido del jugador
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    /**
     * extrae la posicion del jugador
     *
     * @return String
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * introduce la posion y controlo que sea una posicion correcta
     *
     * @param posicion
     */
    public void setPosicion(String posicion) {

        if (posicion.toLowerCase().equals("portero")) {
            this.posicion = posicion;
        } else if (posicion.toLowerCase().equals("ala")) {
            this.posicion = posicion;
        } else if (posicion.toLowerCase().equals("cierre")) {
            this.posicion = posicion;
        } else if (posicion.toLowerCase().equals("pivot")) {
            this.posicion = posicion;
        } else {
            this.posicion = "no tiene posicion";
        }


    }


    public int getDorsal() {
        return dorsal;
    }

    /**
     * comprueba que dorsal no sea negativo
     * @param dorsal
     */
    public void setDorsal(int dorsal) {

        if (dorsal < 0) {
            this.dorsal = 0;
        } else {
            this.dorsal = dorsal;
        }
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public double getAltura() {
        return altura;
    }

    /**
     * comprueba que no sea negativo
     * @param altura
     */
    public void setAltura(double altura) {


        if (altura < 0) {

            this.altura = 0;

        } else {
            this.altura = altura;
        }
    }

    public double getPeso() {
        return peso;
    }

    /**
     * comprueba que el peso no sea negativo
     * @param peso
     */
    public void setPeso(double peso) {

        if (peso < 0) {

            this.peso = 0;

        } else {
            this.peso = peso;
        }
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {

        if (goles <= 0) {
            this.goles = 0;
        } else {
            this.goles = goles;
        }
    }


    //metodos


    /**
     * se encarga de mostrar por pantalla los valores de los atributos
     *
     * @return String
     */
    @Override
    public String toString() {
        return "El jugador " + nombre + " " + apellido + " juega de " + posicion + " con el dorsal " + dorsal +
                " en el equipo " + equipo +
                " tiene una altura de  " + altura +
                " y un peso de " + peso +
                " ,ha metido " + goles + "\n";
    }


    /**
     * ordena por nombres de forma alfabetica
     *
     * @param o1 Jugador
     * @param o2 Jugador
     * @return ordena los jugadores por noombres
     */
    @Override
    public int compare(Jugador o1, Jugador o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }


    /**
     * ordena por altura
     *
     * @param o tipo Jugador
     * @return un -1 si es menor; 0 si es igual y 1 si es mayor
     */
    @Override
    public int compareTo(Jugador o) {
        return Double.compare(o.getAltura(), getAltura());
    }


    /**
     * se encarga de comparar jugadoes por el nombre
     * @param obj tipo Object y lo transformamos a un tipo Jugador
     * @return si los nombres son iguales devuelve un vrdadero
     */
    @Override
    public boolean equals(Object obj) {

        //se compruba que no sea nulo
        if (obj == null){return false;}

        //comprobamos que sean iguales
        if (obj == this){return true;}

        //comprobaos que sean la misma clase
        if (obj.getClass() != this.getClass()){return false;}


        Jugador j = (Jugador) obj;

        return Objects.equals(j.getNombre().toLowerCase(),this.getNombre().toLowerCase());
    }


}
