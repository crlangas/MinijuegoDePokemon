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

    public static void main(String[] args) {
        // Variables
        String pelear = "";
        Pokemon pokJugador;
        Pokemon pokMaquina;
        
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
                combatir(pokJugador, pokMaquina);

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

    private static void combatir(Pokemon pokJugador, Pokemon pokMaquina) {
        int pocionesUsadas = 0;
        String accionPlayer = "";
        int esquive = 0;
        String tipoJugador = pokJugador.getTipo();
        String tipomaquina = pokMaquina.getTipo();
        String nombrePokJugador = pokJugador.getNombre();
        String nombrePokEnemigo = pokMaquina.getNombre();

        //bucle que sigue hasta que un pokemon muera
        while (pokJugador.getVida() > 0 && pokMaquina.getVida() > 0) {

            //bucle que pide una entrada al usuario y termina cuando lo hace bien
            while (!accionPlayer.equals("1") && !accionPlayer.equals("2")) {
                System.out.println("Que quieres hacer 1: atacar  o 2 curar con pocion (te quedan: " + (3 - pocionesUsadas) + ")");
                accionPlayer = reader.next().charAt(0) + ""; // (solo coje el primer caracter que escriba el usuario)
                if (!accionPlayer.equals("1") && !accionPlayer.equals("2")) {
                    //mensaje motivador si el usuario se quivoca
                    System.out.println("venga que tu puedes poner 1 o 2 eres mejor que esto :)");
                } else {
                    break;
                }
            }

            //si el jugador ataca
            if (accionPlayer.equals("1")) {
                // hay una pequeña probabilidad de que el poquemon enemigo esquive tu ataque eso es lo que hace 
                // esta condicion hay 1 entre 5 que se ejecute
                esquive = (int) Math.floor(Math.random() * 5);
                if (esquive != 0) {
                    pokMaquina.recibirDanno(pokJugador.atacar(tipoJugador, tipomaquina), nombrePokJugador);

                } else {
                    System.out.println("vaya " + pokMaquina.getNombre() + " esquivo tu ataque");
                }
                //el jugador elije usar una de las 3 pociones.    
            } else if (accionPlayer.equals("2")) {
                pokJugador.usarPocion();
            }

            accionPlayer = "end of player play";
            System.out.println("");
            System.out.println(pokMaquina.getNombre() + " se prepara para atacar...");
            try {
                Thread.sleep(1000); // Pausa por 1 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // inicia el turno de la maquina: (en funcion de un random realiza una accion aleatoria como usar una pocion)
            esquive = (int) Math.floor(Math.random() * 7);
            if (esquive != 2) {
                pokJugador.recibirDanno(pokJugador.atacar(tipomaquina, tipoJugador), nombrePokEnemigo);
                
            } else if (esquive != 0) {
                pokMaquina.usarPocion();

            } else {
                System.out.println("vaya " + pokJugador.getNombre() + " enemigo esquivo el ataque enemigo");
            }

        }

        if (pokJugador.getVida() > 0) {
            System.out.println("Felicidades ganaste");
        } else {
            System.out.println("Vaya perdiste contra " + pokJugador.getNombre() + "ams suerte la proxima");
        }

    }
}
