package com.example.guesser;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Random;

public class UpdatedGuesserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updated_guesser_actyvity);
        final EditText guessNumberEditText = findViewById(R.id.guess_number);
        final TextView numberToFind = findViewById(R.id.number_to_find);

        int randNum = 1000;

        final LinkedList<Integer> integers = new LinkedList<Integer>();
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        Random rand = new Random();
        int nextInt = rand.nextInt(randNum);

        integers.clear();
        integers.add(nextInt);

        numberToFind.setText("Нужно найти " + nextInt);

        Button buttonLess = findViewById(R.id.less_buotton);
        Button buttonMore = findViewById(R.id.more_buotton);

        buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer integer = integers.get(0);
                integer--;
                integers.set(0,integer);
                numberToFind.setText("Нужно найти " + integer);
            }
        });

        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer integer = integers.get(0);
                integer++;
                integers.set(0,integer);
                numberToFind.setText("Нужно найти " + integer);
            }
        });

        Button guessButton = findViewById(R.id.guess_buotton);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer toGuess = integers.get(0);

                if (guessNumberEditText.getText().toString().equals(toGuess.toString())) {
                    alertDialogBuilder.setTitle("Угадано: ");
                    alertDialogBuilder.setMessage(guessNumberEditText.getText());

                    AlertDialog dialog = alertDialogBuilder.create();
                    dialog.show();
                } else {
                    alertDialogBuilder.setTitle("Не угодал:");
                    alertDialogBuilder.setMessage(guessNumberEditText.getText());

                    AlertDialog dialog = alertDialogBuilder.create();
                    dialog.show();
                }
            }
        });
    }
}
