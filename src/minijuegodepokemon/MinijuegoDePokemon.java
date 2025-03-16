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

    public static void main(String[] args) {
        // Variables

        //Creo un objeto con cada pokemon posible a elegir por el jugador
        Pokemon charmander = new Pokemon("Charmander", "fuego", 90, 40);
        Pokemon squirtle = new Pokemon("squirtle", "agua", 100, 25);
        Pokemon bulbasour = new Pokemon("bulbasour", "planta", 95, 30);
        Pokemon snorlax = new Pokemon("Snorlax", "normal", 200, 10);
        try {
            //presentacion del juego
            System.out.println("| ----------------------------- |");
            System.out.println("  Minijuegoo Pokemon vs Pokemon");
            System.out.println("| ----------------------------- |");

            //llama a la funcion elegir pokemon para que el usuario introduzca con que pokemons quiere jugar
            Pokemon pokJugador = elegirPokemon(charmander, squirtle, bulbasour, snorlax);
            System.out.println("Has elegido a " + pokJugador.getNombre());
            Pokemon pokMaquina = elegirPokemon(charmander, squirtle, bulbasour, snorlax);
            System.out.println("Lucharas contra: " + pokMaquina.getNombre());
            System.out.println(" Buena suerte :)");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    //creo una funcion que retorna un objeto en funcion del poquemon que elije el jugador
    private static Pokemon elegirPokemon(Pokemon charmander, Pokemon squirtle, Pokemon bulbasaur, Pokemon snorlax) {
        String pokName = "";
        //while hasta que la entrada del usuaio sea correcta
        while (true) {
            System.out.println("Escribe el nombre del el pokemon que quieres elegir: squirtle, charmander, bulbasour, ....");
            pokName = reader.next();
            pokName = pokName.toLowerCase();
            switch (pokName) {
                case "charmander":         
                    return charmander;

                case "bulbasour":
                    return bulbasaur;

                case "squirtle":
                    return squirtle;

                case "snorlax":
                    return snorlax;

                default:
                    System.out.println("Introduciste un pokemon que no existe, porfavor introduce uno  de los disponibles.");

            }

        }

    }
}
