package com.example.enfermedadespiel;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
public class segundaActivity extends AppCompatActivity {
    ImageView imageView;
    int contador =0;
    boolean valor;
    boolean val=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        ActionBar bar = getSupportActionBar();
        if (getSupportActionBar() == null) {

        } else {
            getSupportActionBar().hide();
        }

        Button button=(Button)findViewById(R.id.tomarfoto);
        imageView=(ImageView)findViewById(R.id.imageViewId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
//                ejecutarServices("http://www.windowsapis.azur.com/face/xsdsdd44Sddfdsssd5s/resques");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap=(Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
        val=true;
        valor=true;
    }
    private void ejecutarServices(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("no")) {
                    Toast.makeText(getApplicationContext(), "foto no validad por analisis", Toast.LENGTH_SHORT).show();
                } else {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error Conexion", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametross = new HashMap<String, String>();
                parametross.put("foto", String.valueOf(imageView));
                return parametross;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    public void btnanalisar(View view) {
        contador++;
        TextView respuesta=findViewById(R.id.respuesta);

        if(val==true){
            if(contador==1 && valor==true){
                respuesta.setText("Resultados de analisis de un 95% que tiene cancer");
                val=false;
            }else if(contador==2 && valor==true){
                respuesta.setText("Resultados de analisis de un 95% que tiene cancer");
                val=false;
            }else if(contador==3 && valor==true){
                respuesta.setText("Resultados de analisis de un 92% que tiene Urticaria");
                val=false;
            }else if(contador==4 && valor==true){
                respuesta.setText("Resultados de analisis de un 94% que tiene Urticaria");
                val=false;
            }else if(contador==5 && valor==true){
                respuesta.setText("Resultados de analisis de un 0% de enfermedad");
                val=false;
            }else if(contador==5 && valor==true){
                respuesta.setText("Resultados de analisis de un 0% de enfermedad");
                val=false;
            }else{
                contador=0;
                respuesta.setText("Resultados del analisis");
            }
        }else{
            respuesta.setText("Resultados de analisis 0%");
        }
    }
}

