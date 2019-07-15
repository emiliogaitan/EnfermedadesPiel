package com.example.enfermedadespiel;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        if (getSupportActionBar() == null) {

        } else {
            getSupportActionBar().hide();
        }
    }

    public void enviar(View view) {
        user = findViewById(R.id.editTextuno);
        String valor_uno = user.getText().toString();

        pass = findViewById(R.id.editTextdos);
        String valor_dos = pass.getText().toString();

        if (valor_uno.equals("")) {
            user.setError("Ingresar Usuario");
        } else if (valor_dos.equals("")) {
            pass.setError("Ingresar Contraseña");
        } else {
            if(valor_uno.equals("emiliogaitan") && valor_dos.equals("root")){
                Intent intent = new Intent(MainActivity.this, segundaActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),"Usuario y contrasena? No valido",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
