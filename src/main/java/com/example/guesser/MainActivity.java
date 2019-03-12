package com.example.guesser;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context ctx = this;

        Button guesserButton = findViewById(R.id.guesser);
        guesserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activytyGuesserIntent = new Intent(ctx, GuesserActivity.class);
                startActivity(activytyGuesserIntent);
            }
        });

        Button updatedGuesserButton = findViewById(R.id.updated_guesser);
        updatedGuesserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activytyUpdatedGuesserIntent = new Intent(ctx, UpdatedGuesserActivity.class);
                startActivity(activytyUpdatedGuesserIntent);
            }
        });
    }
}
