package com.example.lab08_idnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class PostulanteRegistroActivity extends AppCompatActivity {
    Button btnRegistrar;
    public static final String KEY_NAME = "REGISTRO";
    public Helper helper = new Helper();
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);
        context = getApplicationContext();

        EditText edtNombres = findViewById(R.id.edtName);
        EditText edtApellidoPaterno = findViewById(R.id.edtApePat);
        EditText edtApellidoMaterno = findViewById(R.id.edtApeMat);
        EditText edtDni = findViewById(R.id.edtDni);
        EditText edtFechaNacimiento = findViewById(R.id.edtFecNac);
        EditText edtColegioPrecedencia = findViewById(R.id.edtCole);
        EditText edtCarrera = findViewById(R.id.edtCar);
        TextView txtMensaje = findViewById(R.id.textMensaje);
        btnRegistrar =findViewById(R.id.btnRegister);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Postulante postul= new Postulante();
                postul.setNombre(edtNombres.getText().toString());
                postul.setApellidoPaterno(edtApellidoPaterno.getText().toString());
                postul.setApellidoMaterno(edtApellidoMaterno.getText().toString());
                postul.setDni(edtDni.getText().toString());
                postul.setFechaNac(edtFechaNacimiento.getText().toString());
                postul.setColegio(edtColegioPrecedencia.getText().toString());
                postul.setCarrera(edtCarrera.getText().toString());
                if(!(TextUtils.isEmpty(postul.getDni())
                        || TextUtils.isEmpty(postul.getNombre())
                        || TextUtils.isEmpty(postul.getApellidoPaterno())
                        || TextUtils.isEmpty(postul.getApellidoMaterno())
                        || TextUtils.isEmpty(postul.getFechaNac())
                        || TextUtils.isEmpty(postul.getColegio())
                        || TextUtils.isEmpty(postul.getCarrera()))) {

                    String data = "DNI: " + postul.getDni() +
                            " Nombre: " + postul.getNombre() +
                            " Apellidos: " + postul.getApellidoPaterno() + " " + postul.getApellidoMaterno() +
                            " F. de nacimiento: " + postul.getFechaNac() +
                            " Colegio: " + postul.getColegio() +
                            " Carrera: " + postul.getCarrera() + "\n";

                    helper.writeFile(data, context);
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();

                } else {
                    txtMensaje.setText("Registro invalido");
                }
            }
        });
    }
}