package TONLINE;
public class Main {

    public static void main(String[] args) {
        //Variables:        
        Apuesta misApuestas;
        Partido p = new Partido();
        int mi_dinero = 1000;

        //Establezco el dinero total de la apuestas
        misApuestas = new Apuesta(mi_dinero);

        //SE REALIZA UNA APUESTA Y SE INTENTA COBRAR LA APUESTA
        //-Apuesto...
        try {
            System.out.println("1.Realizo la apuesta");
            misApuestas.apostar(50, 3, 4);
        } catch (Exception e) {
            System.out.println("\t" + e);
        }
        //-Resultado partido...        
        try {
            System.out.println("2.Se introducen los resultados del partido");
            p.introducir_resultado(3, 4);
            if (p.getFinalizado()) {
                System.out.println("\tEl partido finaliza...");
            } else {
                System.out.println("\tEl partido no ha finalizado... ");
            }
        } catch (Exception e) {
            System.out.println("\t" + e);
        }
        //-Se intenta cobrar la apuesta...
        try {
            System.out.println("3.Intento cobrar la apuesta según el resultado del partido");
            misApuestas.cobrar_apuesta(p);

        } catch (Exception e) {
            System.out.println("\t" + e);
        }

        //Muestro resultado:
        mi_dinero = misApuestas.get_dinero_total();
        System.out.println("4.El dinero que tengo tras la apuesta es: " + mi_dinero);

    }

}
