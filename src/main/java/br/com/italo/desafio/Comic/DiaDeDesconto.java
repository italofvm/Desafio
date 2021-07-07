package br.com.italo.desafio.comic;

public enum DiaDeDesconto {

    SEGUNDA(0, 1),
    TERCA(2, 3),
    QUARTA(4, 5),
    QUINTA(6, 7),
    SEXTA(8, 9);


    private int digito1;
    private int digito2;

    DiaDeDesconto(int digito1, int digito2) {
        this.digito1 = digito1;
        this.digito2 = digito2;
    }

    public Boolean verificaDia(int digito) {

        return digito == digito1 || digito == digito2;
    }
}
