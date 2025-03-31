package trab;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Diego Estevão Lopes de Queiroz - 10419038
Ricardo Andre Lopes Ikeda - 10390256
Vinicius Gutierrez Gomes - 10425609
*/

public class Main {
    private static List<Pais> paises = new ArrayList<>(100);
    private static boolean dadosCarregados = false;

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
                    carregarDadosDoArquivo();
                    dadosCarregados = true;
                    break;
                case 2:
                    if (dadosCarregados) {
                        exibirRegistrosEmOrdemAlfabetica();
                    } else {
                        System.out.println("Por favor, carregue os dados primeiro (opção 1).");
                    }
                    break;
                case 3:
                    if (dadosCarregados) {
                        exibirRegistrosEmOrdemDecrescenteDeTitulos();
                    } else {
                        System.out.println("Por favor, carregue os dados primeiro (opção 1).");
                    }
                    break;
                case 4:
                    if (dadosCarregados) {
                        System.out.print("Digite a sigla do país: ");
                        String sigla = scanner.next();
                        consultarPaisPorSigla(sigla);
                    } else {
                        System.out.println("Por favor, carregue os dados primeiro (opção 1).");
                    }
                    break;
                case 5:
                    if (dadosCarregados) {
                        System.out.println("Escolha uma estatística para exibir:");
                        System.out.println("1. Estatísticas gerais");
                        System.out.println("2. Estatísticas por país");
                        System.out.println("3. Estatísticas por tarifa");
                        System.out.println("4. Estatísticas por quantidade de títulos");
                        System.out.println("5. Estatísticas por quantidade de shows");
                        System.out.println("6. Estatísticas por quantidade de filmes");
                        System.out.println("7. Estatísticas por tarifa básica");
                        System.out.print("Escolha uma opção: ");
                        int estatisticaOption = scanner.nextInt();

                        switch (estatisticaOption) {
                            case 1:
                                exibirEstatisticas();
                                break;
                            case 2:
                                exibirEstatisticasPorPais();
                                break;
                            case 3:
                                exibirEstatisticasPorTarifa();
                                break;
                            case 4:
                                exibirEstatisticasPorQuantidadeDeTitulos();
                                break;
                            case 5:
                                exibirEstatisticasPorQuantidadeDeShows();
                                break;
                            case 6:
                                exibirEstatisticasPorQuantidadeDeFilmes();
                                break;
                            case 7:
                                exibirEstatisticasPorTarifaBasica();
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } else {
                        System.out.println("Por favor, carregue os dados primeiro (opção 1).");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    System.out.println("Integrantes:");
                    System.out.println("Diego Estevão Lopes de Queiroz - 10419038");
                    System.out.println("Ricardo Andre Lopes Ikeda - 10390256");
                    System.out.println("Vinicius Gutierrez Gomes - 10425609");
                    System.out.println("Confira este vídeo incrível: https://youtu.be/MJbE3uWN9vE?si=YY0dUWvP2CQOlMy2");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 6);

        scanner.close();
    }

    private static void carregarDadosDoArquivo() {
        String filePath = "/workspaces/ProjEstrutura/trab/Netflix.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (paises.size() >= 100) {
                    System.out.println("Erro: O arquivo contém mais de 100 registros.");
                    break;
                }
                String[] data = line.split(",");
                Pais pais = new Pais(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]),
                        Double.parseDouble(data[5]),
                        Double.parseDouble(data[6]),
                        Double.parseDouble(data[7])
                );
                paises.add(pais);
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados do arquivo: " + e.getMessage());
        }
        System.out.println("Total de registros: " + paises.size());
    }

    private static void exibirRegistrosEmOrdemAlfabetica() {
        List<Pais> listaOrdenada = new ArrayList<>(paises);

        listaOrdenada.sort((p1, p2) -> p1.getPais().compareToIgnoreCase(p2.getPais()));

        for (Pais pais : listaOrdenada) {
            System.out.println(pais);
        }
    }

    private static void exibirRegistrosEmOrdemDecrescenteDeTitulos() {
        List<Pais> listaOrdenada = new ArrayList<>(paises);

        listaOrdenada.sort((p1, p2) -> Integer.compare(p2.getQtdeTitulos(), p1.getQtdeTitulos()));

        for (Pais pais : listaOrdenada) {
            System.out.println(pais);
        }
    }

    private static void consultarPaisPorSigla(String sigla) {
        for (Pais pais : paises) {
            if (pais.getSigla().equalsIgnoreCase(sigla)) {
                System.out.println(pais);
                return;
            }
        }
        System.out.println("País com sigla " + sigla + " não encontrado.");
    }
    private static void exibirEstatisticas() {
        int totalTitulos = 0;
        int totalShows = 0;
        int totalFilmes = 0;

        for (Pais pais : paises) {
            totalTitulos += pais.getQtdeTitulos();
            totalShows += pais.getQtdeShows();
            totalFilmes += pais.getQtdeFilmes();
        }

        System.out.println("Total de títulos: " + totalTitulos);
        System.out.println("Total de shows: " + totalShows);
        System.out.println("Total de filmes: " + totalFilmes);
    }
    private static void exibirEstatisticasPorPais() {
        for (Pais pais : paises) {
            System.out.println("País: " + pais.getPais());
            System.out.println("Quantidade de títulos: " + pais.getQtdeTitulos());
            System.out.println("Quantidade de shows: " + pais.getQtdeShows());
            System.out.println("Quantidade de filmes: " + pais.getQtdeFilmes());
            System.out.println();
        }
    }
    private static void exibirEstatisticasPorTarifa() {
        for (Pais pais : paises) {
            System.out.println("País: " + pais.getPais());
            System.out.println("Tarifa Básica: " + pais.getTarifaBasica());
            System.out.println("Tarifa Standard: " + pais.getTarifaStandard());
            System.out.println("Tarifa Premium: " + pais.getTarifaPremium());
            System.out.println();
        }
    }
    private static void exibirEstatisticasPorQuantidadeDeTitulos() {
        for (Pais pais : paises) {
            System.out.println("País: " + pais.getPais());
            System.out.println("Quantidade de títulos: " + pais.getQtdeTitulos());
            System.out.println();
        }
    }
    private static void exibirEstatisticasPorQuantidadeDeShows() {
        for (Pais pais : paises) {
            System.out.println("País: " + pais.getPais());
            System.out.println("Quantidade de shows: " + pais.getQtdeShows());
            System.out.println();
        }
    }
    private static void exibirEstatisticasPorQuantidadeDeFilmes() {
        for (Pais pais : paises) {
            System.out.println("País: " + pais.getPais());
            System.out.println("Quantidade de filmes: " + pais.getQtdeFilmes());
            System.out.println();
        }
    }
    private static void exibirEstatisticasPorTarifaBasica() {
        for (Pais pais : paises) {
            System.out.println("País: " + pais.getPais());
            System.out.println("Tarifa Básica: " + pais.getTarifaBasica());
            System.out.println();
        }
    }
}