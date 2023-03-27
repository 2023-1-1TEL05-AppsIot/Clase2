package com.example.clase2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int x = 1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.editar){
            Log.d("msg-test","menu editar");
            return true;
        }
        if(item.getItemId() == R.id.delete){
            Log.d("msg-test","menu delete");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button2);
        button.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Hola Mundo", Toast.LENGTH_SHORT).show();
            Log.d("msg-ma", "Hola mundo " + (++x));
        });

        Button btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = findViewById(R.id.editTextNombre);
                String texto = editText.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("textoEnviado", texto);
                startActivity(intent);
            }
        });

        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            launcher.launch(intent);
        });

    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent resultData = result.getData();
                    String textoDevolver = resultData.getStringExtra("textoDevolver");
                    Toast.makeText(MainActivity.this, "Texto: " + textoDevolver, Toast.LENGTH_SHORT).show();
                }
            }
    );


    public void actionBtn1(View view) {
        System.out.println("Hola mundo");
        Log.d("msg-ma", "Hola mundo");
        Log.v("msg-ma", "Hola mundo");
        Log.i("msg-ma", "Hola mundo");
        Log.e("msg-ma", "Hola mundo");
    }
}