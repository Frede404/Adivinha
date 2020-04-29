package com.fred.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Display_Jogo extends AppCompatActivity {
    static final String TENTATIVAS = "tentativas";
    static final String VENCEU = "venceu";
    static final String TESTOU = "testou";
    static final String NUMEROADIVINHAR = "numeroAdivinhar";


    //private Random random = new Random();
    public int numeroAdivinhar;// = NumeroAleatorio.proximoNumero(); //random.nextInt(10) + 1;
    public int tentativas;// = 0;
    public boolean venceu;// = false;
    private boolean testou;// = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__jogo);
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            numeroAdivinhar = savedInstanceState.getInt(NUMEROADIVINHAR);
            tentativas = savedInstanceState.getInt(TENTATIVAS);
            venceu = savedInstanceState.getBoolean(VENCEU);;
            testou = savedInstanceState.getBoolean(TESTOU);;

            //todo: alterar alguns valores para variavel para traducao e meter todas as variaveis guardaddas
            //todo: fazer uma funcao para escrever tudo no ecra para ser chamado sempre que precisar
        }
        else{
            numeroAdivinhar = NumeroAleatorio.proximoNumero();
            tentativas = 0;
            venceu = false;
            testou = false;
        }
        //Toast.makeText(this, "numero\n"+ numeroAdivinhar, Toast.LENGTH_SHORT).show(); // Mensagem informativa
    }
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(NUMEROADIVINHAR, numeroAdivinhar);
        savedInstanceState.putInt(TENTATIVAS, tentativas);
        savedInstanceState.putBoolean(VENCEU, venceu);
        savedInstanceState.putBoolean(TESTOU, testou);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void tentar(View view){
        EditText numero_inserido = (EditText) findViewById(R.id.InsertNumber);

        if(numero_inserido.length()==0){
            numero_inserido.setError(numero_inserido.getHint());
            numero_inserido.requestFocus();
            return;
        }

        TextView introduzidos = findViewById(R.id.textViewUsed);
        int numero_selecionado = Integer.parseInt(numero_inserido.getText().toString());
        TextView ntentativas = findViewById(R.id.textViewTentativas);
        Button button =  (Button)findViewById(R.id.buttonPlay);

        if(numero_selecionado <= 0 || numero_selecionado > 10){
            numero_inserido.setError(getString(R.string.inserir));
            numero_inserido.requestFocus();
            return;
        }


        if(venceu){
            button.setText(R.string.TryButon);
            numeroAdivinhar = NumeroAleatorio.proximoNumero(); // random.nextInt(10) + 1;
            tentativas = 0;
            ntentativas.setText("" + tentativas);
            introduzidos.setText("");
            venceu=false;
        }
        else
            {
            tentativas++;

            if (numeroAdivinhar == numero_selecionado) { //verifica se acertou
                ntentativas.setText("" + tentativas);
                Toast.makeText(this, getString(R.string.number_of_trys)+"\n" + tentativas, Toast.LENGTH_SHORT).show(); // Mensagem informativa
                button.setText(R.string.Restart);
                numero_inserido.setText("");
                numero_inserido.requestFocus();
                hideKeyboard(); // esconde o treclado
                venceu=true;
                testou=false;
            } else {
                if(!testou){
                    introduzidos.setText(getString(R.string.number_already_used)+" "+numero_selecionado);
                    testou=true;
                }
                else{
                    introduzidos.setText(introduzidos.getText().toString()+", "+numero_selecionado);
                }
                ntentativas.setText("" + tentativas);
                numero_inserido.setText("");
                numero_inserido.requestFocus();
            }
        }
    }

    public void hideKeyboard() {//metodo para esconder o teclado https://stackoverflow.com/questions/1109022/close-hide-android-soft-keyboard/53077131#53077131
        try {
            InputMethodManager inputmanager = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputmanager != null) {
                inputmanager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception var2) {
        }
    }
}
