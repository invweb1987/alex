package com.example.guesser;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GuesserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random random = new Random();
        int integerToGuess = random.nextInt();
        integerToGuess = Math.abs(integerToGuess);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.guesser_actyvity);

        TextView textView = findViewById(R.id.test_number);
        textView.setText("Число, которое нужно угадать: " + integerToGuess);

        final EditText guessInput = findViewById(R.id.guess_number);

        Button button = findViewById(R.id.guess_buotton);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        final String toGuess = "" + integerToGuess;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guessInput.getText().toString().equals(toGuess.toString())) {
                    alertDialogBuilder.setTitle("Угадано: ");
                    alertDialogBuilder.setMessage(guessInput.getText());

                    AlertDialog dialog = alertDialogBuilder.create();
                    dialog.show();
                } else {
                    alertDialogBuilder.setTitle("Не угодал:");
                    alertDialogBuilder.setMessage(guessInput.getText());

                    AlertDialog dialog = alertDialogBuilder.create();
                    dialog.show();
                }
            }

        });
    }
}
