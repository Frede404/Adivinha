package com.fred.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Display_Jogo extends AppCompatActivity {
    private Random random = new Random();
    public int numeroAdivinhar = random.nextInt(10) + 1;
    public int tentativas = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__jogo);
        Toast.makeText(this, "numero\n"+ numeroAdivinhar, Toast.LENGTH_SHORT).show(); // Mensagem informativa
    }
    /*
    public class Ponto{
        int x;
        int y;

        public void set(int novox, int novoy){
            x = novox;
            y = novoy;
        }
    }*/

    public void tentar(View view){
        EditText numero_inserido = (EditText) findViewById(R.id.InsertNumber);
        int numero_selecionado = Integer.parseInt(numero_inserido.getText().toString());
        TextView ntentativas = findViewById(R.id.textViewTentativas);
        //Button button = (Button)findViewById(R.id.buttonPlay);

        /*if(button.getText().toString().equals(R.string.Restart)){
            button.setText(R.string.TryButon);
            numeroAdivinhar = random.nextInt(10) + 1;
            tentativas = 0;
            ntentativas.setText("" + tentativas);
        }
        else
            {*/
            tentativas++;

            if (numeroAdivinhar == numero_selecionado) { //verifica se acertou
                ntentativas.setText("" + tentativas);
                Toast.makeText(this, "numero de tentativas\n" + tentativas, Toast.LENGTH_SHORT).show(); // Mensagem informativa
                //button.setText(R.string.Restart);
            } else {
                ntentativas.setText("" + tentativas);
                ntentativas.requestFocus();
            }
        //}
    }
}
