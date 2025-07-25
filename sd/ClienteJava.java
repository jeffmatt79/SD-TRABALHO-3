import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClienteJava {
    private static final String URL = "http://localhost:8080/funcionarios";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Listar funcionários");
            System.out.println("2. Cadastrar novo funcionário");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine().trim();

            switch (escolha) {
                case "1":
                    listarFuncionarios();
                    break;
                case "2":
                    cadastrarFuncionario();
                    break;
                case "3":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        }
    }

    private static void listarFuncionarios() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            String body = response.body();
            if (body.trim().equals("[]") || body.trim().isEmpty()) {
                System.out.println("\nNenhum funcionário cadastrado.\n");
            } else {
                System.out.println("\nLista de funcionários:");
                System.out.println(body);
                System.out.println();
            }
        } else {
            System.out.println("Erro ao listar: " + response.statusCode());
        }
    }

    private static void cadastrarFuncionario() throws IOException, InterruptedException {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine().trim();

        String funcionarioJson = String.format("{\"nome\": \"%s\", \"cargo\": \"%s\"}", nome, cargo);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(funcionarioJson))
                .build();
        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        if (postResponse.statusCode() == 200 || postResponse.statusCode() == 201) {
            System.out.println("\nFuncionário cadastrado com sucesso!\n");
        } else {
            System.out.println("\nErro ao cadastrar: " + postResponse.statusCode());
        }
    }
}
