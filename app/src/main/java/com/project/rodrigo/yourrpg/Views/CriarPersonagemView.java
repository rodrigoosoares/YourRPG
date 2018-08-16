package com.project.rodrigo.yourrpg.Views;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.Tabelas.Jogador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class CriarPersonagemView extends AppCompatActivity {

    private static final String PREF_NAME = "user_pref";
    private static final String KEY_WORD = "user";
    private int RESULT_LOAD_IMG;
    private Gson gson;
    private SharedPreferences sharedPreferences;
    private Button btnSave;
    private ImageButton ibPickPhoto;
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
        ibPickPhoto = findViewById(R.id.ibPickPhoto);

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
        ibPickPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
                }catch (Exception e){
                    Log.i("Error",e.toString());
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                ibPickPhoto.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }
}
