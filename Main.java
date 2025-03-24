import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1. Carregar dados do arquivo");
            System.out.println("2. Exibir todos os registros em ordem alfabética de país");
            System.out.println("3. Exibir todos os registros em ordem decrescente de qtde. títulos");
            System.out.println("4. Consultar país por sigla");
            System.out.println("5. Estatísticas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Carregando dados do arquivo...");
                    break;
                case 2:
                    System.out.println("Exibindo registros em ordem alfabética de país...");
                    break;
                case 3:
                    System.out.println("Exibindo registros em ordem decrescente de qtde. títulos...");
                    break;
                case 4:
                    System.out.println("Consultando país por sigla...");
                    break;
                case 5:
                    System.out.println("Exibindo estatísticas...");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 6);

        scanner.close();
    }
}