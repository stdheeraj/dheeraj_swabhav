package api.number.techlabs.com.numberapiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView factsRecycler;
    private RecyclerView.Adapter factsAdapter;
    private RecyclerView.LayoutManager factsLayoutManager;

    private TextView responseDisplay;
    private EditText inputNumber;
    private TextView students;
    private List<String> facts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        factsRecycler = (RecyclerView) findViewById(R.id.recyclerView);
        factsRecycler.setHasFixedSize(true);

        factsLayoutManager = new LinearLayoutManager(this);
        factsRecycler.setLayoutManager(factsLayoutManager);

        inputNumber = (EditText) findViewById(R.id.inputNumber);
        students = (TextView)findViewById(R.id.students);

        facts = new ArrayList<String>();

        factsAdapter = new DataAdapter(facts);
        factsRecycler.setAdapter(factsAdapter);

    }

    public void getStudents(View v){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://sheltered-savannah-49777.herokuapp.com/students";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        students.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error while getting number fact.", Toast.LENGTH_SHORT);
            }
        });
        queue.add(stringRequest);
    }

    public void getNumberAPIResponse(View v){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://numbersapi.com/"+inputNumber.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        facts.add(response);
                        factsAdapter = new DataAdapter(facts);
                        factsRecycler.setAdapter(factsAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error while getting number fact.", Toast.LENGTH_SHORT);
            }
        });
        queue.add(stringRequest);

    }
}
