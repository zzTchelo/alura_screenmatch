package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.exceptions.YearConversionError;

public class Title implements Comparable<Title>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private double totalDeAvaliacoes;
    private int duracaoEmMinutos;
    public Title(String nome, int ano) {
        this.nome = nome;
        this.anoDeLancamento = ano;
    }
    public Title(OmdbTitle mdbTitle) {
        if (mdbTitle.year() != null && !mdbTitle.year().isEmpty()) {
            if (mdbTitle.year().length() > 4) {
                throw new YearConversionError("Erro de conversão (Ano), Busca: " + mdbTitle.title());
            }
            this.nome = mdbTitle.title();
            this.anoDeLancamento = Integer.parseInt(mdbTitle.year());
        }
    }
    public String getNome() {
        return nome;
    }
    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public double getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }
    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }
    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }
    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
    @Override
    public int compareTo(Title titulo) {
        return this.getNome().compareTo(titulo.getNome());
    }
}