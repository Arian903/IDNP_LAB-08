package com.example.lab08_idnp;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    Button btnRegNew;
    Button btnInfoPost;
    public static final String KEY_NAME = "MENU";
    int Activity_OK = 0;

    TextView txtResult;

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        Intent intent = result.getData();
                        txtResult.setText("Registro completo");
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnRegNew = findViewById(R.id.btnNuevo);
        btnInfoPost = findViewById(R.id.btnInfo);

        ArrayList<Postulante> postulanteList = new ArrayList<Postulante>();
        Postulante postul = new Postulante();


        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity_OK) {
                            Intent intent = result.getData();
                            postulanteList.add((Postulante) intent.getSerializableExtra("postulante"));
                            // Handle the Intent
                        }
                    }
                });

        btnRegNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistro = new Intent(getApplicationContext(),PostulanteRegistroActivity.class);
                mStartForResult.launch(intentRegistro);

            }
        });

        btnInfoPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendintent = new Intent(getApplicationContext(), PostulanteInfoActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("list", postulanteList);
                sendintent.putExtra("bundle", args);
                startActivity(sendintent);
            }
        });

    }
}