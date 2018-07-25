package tracker.expense.techlabs.com.expensetracker;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import tracker.expense.techlabs.com.expensetracker.databinding.ItemTemplateBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpenseDataAdapter extends RecyclerView.Adapter<ExpenseDataAdapter.ExpenseDataHolder> {

    private static final int SAVE_EXPENSE = 2;
    private JSONArray expensesDataset;
    private JSONObject expense;
    private Activity mainActivity;
    //private int id;

    public class ExpenseDataHolder extends RecyclerView.ViewHolder {
        private ItemTemplateBinding binding;

        public ExpenseDataHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }
    }

    public ExpenseDataAdapter(Activity mainActivity) {
        this.expensesDataset = ExpenseRepository.getExpenses(mainActivity.getApplicationContext());
        this.mainActivity = mainActivity;
    }

    @Override
    public ExpenseDataHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        LinearLayout expenseLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_template, parent, false);
        return new ExpenseDataHolder(expenseLayout);
    }

    @Override
    public void onBindViewHolder(ExpenseDataHolder holder, final int position) {
        try {
            //id = position;
            expense = expensesDataset.getJSONObject(position);

            holder.binding.expenseAmount.setText(expense.getString("amount"));
            holder.binding.expenseDate.setText(expense.getString("date"));
            holder.binding.expenseDescription.setText(expense.getString("description"));
            holder.binding.expenseType.setText(expense.getString("category"));

            holder.binding.expenseItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(mainActivity.getApplicationContext(), EditExpenseActivity.class);
                    //Log.d("ex id",id+"");
                    i.putExtra("id", position);
                    mainActivity.startActivityForResult(i, SAVE_EXPENSE);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return expensesDataset.length();
    }

    public void updateExpenses(){
        this.expensesDataset = ExpenseRepository.getExpenses(mainActivity.getApplicationContext());
    }

}