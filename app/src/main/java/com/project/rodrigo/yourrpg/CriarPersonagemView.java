package com.project.rodrigo.yourrpg;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.project.rodrigo.yourrpg.Tabelas.Jogador;

public class CriarPersonagemView extends AppCompatActivity {

    private static final String PREF_NAME = "user_pref";
    private static final String KEY_WORD = "user";
    private Gson gson;
    private SharedPreferences sharedPreferences;
    private Button btnSave;
    private EditText etUserName;
    private EditText etUserClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_personagem_view);
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        btnSave = findViewById(R.id.btnSaveUserPrefs);
        etUserName = findViewById(R.id.etUserName);
        etUserClass = findViewById(R.id.etUserClass);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUserName.getText().toString().equals("") || etUserClass.getText().toString().equals("")){
                    AlertDialog.Builder dialog_builder = new AlertDialog.Builder(v.getContext());
                    if (etUserName.getText().toString().equals("")) {
                        dialog_builder.setMessage("Defina seu nome aventureiro!")
                                      .setPositiveButton(R.string.ok, null);

                    }else{
                        dialog_builder.setMessage("Defina sua classe aventureiro!")
                                .setPositiveButton(R.string.ok, null);
                    }
                    dialog_builder.create();
                    dialog_builder.show();
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Jogador jogador = new Jogador(
                            etUserName.getText().toString(),
                            etUserClass.getText().toString(),
                            1,
                            0,
                            1000
                    );
                    gson = new Gson();
                    String usuarioString = gson.toJson(jogador);
                    editor.putString(KEY_WORD, usuarioString);
                    editor.apply();
                }
            }
        });
        /*
        PARA SER FEITO:
            criar outro fragment para o jogador selecionar sua imagem
        */
    }
}
