package minijuegodepokemon;

import java.util.Scanner;

/**
 * Este es un pequeño mini juego de poquemon donde se hacen pequeños combates de
 * el jugador conttra la maquina y se hacen mas o menos daño en funcion del
 * tipo.
 *
 * @author Carlos
 */
public class MinijuegoDePokemon {

    static Scanner reader = new Scanner(System.in);
    //creo las variables que van a tener los objetos de los pokemons contra los que jugara el jugador
    //las creo como static para usarlas en la funciones del codigo mas adelante.
    static Pokemon pokJugador;
    static Pokemon pokMaquina;

    public static void main(String[] args) {
        // Variables
        String pelear = "";

        try {
            //presentacion del juego
            System.out.println("| ----------------------------- |");
            System.out.println("  Minijuegoo Pokemon vs Pokemon");
            System.out.println("| ----------------------------- |");

            pelear = "y"; //inicializo pelear en y para que el bucle se inicie
            while (pelear.equals("y")) {
                //llama a la funcion elegir pokemon para que el usuario introduzca con que pokemons quiere jugar
                pokJugador = elegirPokemon();
                System.out.println("Has elegido a " + pokJugador.getNombre());
                pokMaquina = elegirPokemon();
                System.out.println("Lucharas contra: " + pokMaquina.getNombre());
                System.out.println(" Buena suerte :)");
                
                //comienza la pelea
                combatir();
                
                // te pregunta si quieres seguir jugado
                System.out.println("Quieres jugar otra vez? y/n");
                
                //guarda en pelear la primera letra en minuscula que introduzca el usuario para cortar o no el juego
                pelear = reader.next().toLowerCase().charAt(0) + "";
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    //creo una funcion que retorna un objeto en funcion del poquemon que elije el jugador
    private static Pokemon elegirPokemon() {
        String pokName = "";
        //while hasta que la entrada del usuaio sea correcta
        while (true) {
            System.out.println("Escribe el nombre del el pokemon que quieres elegir: squirtle, charmander, bulbasour, ....");
            pokName = reader.next();
            pokName = pokName.toLowerCase();

            //en funcion del nombre que escriba el usuario retorna un objeto u otro
            switch (pokName) {
                case "charmander":
                    return new Pokemon("Charmander", "fuego", 90, 40);
                case "squirtle":
                    return new Pokemon("squirtle", "agua", 100, 25);
                case "bulbasour":
                    return new Pokemon("bulbasour", "planta", 95, 30);
                case "snorlax":
                    return new Pokemon("Snorlax", "normal", 200, 10);
                default:
                    System.out.println("Ese pokemon no esta disponible :(");
                    break;
            }

        }

    }

    private static void combatir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
