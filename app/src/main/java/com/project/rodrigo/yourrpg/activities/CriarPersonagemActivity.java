package com.project.rodrigo.yourrpg.activities;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.project.rodrigo.yourrpg.R;
import com.project.rodrigo.yourrpg.presenters.CriarPersonagemPresenter;

public class CriarPersonagemActivity extends AppCompatActivity {

    private CriarPersonagemPresenter mPresenter;

    private Button btnSave;
    private ImageView ivPickPhoto;
    private EditText etUserName;
    private EditText etUserClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_personagem);

        mPresenter = new CriarPersonagemPresenter(this,this);

        btnSave = findViewById(R.id.btnSaveUserPrefs);
        etUserName = findViewById(R.id.etUserName);
        etUserClass = findViewById(R.id.etUserClass);
        ivPickPhoto = findViewById(R.id.ibPickPhoto);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.createUserObject(etUserName.getText().toString(),
                        etUserClass.getText().toString(),
                        mPresenter.BitMapToString(((BitmapDrawable) ivPickPhoto.getDrawable()).getBitmap()));
            }
        });
        ivPickPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.pickPhoto();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.setPhoto(resultCode,data, ivPickPhoto);
    }
}
