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
        String [] cadenas = {""};
        String mensaje;
        String menu1 = """
                    \n ********************************************
 * Sea bienvenido/a al conversor de Monedas *
 ********************************************
 * 1) Convertir.                            *
 * 2) Salir.                                *
 ********************************************
""";

        String menu2 = """
                    \n **********************************************************************************************************************************************************
 *                                                                   Monedas Soportadas                                                                   *
 **********************************************************************************************************************************************************
""";

        Scanner teclado = new Scanner(System.in);
        FileWriter escritura = new FileWriter("convercion.json"); // Creo un objeto de la funcion para crear archivos con el nombre


        while(opcion != 2){
            System.out.print(menu1);
            System.out.print("Escoja una opcion: ");
            opcion = teclado.nextInt();

            if(opcion==1){
                Monedas_Admitidas mostrar = new Monedas_Admitidas();
                try{
                    Admitidas adm = mostrar.ListarMoneda();
                    String[] texto = adm.toString().split(",");
                    cadenas = adm.toString().split(",");
                    System.out.print(menu2);
                    System.out.println(" *   1) "+texto[0]+".      *   2) "+texto[1]+".      *   3) "+texto[2]+".      *   4) "+texto[3]+".      *   5) "+texto[4]+".      *   6) "+texto[5]+".      *   7) "+texto[6]+".      *   8) "+texto[7]+".      *   9) "+texto[8]+".      *");
                    System.out.println(" *  10) "+texto[9]+".      *  11) "+texto[10]+".      *  12) "+texto[11]+".      *  13) "+texto[12]+".      *  14) "+texto[13]+".      *  15) "+texto[14]+".      *  16) "+texto[15]+".      *  17) "+texto[16]+".      *  18) "+texto[17]+".      *");
                    System.out.println(" *  19) "+texto[18]+".      *  20) "+texto[19]+".      *  21) "+texto[20]+".      *  22) "+texto[21]+".      *  23) "+texto[22]+".      *  24) "+texto[23]+".      *  25) "+texto[24]+".      *  26) "+texto[25]+".      *  27) "+texto[26]+".      *");
                    System.out.println(" *  28) "+texto[27]+".      *  29) "+texto[28]+".      *  30) "+texto[29]+".      *  31) "+texto[30]+".      *  32) "+texto[31]+".      *  33) "+texto[32]+".      *  34) "+texto[33]+".      *  35) "+texto[34]+".      *  36) "+texto[35]+".      *");
                    System.out.println(" *  37) "+texto[36]+".      *  38) "+texto[37]+".      *  39) "+texto[38]+".      *  40) "+texto[39]+".      *  41) "+texto[40]+".      *  42) "+texto[41]+".      *  43) "+texto[42]+".      *  44) "+texto[43]+".      *  45) "+texto[44]+".      *");
                    System.out.println(" *  46) "+texto[45]+".      *  47) "+texto[46]+".      *  48) "+texto[47]+".      *  49) "+texto[48]+".      *  50) "+texto[49]+".      *  51) "+texto[50]+".      *  52) "+texto[51]+".      *  53) "+texto[52]+".      *  54) "+texto[53]+".      *");
                    System.out.println(" *  55) "+texto[54]+".      *  56) "+texto[55]+".      *  57) "+texto[56]+".      *  58) "+texto[57]+".      *  59) "+texto[58]+".      *  60) "+texto[59]+".      *  61) "+texto[60]+".      *  62) "+texto[61]+".      *  63) "+texto[62]+".      *");
                    System.out.println(" *  64) "+texto[63]+".      *  65) "+texto[64]+".      *  66) "+texto[65]+".      *  67) "+texto[66]+".      *  68) "+texto[67]+".      *  69) "+texto[68]+".      *  70) "+texto[69]+".      *  71) "+texto[70]+".      *  72) "+texto[71]+".      *");
                    System.out.println(" *  73) "+texto[72]+".      *  74) "+texto[73]+".      *  75) "+texto[74]+".      *  76) "+texto[75]+".      *  77) "+texto[76]+".      *  78) "+texto[77]+".      *  79) "+texto[78]+".      *  80) "+texto[79]+".      *  81) "+texto[80]+".      *");
                    System.out.println(" *  82) "+texto[81]+".      *  83) "+texto[83]+".      *  84) "+texto[83]+".      *  85) "+texto[84]+".      *  86) "+texto[85]+".      *  87) "+texto[86]+".      *  88) "+texto[87]+".      *  89) "+texto[88]+".      *  90) "+texto[89]+".      *");
                    System.out.println(" *  91) "+texto[91]+".      *  92) "+texto[91]+".      *  93) "+texto[92]+".      *  94) "+texto[93]+".      *  95) "+texto[94]+".      *  96) "+texto[95]+".      *  97) "+texto[96]+".      *  98) "+texto[97]+".      *  99) "+texto[98]+".      *");
                    System.out.println(" * 100) "+texto[99]+".      * 101) "+texto[100]+".      * 102) "+texto[101]+".      * 103) "+texto[102]+".      * 104) "+texto[103]+".      * 105) "+texto[104]+".      * 106) "+texto[105]+".      * 107) "+texto[106]+".      * 108) "+texto[107]+".      *");
                    System.out.println(" * 109) "+texto[108]+".      * 110) "+texto[109]+".      * 111) "+texto[110]+".      * 112) "+texto[111]+".      * 113) "+texto[112]+".      * 114) "+texto[113]+".      * 115) "+texto[114]+".      * 116) "+texto[115]+".      * 117) "+texto[116]+".      *");
                    System.out.println(" * 118) "+texto[117]+".      * 119) "+texto[118]+".      * 120) "+texto[119]+".      * 121) "+texto[120]+".      * 122) "+texto[121]+".      * 123) "+texto[122]+".      * 124) "+texto[123]+".      * 125) "+texto[124]+".      * 126) "+texto[125]+".      *");
                    System.out.println(" * 127) "+texto[126]+".      * 128) "+texto[127]+".      * 129) "+texto[128]+".      * 130) "+texto[129]+".      * 131) "+texto[130]+".      * 132) "+texto[131]+".      * 133) "+texto[132]+".      * 134) "+texto[133]+".      * 135) "+texto[134]+".      *");
                    System.out.println(" * 136) "+texto[135]+".      * 137) "+texto[136]+".      * 138) "+texto[137]+".      * 139) "+texto[138]+".      * 140) "+texto[139]+".      * 141) "+texto[140]+".      * 142) "+texto[141]+".      * 143) "+texto[142]+".      * 144) "+texto[143]+".      *");
                    System.out.println(" * 145) "+texto[144]+".      * 146) "+texto[145]+".      * 147) "+texto[146]+".      * 148) "+texto[147]+".      * 149) "+texto[148]+".      * 150) "+texto[149]+".      * 151) "+texto[150]+".      * 152) "+texto[151]+".      * 153) "+texto[152]+".      *");
                    System.out.println(" * 154) "+texto[153]+".      * 155) "+texto[154]+".      * 156) "+texto[155]+".      * 157) "+texto[156]+".      * 158) "+texto[157]+".      * 159) "+texto[158]+".      * 160) "+texto[159]+".      * 161) "+texto[160]+".                       *");
                    System.out.println(" **********************************************************************************************************************************************************");

                } catch (NumberFormatException e){
                    System.out.println("\nLos servidores estan en mantenimiento, porfavor intentelo mas tarde.");
                }

                while(opc1 != 161){
                    System.out.print("Escoja que valor monetario base: ");
                    opc1 = teclado.nextInt();
                    if (opc1 > 161){ System.out.println("\nOpción inválida"); } else { break; }
                }

                System.out.print("Ingrese una cantidad: ");
                cantidad= teclado.nextDouble();

                while(opc2 != 161){
                    System.out.print("Escoja que valor monetario que desea obtener: ");
                    opc2 = teclado.nextInt();
                    if (opc2 > 161){ System.out.println("\nOpción inválida"); } else { break; }
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
            // Validaciones del Primer cuadro
            // Finaliza
            if(opcion==2){
                System.out.println("\nFinalizando el programa. Muchas gracias por usar nuestros servicios");
                escritura.close();
                break;
            }
            // selección inexistente
            if(opcion>2){ System.out.println("\nOpción inválida"); }

        }
    }
}