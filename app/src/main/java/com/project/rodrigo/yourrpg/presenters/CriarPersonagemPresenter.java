package com.project.rodrigo.yourrpg.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.activities.CriarPersonagemActivity;
import com.project.rodrigo.yourrpg.helpers.SharedPreferencesHelper;
import com.project.rodrigo.yourrpg.models.Jogador;

import java.io.FileNotFoundException;
import java.io.InputStream;


/**
 * Presenter que contem todos os métodos da view CriarPersonagemActivity
 */
public class CriarPersonagemPresenter {


    private CriarPersonagemActivity activity;
    private Context context;
    private AlertDialog.Builder dialog_builder;

    public CriarPersonagemPresenter(Context context) {
        this.context = context;
    }
    public CriarPersonagemPresenter(Context context,CriarPersonagemActivity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void createUserObject(String nome, String classe, Bitmap imageDoJogador){
        if (nome.equals("") || classe.equals("")){
            dialog_builder = new AlertDialog.Builder(context);
            if (nome.equals("")) {
                dialog_builder.setMessage(R.string.escolha_nome)
                        .setPositiveButton(R.string.ok, null);

            }else{
                dialog_builder.setMessage(R.string.escolha_classe)
                        .setPositiveButton(R.string.ok, null);
            }
            dialog_builder.create();
            dialog_builder.show();
        }
        else {
            Jogador jogador = new Jogador(
                    nome,
                    classe,
                    1,
                    0,
                    1000,
                    imageDoJogador
            );
           new SharedPreferencesHelper(context).saveUserPrefs(jogador);
        }
    }

    public void pickPhoto(){
        try {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            activity.startActivityForResult(photoPickerIntent, 1);
        }catch (Exception e){
            Log.i("Error",e.toString());
        }
    }
    public void setPhoto(int resultCode, Intent data, ImageButton image){
        if (resultCode == Activity.RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = activity.getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                image.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                dialog_builder = new AlertDialog.Builder(context);
                dialog_builder.setMessage(R.string.algo_deu_erro)
                        .setNegativeButton(R.string.ok, null);
                //Toast.makeText(activity, R.string.algo_deu_erro, Toast.LENGTH_LONG).show();
            }
        }else {
            dialog_builder = new AlertDialog.Builder(context);
            dialog_builder.setMessage(R.string.foto_nao_selecionada)
                    .setNegativeButton(R.string.ok, null);
            //Toast.makeText(activity, R.string.foto_nao_selecionada,Toast.LENGTH_LONG).show();
        }
    }
}
