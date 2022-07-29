package UD4;

/**
 *
 * @author Pablo Fernández Rodríguez
 * @version 2.0
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //Variables:        
        Moto miMoto;
        int stockActual = 1000;
        int cantidadAComprar;

        //Establezco la cantidad del stock
        miMoto = new Moto("Ducati", "rojo", stockActual);

        comprar_motos(miMoto, 100);

        //SE VISUALIZA RESULTADO       
        //-Se muestra resultado ...          
        System.out.println("\n- El stock actual de motos es: " + miMoto.getStock());
    }

    /**
     *
     * @param miMoto
     * @param cantidad
     */
    public static void comprar_motos(Moto miMoto, int cantidad) {
        //SE REALIZA COMPRA DE MOTOS
        //-Proceso de compra de motos...
        try {
            System.out.println("- Compra de motos:");
            miMoto.comprar(cantidad);
            int cantidadAComprar = 100;
            System.out.println("\tSe han comprado: " + cantidadAComprar + " motos");
        } catch (Exception e) {
            System.out.println("\t" + e);
        }
    }
}
