package view.recycler.techlabs.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] names;
    private int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.namesRecyclerView);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        names = new String[]{"dheeraj", "sarvesh", "prasad", "Kartik", "Vipul", "pratik"};
        mAdapter = new DataAdapter(names);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void changeName(View v){
        if(i<names.length){
        names[i] += i;
        i++;
        //mAdapter = new DataAdapter(names);
        mRecyclerView.setAdapter(mAdapter);}
    }
}
