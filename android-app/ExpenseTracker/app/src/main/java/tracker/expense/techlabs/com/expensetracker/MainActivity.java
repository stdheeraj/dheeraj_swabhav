package tracker.expense.techlabs.com.expensetracker;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tracker.expense.techlabs.com.expensetracker.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private static final int ADD_EXPENSE = 1;
    private static final int SAVE_EXPENSE = 2;
    private RecyclerView.Adapter expenseAdapter;
    private LinearLayoutManager expenseLayoutManager;
    private Toolbar toolbar;
    private ActivityMainBinding binding;
//    private JSONArray expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding.expenseRecycler.setHasFixedSize(true);
        binding.expenseRecycler.setHasFixedSize(true);
        expenseLayoutManager = new LinearLayoutManager(this);
        binding.expenseRecycler.setLayoutManager(expenseLayoutManager);

        DividerItemDecoration itemDecor = new DividerItemDecoration(binding.expenseRecycler.getContext(), expenseLayoutManager.getOrientation());
        binding.expenseRecycler.addItemDecoration(itemDecor);

        expenseAdapter = new ExpenseDataAdapter(this, ExpenseRepository.getExpenses(getApplicationContext()));
        binding.expenseRecycler.setAdapter(expenseAdapter);

        binding.addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddExpenseActivity.class);
                startActivityForResult(i, ADD_EXPENSE);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);

        JSONObject expense = null;

        if(resultCode== ADD_EXPENSE) {
            try {
                expense = new JSONObject(i.getStringExtra("expense"));
                ExpenseRepository.addExpense(getApplicationContext(),expense);
                expenseAdapter.notifyDataSetChanged();
                //expenses.put(expense);
//                expenseAdapter = new ExpenseDataAdapter(this, ExpenseRepository.getExpenses(getApplicationContext()));
//                binding.expenseRecycler.setAdapter(expenseAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if(resultCode== SAVE_EXPENSE) {
            try {
                expense = new JSONObject(i.getStringExtra("expense"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //expenses.remove(expense.get(""))
            //expenses.put(expense);
            binding.expenseRecycler.setAdapter(expenseAdapter);
        }

    }



}
