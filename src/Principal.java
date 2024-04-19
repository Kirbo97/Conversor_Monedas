import java.text.DateFormat;  //importo la libreria que admite los cambios de formato de fecha y hora
import java.text.SimpleDateFormat; //importo la libreria que permite editar el formato de la fecha y hora
import java.util.Date; //importo la libreria que captura la fecha y hora local
import java.io.FileWriter;   //importo la libreria de creacion de archivos
import java.io.IOException; //libreria para utilisar las funciones del try y catch
import java.util.Scanner;  //importo los servicios para agregar por teclado datos

public class Principal {
    public static void main(String[] args) throws IOException {

        int opcion= 0;
        int opc1 = 0,opc2 = 0;
        double cantidad;
        String [] cadenas = { "USD","ARS","BRL","AUD","AWG","BBD","COP","INR","HKD","MXN","LRD","RUB","SEK","BMD","BND"};
        String mensaje;
        String menu1 = """
                    \n********************************************
* Sea bienvenido/a al conversor de Monedas *
********************************************
* 1) Convertir.                            *
* 2) Salir.                                *
********************************************
""";


        String menu2 = """
                    \n****************************************************************************************************************************
*                                                    Monedas soportadas                                                    *
****************************************************************************************************************************
*   1) Dólar (USD).                    *   2) Peso argentino (ARS).                *   3) Real Brasileño (BRL).            *
*   4) Dólar australiano (AUD).        *   5) Florín de Aruba (AWG).               *   6) Dólar de Barbados (BBD).         *
*   7) Peso colombiano (COP).          *   8) Rupia indonesia (INR).               *   9) Dólar de Hong Kong (HKD).        *
*  10) Peso mexicano (MXN).            *  11) Dólar liberiano (LRD).               *  12) Rublo ruso (RUB).                *
*  13) Corona sueca (SEK).             *  14) Dólar de Bermudas (BMD).             *  15) Dólar de Brunéi (BND).           *
****************************************************************************************************************************
""";

        Scanner teclado = new Scanner(System.in);
        FileWriter escritura = new FileWriter("convercion.json"); // Creo un objeto de la funcion para crear archivos con el nombre


        while(opcion != 2){
            System.out.print(menu1);
            System.out.print("Escoja una opcion: ");
            opcion = teclado.nextInt();

            if(opcion==1){
                System.out.print(menu2);

                while(opc1 != 15){
                    System.out.print("Escoja que valor monetario base: ");
                    opc1 = teclado.nextInt();
                    if (opc1 > 15){ System.out.println("\nOpción inválida"); } else { break; }
                }

                System.out.print("Ingrese una cantidad: ");
                cantidad= teclado.nextDouble();

                while(opc2 != 15){
                    System.out.print("Escoja que valor monetario que desea obtener: ");
                    opc2 = teclado.nextInt();
                    if (opc2 > 15){ System.out.println("\nOpción inválida"); } else { break; }
                }

                String codigo=cadenas[opc1-1]+"/"+cadenas[opc2-1];
                Convertir moneda = new Convertir();
                try{
                    Moneda mon = moneda.ConvertirMoneda(cantidad,codigo);
                    mensaje="El valor de " + cantidad +" "+mon.toString();
                    System.out.println("\n"+mensaje+".");

                    Date date = new Date();
                    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm dd-MM-yyyy");
                    String historial = hourdateFormat.format(date);
                    String men_guar="// "+mensaje+".  "+historial+"\n";

                    escritura.write(men_guar);
                } catch (NumberFormatException e){
                    System.out.println("\nNúmero no valido");
                } catch (RuntimeException | IOException e){
                    System.out.println(e.getMessage());
                    System.out.println("\nFinalizando la aplicación.");
                }
            }
            if(opcion==2){
                System.out.println("\nFinalizando el programa. Muchas gracias por usar nuestros servicios");
                escritura.close();
                break;
            }

            if(opcion>2){ System.out.println("\nOpción inválida"); }

        }
    }
}
