package com.stefanini.ia.model;

public record Livro(
        String categoria,
        String livro,
        int ano,
        String resenha,
        String autor,
        String resumo
){};