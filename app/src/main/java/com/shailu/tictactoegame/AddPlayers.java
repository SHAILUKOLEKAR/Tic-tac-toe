package com.shailu.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText playerOne = findViewById(R.id.playerOneName);
        final EditText playerTwo = findViewById(R.id.playerTwoName);
        final Button startGameBtn = findViewById(R.id.startGameBtn);

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getPlayerOneName = playerOne.getText().toString();
                final String getPlayerTwoName = playerTwo.getText().toString();

                if (getPlayerOneName.isEmpty())
                {
                    playerOne.requestFocus();
                    playerOne.setError("Enter name");
                }
                if(getPlayerTwoName.isEmpty()){
                    playerTwo.requestFocus();
                    playerTwo.setError("Enter name");
                }
                if((!getPlayerOneName.isEmpty()) && (!getPlayerTwoName.isEmpty())) {
                    Intent mainActIntent = new Intent(AddPlayers.this, MainActivity.class);
                    mainActIntent.putExtra("playerOne", getPlayerOneName);
                    mainActIntent.putExtra("playerTwo", getPlayerTwoName);
                    startActivity(mainActIntent);
                }
            }
        });
    }
}