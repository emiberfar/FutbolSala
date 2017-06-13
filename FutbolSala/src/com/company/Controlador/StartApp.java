package com.company.Controlador;

import com.company.model.ListaJugador;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by EBF10 on 19/05/2017.
 */
public class StartApp {

    private ListaJugador listaJugador;

    // contructor


    public StartApp() {
        this.listaJugador = new ListaJugador();
    }


    //metodos

    /**
     * imprime por pantalla un alista de opciones
     * @return int para poder elegir la opcion
     */
    private int mostrarTareas(){
        Scanner scanner = new Scanner(System.in);



        System.out.println("**************************************");
        System.out.println("*  1 - cargar lista de jugdrores     *");
        System.out.println("*  2 - mostrar jugadores             *");
        System.out.println("*  3 - nuevo jugador                 *");
            if (listaJugador.tamonoArray() > 0) {
                System.out.println("*  4 - ordenar por altura            *");
                System.out.println("*  5 - ordenar por nombre            *");
                System.out.println("*  6 - ordenar por 2 parametros      *");
                System.out.println("*  7 - elimina jugador               *");
                System.out.println("*  8 - actualizar fichero            *");
                System.out.println("*  9 - buscar por nombre             *");
                System.out.println("*  10 - editar jugador               *");
            }
        System.out.println("*  0 - Salir                         *");
        System.out.println("**************************************");
        System.out.println("Opcion:");
        try {


            return scanner.nextInt();

        }catch (InputMismatchException e){
           e.printStackTrace();
           inicioApp();
       }
        return 0;
    }


    /**
     * muestra la interfaz para pedir que es lo que quieres hacer.
     * si no tiene valores solo nos permitira hacer las tres primera opciones,
     * si tiene mas de una nos muestra todas las opciones
     */
    public void inicioApp() {

        int opcion;


        try {
            listaJugador.cargarFichero();
            while ((opcion = mostrarTareas()) != 0) {

                if (listaJugador.tamonoArray() == 0) {
                    switch (opcion) {
                        case 1:
                            listaJugador.incluirJugadores();
                            break;
                        case 2:
                            listaJugador.mostrarLista();
                            break;

                        case 3:

                            listaJugador.incluirNuevoJugador();

                            break;
                    }
                } else {

                    switch (opcion) {
                        case 1:
                            listaJugador.incluirJugadores();
                            break;
                        case 2:
                            listaJugador.mostrarLista();
                            break;
                        case 3:
                            listaJugador.incluirNuevoJugador();
                            break;
                        case 4:
                            listaJugador.ordenarAltura();
                            break;
                        case 5:
                            listaJugador.ordenarNombre();
                            break;
                        case 6:
                            listaJugador.ordenar2Parametros();
                            break;
                        case 7:
                            listaJugador.eliminarJugador();
                            break;
                        case 8:
                            listaJugador.guardarFichero();
                            break;
                        case 9:
                            listaJugador.buscarJugadorNombre();
                            break;
                        case 10:
                            listaJugador.editarJugador();
                            break;
                        default:
                    }
                }

            }

        } catch (NullPointerException e) {
            System.out.println("introduzca los valores correctos");
            inicioApp();
        }
    }

}



