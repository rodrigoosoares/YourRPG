package com.project.rodrigo.yourrpg.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.project.rodrigo.yourrpg.models.Jogador;

public class SharedPreferencesHelper {

    private static final String USER_PREF_NAME = "user_pref";
    private static final String USER_KEY_WORD = "user";

    private static final String ACCESS_PREF_NAME = "acces_pref";
    private static final String ACCESS_KEY_WORD = "access";
    // other shared preference keys

    private SharedPreferences sharedPrefs;
    private Gson gson;

    public SharedPreferencesHelper(Context context){
        sharedPrefs = context.getApplicationContext().getSharedPreferences(USER_PREF_NAME, Context.MODE_PRIVATE);
    }
    //Métodos referente a preferences do jogador
    public void saveUserPrefs(Jogador jogador){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        gson = new Gson();
        String usuarioString = gson.toJson(jogador);
        editor.putString(USER_KEY_WORD, usuarioString);
        editor.apply();
        }
    public Jogador getUserPrefs(){
        return null;
        //Implementar esse método
    }
}

