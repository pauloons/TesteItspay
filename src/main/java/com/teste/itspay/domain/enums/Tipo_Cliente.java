package com.teste.itspay.domain.enums;

public enum Tipo_Cliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private Tipo_Cliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao () {
        return descricao;
    }

    public static Tipo_Cliente toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Tipo_Cliente x : Tipo_Cliente.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}