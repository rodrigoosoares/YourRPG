package com.project.rodrigo.yourrpg.Tabelas;


/**
 * Classe utilizada para armazenar os dados do jogador.
 */
public class Jogador {

    public String nome;
    public String classe;
    public int nivel;
    public int experiencia;
    public int proximo_nivel_xp;

    public Jogador(String nome, String classe, int nivel, int experiencia, int proximo_nivel_xp) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.proximo_nivel_xp = proximo_nivel_xp;
    }
}
