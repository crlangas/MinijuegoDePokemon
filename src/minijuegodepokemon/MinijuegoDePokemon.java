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

        try {
            //presentacion del juego
            System.out.println("| ----------------------------- |");
            System.out.println("  Minijuegoo Pokemon vs Pokemon");
            System.out.println("| ----------------------------- |");

            //llama a la funcion elegir pokemon para que el usuario introduzca con que pokemons quiere jugar
            Pokemon pokJugador = elegirPokemon();
            System.out.println("Has elegido a " + pokJugador.getNombre());
            Pokemon pokMaquina = elegirPokemon();
            System.out.println("Lucharas contra: " + pokMaquina.getNombre());
            System.out.println(" Buena suerte :)");
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
                    break;
            }
 

        }

    }
}
