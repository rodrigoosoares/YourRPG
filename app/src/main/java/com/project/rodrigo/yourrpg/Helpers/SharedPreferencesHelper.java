package com.project.rodrigo.yourrpg.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.project.rodrigo.yourrpg.models.Jogador;

/**
 * Classe que contem os métodos das operações das Shared Preferences
 * @autor Rodrigo de Oliveira Soares
 */
public class SharedPreferencesHelper {

    private static final String USER_PREF_NAME = "user_pref";
    private static final String USER_KEY_WORD = "user";

    /*public static final String ACCESS_PREF_NAME = "acces_pref";
    public static final String ACCESS_KEY_WORD = "access";*/

    private SharedPreferences sharedPrefs;
    private Gson gson;

    public SharedPreferencesHelper(Context context){
        sharedPrefs = context.getApplicationContext().getSharedPreferences(USER_PREF_NAME, Context.MODE_PRIVATE);
    }

    //Métodos referente a preferences do jogador
    /**
     * Método que salva as Prefs do usuário
     * @param jogador Jogador - Objeto do tipo Jogador
     * @author Rodrigo de Oliveira Soares
     */
    public void saveUserPrefs(Jogador jogador){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        gson = new Gson();
        String usuarioString = gson.toJson(jogador);
        editor.putString(USER_KEY_WORD, usuarioString);
        editor.apply();
    }

    /**
     * Método que recupera as informações da Pref do usuário
     * @return Jogador - Objeto do tipo Jogador contendo as informações do usuário
     * @author Rodrigo de Oliveira Soares
     */
    public Jogador getUserPrefs(){
        Gson gson = new Gson();
        String json = sharedPrefs.getString(USER_KEY_WORD,null);
        return gson.fromJson(json,Jogador.class);
    }

    /**
     * Método que verifica se as Prefs do usuário estão nulas ou não
     * @return Boolean - Bollean de resposta se a Pref está vázia ou não
     * @author Rodrigo de Oliveira Soares
     */
    public boolean getUserPreferencesStatus(){
        return sharedPrefs.getString(USER_KEY_WORD,null) == null;
    }
}