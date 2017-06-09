package com.company.model;

import java.io.*;
import java.util.*;

/**
 * Created by EBF10 on 19/05/2017.
 */
public class ListaJugador {

    private ArrayList<Jugador> jugadores;


    // contructor


    public ListaJugador() {
        jugadores = new ArrayList<>();
    }


    //metodos

    /**
     * introduce objetos jugadores dentro del ArrayList
     */
    public void incluirJugadores() {


        try {
            jugadores.add( new Jugador("Kike","Bned","pivot",8,"pozo murcia",1.88,80.2,20));
            jugadores.add( new Jugador("Raul","Campos","pivot",10,"pozo murcia",1.88,69.23,5));
            jugadores.add( new Jugador("Bebe"," ","cierre",4,"pozo murcia",1.73,60.2,10));
            jugadores.add( new Jugador("Rafa","Moya","portero",13,"pozo murcia",1.91,750.2,0));

            guardarFichero();
        }catch (NullPointerException e){
            System.out.println("un jugadoe es nulo");
            e.printStackTrace();
        }

    }

    /**
     * Se encarga de mostrar cada jugador del array
     */
    public void mostrarLista() {

        int i = 1;
        for (Jugador jugador : jugadores) {

            System.out.println( i + "-" + jugador.toString());
            i++;

        }

    }

    /**
     * se usa para introducir un jugador a mano pedidido por consola, con todos los sus atributos
     */
    public Jugador nuevoJugador(){

        Scanner scanner = new Scanner(System.in);

        Jugador nuevo = new Jugador();

        try{
            System.out.println("Introduzca el nombre");
            do {
                nuevo.setNombre(scanner.nextLine().replaceAll("\\s+", " "));

            }while (nuevo.getNombre().equals(""));


            System.out.println("Introduzca el apellido");
            do {
                nuevo.setApellido(scanner.nextLine().replaceAll("\\s+", " "));

            }while (nuevo.getApellido().equals(""));



            System.out.println("Introduzca la posicion, debera ser ala,pivot,cierre o portero");
            do {
                nuevo.setPosicion(scanner.nextLine().replaceAll("\\s+", " "));

            }while (nuevo.getPosicion().equals(""));



            System.out.println("Introduzca el dorsal");

            do {
                nuevo.setDorsal(scanner.nextInt());

            }while (nuevo.getDorsal() < 0);


            System.out.println("Introduzca el equipo");
            do {
                nuevo.setEquipo(scanner.nextLine().replaceAll("\\s+", " "));

            }while (nuevo.getEquipo().equals(""));


            System.out.println("Introduzca la altura no puede medir mas de 2,30");
            do {

                nuevo.setAltura(scanner.nextDouble());


            }while (nuevo.getAltura() > 0 && nuevo.getAltura() > 2.30);



            System.out.println("Introduzca el peso, no puede pesar mass de 220 ");
            do {

                nuevo.setPeso(scanner.nextDouble());


            }while (nuevo.getPeso() > 0 && nuevo.getPeso() > 220);


            System.out.println("Introduzca los goles");
            do {

                nuevo.setGoles(scanner.nextInt());
            }while (nuevo.getGoles() < 0 );



            return nuevo;
        }catch ( InputMismatchException e){
            System.out.println("eso no es un numero");
        }
        return  null;
    }



    /**
     * Se encarga de añadir un nuevo jugador en el array llamando al metodo que estta en Jugador
     * si el valor es null volvera ha pedir el metodo
     */
    public void incluirNuevoJugador(){

            try {
                jugadores.add(nuevoJugador());
            }catch (NullPointerException e){
                System.out.println("valor nulo");
                incluirNuevoJugador();
            }


            guardarFichero();

    }


    /**
     * elimina un jugador del array usando el valor devuelto en el metodo buscar(), si el jugador no existe vuelve a pedir el metodo
     */
    public void eliminarJugador(){


        mostrarLista();

        try {
            System.out.println("jugador ha borrar, introduzca su nombre");
            jugadores.remove(buscar());
        }catch (ArrayIndexOutOfBoundsException e){
            eliminarJugador();
        }


        guardarFichero();
    }

    /**
     * edita al jugador buscado mediate el metodo buscar() para saber donde esta y con el metodo nuevoJugador() lo edito entero
     * si el jugador no existe o el jugador esta mal editado volvera a iniciar el metodo
     */
    public void editarJugador(){

        try {
            System.out.println("jugador ha editar");

            jugadores.set(buscar(),nuevoJugador());

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Jugadoe no existe y no se puede encontrar");
            editarJugador();
        }

        guardarFichero();

    }

    /**
     * ordena por la altura usando la interfaz Comparator
     */
    public void ordenarAltura(){



            Collections.sort(jugadores);

            mostrarLista();
            guardarFichero();


    }

    /**
     * ordena por el nombre de forma alfabetica usando la interfaz el comparable
     */
    public void ordenarNombre(){



        Collections.sort(jugadores, new Jugador());

        mostrarLista();
        guardarFichero();


    }

    /**
     * ordena por 2 parametros usado el comparator de forma estatico primero ordena por equipo y luego por goles
     *
     */
    public void ordenar2Parametros(){
        Collections.sort(jugadores,Jugador.ordenarPorEquiYGoles);

        mostrarLista();
        guardarFichero();
    }

    /**
     * se encarga de guardar los datos en un fichero
     */
    public void guardarFichero(){

        try {
            ObjectOutputStream guardar = new ObjectOutputStream( new FileOutputStream("Datos/jugadores.dat"));
            guardar.writeObject( jugadores );
            guardar.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * se encarga de cargar los valores del archivo
     */
    public void cargarFichero(){

        try {
            ObjectInputStream cargar = new ObjectInputStream( new FileInputStream( "Datos/jugadores.dat" ));
            jugadores =  (ArrayList<Jugador>) cargar.readObject();
            cargar.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (FileNotFoundException e){
            System.out.println("No hay valorees en el fichero");
            System.out.println("añada jugadores o cree uno");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * se ecarga de buscar un jugador introduciendo de forma correct el nombre
     * si no nos lo volvera ha pedir hasta que lo introduzcamos bien
     */
    public void buscarJugadorNombre(){

        try{
            System.out.println(jugadores.get(buscar()));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("El Jugador no existe, vuelva ha intentarlo");
            buscarJugadorNombre();
        }

    }



    // helper
    /**
     * nos da el tamaño del array, para que os mueste solo algunas opciones del gestor de tareas
     * @return un entero con el tamaño del array
     */
    public int tamonoArray(){

        return jugadores.size();

    }


    /**
     * Busca un  jugador por nombre por nombre,nos va ha dar un entero con la posicionde donde se encuentra e l nombre
     * , compruebo que exista y lo captura si no existe se vuelve a lanzar el metodo
     * @return un int Con la posiscion
     */
    private int buscar() {


        Scanner scanner = new Scanner(System.in);
        Jugador bus = new Jugador("");



        try {
            System.out.println("Nombre de jugador ha buscar");
            bus.setNombre(scanner.nextLine().replaceAll("\\s+", " "));
            return  jugadores.indexOf(bus);


        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("introduzca nombre correcto");
            buscarJugadorNombre();
        }

        return -1;
    }




}

