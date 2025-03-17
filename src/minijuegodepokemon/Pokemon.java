package minijuegodepokemon;

/**
 *
 * @author Carlos
 */
public class Pokemon {

    static private String nombre;
    static private String tipo;
    static private int vida;
    //static public int totalPociones = 3;

    public Pokemon(String nombre, String tipo, int vida, int ataque) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    private int ataque;

    //en funcion del ripo del poquemon atacante o del defensor devolvera una cantidad de daño u otra
    public int atacar(String tipoAtacante, String tipoDefensor) {
        switch (tipoAtacante) {
            case "fuego":
                switch (tipoDefensor) {
                    case "fuego":
                        return getAtaque() / 2;

                    case "agua":
                        return getAtaque() / 2;

                    case "planta":
                        return getAtaque() * 2;
                    case "normal":
                        return getAtaque();
                    default:
                        throw new AssertionError();
                }

            case "agua":
                switch (tipoDefensor) {
                    case "fuego":
                        return getAtaque() * 2;

                    case "agua":
                        return getAtaque() / 2;

                    case "planta":
                        return getAtaque() / 2;
                    case "normal":
                        return getAtaque();
                    default:
                        throw new AssertionError();
                }

            case "planta":
                switch (tipoDefensor) {
                    case "fuego":
                        return getAtaque() / 2;

                    case "agua":
                        return getAtaque() * 2;

                    case "planta":
                        return getAtaque() / 2;
                    case "normal":
                        return getAtaque();
                    default:
                        throw new AssertionError();
                }

            case "normal":
                switch (tipoDefensor) {
                    case "fuego":
                        return getAtaque();

                    case "agua":
                        return getAtaque();

                    case "planta":
                        return getAtaque();

                    case "normal":
                        return getAtaque() / 2;

                    default:
                        throw new AssertionError();
                }

            default:
                throw new AssertionError();
        }
    }

    //esta funcion resta el daño del poquemon que recibe el ataque conbinada con la funcion atacar
    public static void recibirDaño(int danno, String atacanteNombre) {
        System.out.println(atacanteNombre + " lanza su ataque a " + nombre);
        System.out.println(nombre + " tiene " + vida);
        vida = vida - danno;
        System.out.print(" y se queda con " + vida);
    }

    //cura a tu pokemon con una pocion 
    public static void usarPocion() {
        vida = vida + 20;
        System.out.println(nombre + " se cura 20 ps con pocion");
    }

}
