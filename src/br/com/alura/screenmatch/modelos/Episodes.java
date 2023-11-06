package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Episodes implements Classificavel {

    private int numero;
    private String nome;
    private Series serie;
    private int totalVisualizacoes;

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Series getSerie() {
        return serie;
    }

    public void setSerie(Series serie) {
        this.serie = serie;
    }


    @Override
    public double getClassificacao() {
        if (totalVisualizacoes > 100) {
            return 0;
        } else {
            return 2;
        }

    }
}
