import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    private Gson gson;
    private URI url ;

    public ConsultaMoneda() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.url = URI.create("https://v6.exchangerate-api.com/v6/16b700b2da720ec015fcacad/pair/");
    }

    public String consultarApi(String monedaOrigen, String monedaDestino, double monto) {
        this.url = URI.create(this.url + monedaOrigen + "/" + monedaDestino + "/" + monto);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(this.url)
                .build();
        try {
            HttpResponse response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            return (String) response.body();
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la API");
        }

    }

    public MonedaDTO convertFromJson(String moneda) {
        MonedaDTO monedaDTO = gson.fromJson(moneda, MonedaDTO.class);
        return monedaDTO;
    }
}
