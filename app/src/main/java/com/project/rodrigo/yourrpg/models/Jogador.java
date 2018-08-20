package com.project.rodrigo.yourrpg.models;


import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Classe utilizada para armazenar os dados do jogador.
 */
public class Jogador {

    private String nome;
    private String classe;
    private int nivel;
    private int experiencia;
    private int proximoNivelXp;
    private Bitmap imagemDoJogador;

    public Jogador(String nome, String classe, int nivel, int experiencia, int proximoNivelXp, Bitmap imagemDoJogador) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.proximoNivelXp = proximoNivelXp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getProximoNivelXp() {
        return proximoNivelXp;
    }

    public void setProximoNivelXp(int proximoNivelXp) {
        this.proximoNivelXp = proximoNivelXp;
    }

    public Bitmap getImagemDoJogador() {
        return imagemDoJogador;
    }

    public void setImagemDoJogador(Bitmap imagemDoJogador) {this.imagemDoJogador = imagemDoJogador; }
}
