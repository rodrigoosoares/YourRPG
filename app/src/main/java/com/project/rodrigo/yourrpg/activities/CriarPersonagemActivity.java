package com.project.rodrigo.yourrpg.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.presenters.CriarPersonagemPresenter;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CriarPersonagemActivity extends AppCompatActivity {

    private CriarPersonagemPresenter mPresenter;
    private int RESULT_LOAD_IMG;

    private Button btnSave;
    private ImageButton ibPickPhoto;
    private EditText etUserName;
    private EditText etUserClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_personagem_view);

        mPresenter = new CriarPersonagemPresenter(this,this);

        btnSave = findViewById(R.id.btnSaveUserPrefs);
        etUserName = findViewById(R.id.etUserName);
        etUserClass = findViewById(R.id.etUserClass);
        ibPickPhoto = findViewById(R.id.ibPickPhoto);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.createUserObject(etUserName.getText().toString(),
                        etUserClass.getText().toString(),
                        ((BitmapDrawable)ibPickPhoto.getDrawable()).getBitmap());
            }
        });
        ibPickPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.pickPhoto();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.setPhotoReturns(resultCode,data,ibPickPhoto);
    }
}
