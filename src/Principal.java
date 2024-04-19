
import java.io.FileWriter;   //importo la libreria de creacion de archivos
import java.io.IOException; //libreria para utilisar las funciones del try y catch
import java.util.Scanner;  //importo los servicios para agregar por teclado datos

public class Principal {
    public static void main(String[] args) throws IOException {

        int opcion= 0;
        int opc1,opc2;
        double cantidad;
        String mensaje;
        String cod1 ="";
        String cod2 ="";
        String menu1 = """
                    \n********************************************
* Sea bienvenido/a al conversor de Monedas *
********************************************
* 1) Convertir.                            *
* 2) Salir.                                *
********************************************
""";


        String menu2 = """
                    \n********************************************
*            Monedas soportadas            *
********************************************
*  1) Dólar (USD).                         *
*  2) Peso argentino (ARS).                *
*  3) Real Brasileño (BRL).                *
*  4) Peso colombiano (COP).               *
*  5) Rupia indonesia (INR).               *
*  6) Dólar de Hong Kong (HKD).            *
*  7) Peso mexicano (MXN).                 *
*  8) Dólar liberiano (LRD).               *
*  9) Rublo ruso (RUB).                    *
* 10) Corona sueca (SEK).                  *
********************************************
""";

        Scanner teclado = new Scanner(System.in);
        FileWriter escritura = new FileWriter("convercion.json"); // Creo un objeto de la funcion para crear archivos con el nombre


        while(opcion != 2){
            System.out.print(menu1);

            System.out.print("Escoja una opcion: ");
            opcion = teclado.nextInt();


            if(opcion==1){
                System.out.print(menu2);

                System.out.print("Escoja que valor monetario base: ");
                opc1 = teclado.nextInt();

                if(opc1==1){ cod1="USD"; }
                if(opc1==2){ cod1="ARS"; }
                if(opc1==3){ cod1="BRL"; }
                if(opc1==4){ cod1="COP"; }
                if(opc1==5){ cod1="INR"; }
                if(opc1==6){ cod1="HKD"; }
                if(opc1==7){ cod1="MXN"; }
                if(opc1==8){ cod1="LRD"; }
                if(opc1==9){ cod1="RUB"; }
                if(opc1==10){ cod1="SEK"; }

                System.out.print("Ingrese una cantidad: ");
                cantidad= teclado.nextDouble();


                System.out.print("Escoja que valor monetario que desea obtener: ");
                opc2 = teclado.nextInt();

                if(opc2==1){ cod2="USD"; }
                if(opc2==2){ cod2="ARS"; }
                if(opc2==3){ cod2="BRL"; }
                if(opc2==4){ cod2="COP"; }
                if(opc2==5){ cod2="INR"; }
                if(opc2==6){ cod2="HKD"; }
                if(opc2==7){ cod2="MXN"; }
                if(opc2==8){ cod2="LRD"; }
                if(opc2==9){ cod2="RUB"; }
                if(opc2==10){ cod2="SEK"; }

                Convertir moneda = new Convertir();
                String codigo=cod1+"/"+cod2;

                try{
                    Moneda mon = moneda.ConvertirMoneda(cantidad,codigo);
                    mensaje="El valor de " + cantidad +" "+mon.toString();
                    System.out.println("\n"+mensaje+".");
                    String men_guar="// "+mensaje+".\n";

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

            if(opcion>2){ System.out.println("\nOpción inválida");
            }

        }
    }
}
