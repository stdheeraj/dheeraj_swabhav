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
import android.widget.Toast;

import tracker.expense.techlabs.com.expensetracker.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private static final int ADD_EXPENSE = 1;
    private ExpenseDataAdapter expenseAdapter;
    private LinearLayoutManager expenseLayoutManager;
    private Toolbar toolbar;
    private ActivityMainBinding binding;

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

        expenseAdapter = new ExpenseDataAdapter(this);
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
        if(resultCode != 0) {
            expenseAdapter.updateExpenses();
            expenseAdapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), i.getStringExtra("ack"), Toast.LENGTH_SHORT).show();
        }
    }

}
