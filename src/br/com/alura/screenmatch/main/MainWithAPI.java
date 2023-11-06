package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.exceptions.YearConversionError;
import br.com.alura.screenmatch.modelos.OmdbTitle;
import br.com.alura.screenmatch.modelos.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class MainWithAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<Title> titulos = new ArrayList<>();
        List<String> strBusca = new ArrayList<>();
        strBusca.add("Star+Wars");
        strBusca.add("Star+Trek");
        strBusca.add("Top+Gun");
        strBusca.add("Taxi+Driver");
        strBusca.add("Matrix");
        strBusca.add("John+Wick");
        strBusca.add("Zombieland");
        strBusca.add("Titanic");
        strBusca.add("SpiderMan");
        strBusca.add("Fantastic+Four");

        for (String str : strBusca) {
            String urlAPI = "https://www.omdbapi.com/?t=" + str + "&apikey=5dd4f6ec";
            try {
                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .uri(URI.create(urlAPI))
                        .build();
                HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                String jsonTitle = httpResponse.body();
                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .create();
                OmdbTitle mdbTitle = gson.fromJson(jsonTitle, OmdbTitle.class);

                Title titulo = new Title(mdbTitle);
                titulos.add(titulo);

            } catch (YearConversionError ex) {
                System.out.println(ex.getErrorMenssage());
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        for (Title titulo:titulos) {
            System.out.println("Título: " + titulo.getNome() +
                    " (" + titulo.getAnoDeLancamento() + ")");
        }

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        FileWriter file = new FileWriter("filme.json");
        file.write(gson.toJson(titulos));
        file.close();

    }
}
