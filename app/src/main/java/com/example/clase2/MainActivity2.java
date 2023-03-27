package com.example.clase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setTitle("Ventana 2");


        Intent intent = getIntent();
        String textoEnviado = intent.getStringExtra("textoEnviado");
        Toast.makeText(this, "TExto recibido: " + textoEnviado, Toast.LENGTH_SHORT).show();

        Button button = findViewById(R.id.button5);
        button.setOnClickListener(view -> {
            EditText editText = findViewById(R.id.editTextMa2);
            String textoDevolver = editText.getText().toString();

            Intent intent1 = new Intent();
            intent1.putExtra("textoDevolver",textoDevolver);
            setResult(RESULT_OK,intent1);
            finish();
        });
    }

    public void regresar(View view) {
        //Intent intent = new Intent(this,MainActivity.class);
        //startActivity(intent);
        //guardo algo!!!
        Toast.makeText(this, "Se guardó correctamente el usuario", Toast.LENGTH_SHORT).show();
        finish();
    }
}