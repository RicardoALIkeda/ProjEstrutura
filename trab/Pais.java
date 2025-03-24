package trab;

/*
Diego Estevão Lopes de Queiroz - 10419038
Ricardo Andre Lopes Ikeda - 10390256
Vinicius Gutierrez Gomes - 10425609
*/

public class Pais {
    private String sigla;
    private String pais;
    private int qtdeTitulos;
    private int qtdeShows;
    private int qtdeFilmes;
    private double tarifaBasica;
    private double tarifaStandard;
    private double tarifaPremium;

    public Pais(String sigla, String pais, int qtdeTitulos, int qtdeShows, int qtdeFilmes, double tarifaBasica, double tarifaStandard, double tarifaPremium) {
        this.sigla = sigla;
        this.pais = pais;
        this.qtdeTitulos = qtdeTitulos;
        this.qtdeShows = qtdeShows;
        this.qtdeFilmes = qtdeFilmes;
        this.tarifaBasica = tarifaBasica;
        this.tarifaStandard = tarifaStandard;
        this.tarifaPremium = tarifaPremium;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getQtdeTitulos() {
        return qtdeTitulos;
    }

    public void setQtdeTitulos(int qtdeTitulos) {
        this.qtdeTitulos = qtdeTitulos;
    }

    public int getQtdeShows() {
        return qtdeShows;
    }

    public void setQtdeShows(int qtdeShows) {
        this.qtdeShows = qtdeShows;
    }

    public int getQtdeFilmes() {
        return qtdeFilmes;
    }

    public void setQtdeFilmes(int qtdeFilmes) {
        this.qtdeFilmes = qtdeFilmes;
    }

    public double getTarifaBasica() {
        return tarifaBasica;
    }

    public void setTarifaBasica(double tarifaBasica) {
        this.tarifaBasica = tarifaBasica;
    }

    public double getTarifaStandard() {
        return tarifaStandard;
    }

    public void setTarifaStandard(double tarifaStandard) {
        this.tarifaStandard = tarifaStandard;
    }

    public double getTarifaPremium() {
        return tarifaPremium;
    }

    public void setTarifaPremium(double tarifaPremium) {
        this.tarifaPremium = tarifaPremium;
    }

    @Override
    public String toString() {
        return sigla + ", " + pais + ", " + qtdeTitulos + ", " + qtdeShows + ", " + qtdeFilmes + ", " + tarifaBasica + ", " + tarifaStandard + ", " + tarifaPremium;
    }
}