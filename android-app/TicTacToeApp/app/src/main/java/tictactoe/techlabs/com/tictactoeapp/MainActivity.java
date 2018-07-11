package tictactoe.techlabs.com.tictactoeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText player1;
    private EditText player2;
    private RadioGroup mark;
    private RadioButton selectedMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playGame(View v) {
        JSONObject playerInput = new JSONObject();

        player1 = (EditText) findViewById(R.id.player1Id);
        player2 = (EditText) findViewById(R.id.player2Id);
        mark = (RadioGroup) findViewById(R.id.markId);
        selectedMark = (RadioButton) findViewById(mark.getCheckedRadioButtonId());


        try {
            playerInput.put("player1", player1.getText().toString());
            playerInput.put("player2", player2.getText().toString());
            playerInput.put("mark", selectedMark.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Intent i = new Intent(getApplicationContext(), GameActivity.class);
        i.putExtra("playerInput", playerInput.toString());
        startActivity(i);
    }
}
