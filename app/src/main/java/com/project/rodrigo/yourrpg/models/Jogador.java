package com.project.rodrigo.yourrpg.models;


import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.project.rodrigo.yourrpg.helpers.SharedPreferencesHelper;

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
        this.imagemDoJogador = imagemDoJogador;
    }

    public Jogador(int nivel, int experiencia, int proximoNivelXp) {
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

    /**
     * Método para verificar se o usuário subuiu de nível
     * @param context Context - Contexto passado ao acionar o método
     * @author Rodrigo de Oliveira Soares
     */
    public static void levelUp(Context context){
        SharedPreferencesHelper sharedPreferences = new SharedPreferencesHelper(context);
        Jogador jogador = sharedPreferences.getUserPrefs();
        int nivelAtual = jogador.getNivel();
        int xpAtual = jogador.getExperiencia();
        int xpProx = jogador.getProximoNivelXp();
        if(xpAtual == xpProx){
            nivelAtual++;
            xpAtual = 0;
            xpProx = 2000; //Montar uma formula para subir de nível ou utilizar um array com todos as Xps.
            jogador.setNivel(nivelAtual);
            jogador.setExperiencia(xpAtual);
            jogador.setProximoNivelXp(xpProx);
            sharedPreferences.saveUserPrefsLevelUp(jogador);
        }
    }

}
