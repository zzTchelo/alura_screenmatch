package br.com.alura.screenmatch.exceptions;

public class YearConversionError extends RuntimeException {

    private String errorMenssage;
    public YearConversionError(String mensagem) {
        this.errorMenssage = mensagem;
    }
    public String getErrorMenssage() {
        return this.errorMenssage;
    }
}
