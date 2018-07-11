package com.example.neer.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeNote;
    private EditText inputName;
    private Button button;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        welcomeNote = (TextView) this.findViewById(R.id.welcomeNote);
        inputName = (EditText) this.findViewById(R.id.inputName);
        button = (Button) this.findViewById(R.id.hello_button);
        logo = (ImageView) this.findViewById(R.id.logo);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Log.d("bmsg","button clicked");
                welcomeNote.setText("Welcome "+inputName.getText().toString());
                welcomeNote.setVisibility(View.VISIBLE);
            }
        });


        logo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Log.d("lmsg","logo clicked");
                Toast.makeText(getApplicationContext(), "Swabhav techlabs",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
