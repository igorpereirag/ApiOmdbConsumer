import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Apiconnect {
    private String chave;

    public Apiconnect(String chave) {
        this.chave = chave;
    }

    public String getNomeDoFilme() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do filme para busca:");
        var busca = leitura.nextLine();
        return busca.equals("sair") ? "sair" : "https://www.omdbapi.com/?t=" + busca + "&apikey=" + this.chave;
    }

    public String buscarFilme() throws IOException, InterruptedException {
        String enderecoFilme = getNomeDoFilme();
        if (enderecoFilme.equals("sair")) {
            return "sair";
        }
    
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(enderecoFilme)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
        if (response.body().contains("Movie not found!")) {
            return "Movie not found!";
        }
    
        return response.body();
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
