package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.modelos.Movies;
import br.com.alura.screenmatch.modelos.Series;
import br.com.alura.screenmatch.modelos.Title;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainWithList {
    public static void main(String[] args) {
        Movies meuFilme = new Movies("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Series lost = new Series("Lost", 2000);
        Movies outroFilme = new Movies("Avatar", 2023);
        outroFilme.avalia(8);
        
        List<Title> listaTitulos = new ArrayList<>();
        listaTitulos.add(meuFilme);
        listaTitulos.add(outroFilme);
        listaTitulos.add(lost);
        listaTitulos.sort(Comparator.comparing(Title::getNome));

        for (Title titulo : listaTitulos) {
            System.out.println("Nome do Titulo: " + titulo.getNome());
            System.out.println("Ano de lançamento: " + titulo.getAnoDeLancamento());
            if(titulo instanceof Movies filme && filme.getClassificacao() > 2){
                System.out.println("Classificacao: " + filme.getClassificacao());
            }
            System.out.println();
        }
    }
}
