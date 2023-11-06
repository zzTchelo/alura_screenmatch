package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Movies extends Title implements Classificavel {
    private String diretor;

    public Movies(String nome, int ano) {
        super(nome, ano);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public double getClassificacao() {
        return (double) pegaMedia() / 2;
    }
}
