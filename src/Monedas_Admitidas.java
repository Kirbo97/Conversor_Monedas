import com.google.gson.Gson;  //importo la libreria de especifica de gson

import java.net.URI;
import java.net.http.HttpClient;  //importo los servicios para enviar solicitudes HTTP y recibir respuestas HTTP de un recurso identificado por un URI.
import java.net.http.HttpRequest;  //importo los servicios para que ASP.NET lea los valores HTTP enviados por un cliente durante una solicitud web.
import java.net.http.HttpResponse;  //importo los servicios para encapsular la información de la respuesta HTTP de una operación ASP.NET

public class Monedas_Admitidas {

    public Admitidas ListarMoneda(){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3dab37bc7926d45742ef4238/latest/AED");
        HttpClient client = HttpClient.newHttpClient(); //creo un objeto para que establesca conecion de cliente servidor
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build(); //creo un objeto de una funcion para que lea los valores HTTP enviados por un cliente y los busque

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());  //creo un objeto de una funcion para que el objeto tenga lo que el cliente solicite y reciba un encapsulado de lo que se busca
            return new Gson().fromJson(response.body(), Admitidas.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo convertir.");
        }
    }
}