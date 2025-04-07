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
                        System.out.println("1. Média das tarifas");
                        System.out.println("2. País com tarifa básica mais cara");
                        System.out.print("Escolha uma opção: ");
                        int estatisticaOption = scanner.nextInt();

                        switch (estatisticaOption) {
                            case 1:
                                exibirMediaDasTarifas();
                                break;
                            case 2:
                                exibirPaisComTarifaBasicaMaisCara();
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
    private static void exibirMediaDasTarifas() {
        double somaTarifaBasica = 0;
        double somaTarifaStandard = 0;
        double somaTarifaPremium = 0;
        int totalPaises = paises.size();

        for (Pais pais : paises) {
            somaTarifaBasica += pais.getTarifaBasica();
            somaTarifaStandard += pais.getTarifaStandard();
            somaTarifaPremium += pais.getTarifaPremium();
        }

        System.out.println("Média da Tarifa Básica: " + (somaTarifaBasica / totalPaises));
        System.out.println("Média da Tarifa Standard: " + (somaTarifaStandard / totalPaises));
        System.out.println("Média da Tarifa Premium: " + (somaTarifaPremium / totalPaises));
    }

    private static void exibirPaisComTarifaBasicaMaisCara() {
        Pais paisMaisCaro = null;
        double maiorTarifaBasica = Double.MIN_VALUE;

        for (Pais pais : paises) {
            if (pais.getTarifaBasica() > maiorTarifaBasica) {
                maiorTarifaBasica = pais.getTarifaBasica();
                paisMaisCaro = pais;
            }
        }

        if (paisMaisCaro != null) {
            System.out.println("País com a tarifa básica mais cara: " + paisMaisCaro.getPais());
            System.out.println("Tarifa Básica: " + maiorTarifaBasica);
        } else {
            System.out.println("Nenhum país encontrado.");
        }
    }
}