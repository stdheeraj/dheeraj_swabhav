package api.number.techlabs.com.numberapiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private TextView responseDisplay;
    private EditText inputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseDisplay = (TextView) findViewById(R.id.response);
        inputNumber = (EditText) findViewById(R.id.inputNumber);
    }

    public void getNumberAPIResponse(View v){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://numbersapi.com/"+inputNumber.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseDisplay.setText('"'+response+'"');
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseDisplay.setText("Error : "+error.getMessage());
            }
        });
        queue.add(stringRequest);

    }
}
