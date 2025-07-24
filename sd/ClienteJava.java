import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteJava {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "http://localhost:8080/funcionarios";

        // Fazendo GET
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        System.out.println("Listando funcionários...\n");

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Resposta:");
        System.out.println(response.body());

        // Fazendo POST
        String novoFuncionario = """
            {
                "nome": "Carlos",
                "cargo": "456"
            }
        """;

        HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(novoFuncionario))
            .build();

        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("\nFuncionário cadastrado:");
        System.out.println(postResponse.body());
    }
}
