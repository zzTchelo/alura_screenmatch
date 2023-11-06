package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.calculos.Calculos;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodes;
import br.com.alura.screenmatch.modelos.Movies;
import br.com.alura.screenmatch.modelos.Series;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movies meuFilme = new Movies("O poderoso chefão", 1970);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Series lost = new Series("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Movies outroFilme = new Movies("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);

        ArrayList<Movies> listaFilmes = new ArrayList<Movies>();

        listaFilmes.add(meuFilme);
        listaFilmes.add(outroFilme);
        System.out.println("Filmes adicionados: " + listaFilmes.size());
        System.out.println("Primeiro filme: " + listaFilmes.get(0).getNome());

        Calculos calculadora = new Calculos();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtroRecomendacao = new FiltroRecomendacao();
        filtroRecomendacao.filtra(meuFilme);

        Episodes episodio  = new Episodes();
        episodio.setNumero(1);
        episodio.setSerie(lost);
    }
}