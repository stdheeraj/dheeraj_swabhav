package tracker.expense.techlabs.com.expensetracker;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
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
    private TextView date;
    private TextView expenseAmount;
    private TextView description;
    private TextView expenseType;

    public class ExpenseDataHolder extends RecyclerView.ViewHolder {
//        public TextView expenseAmount;
//        public TextView expense;
//        public TextView expenseType;
        private ItemTemplateBinding binding;

        public ExpenseDataHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
//            expenseAmount = (TextView) v.findViewById(R.id.expenseAmount);
//            expense =(TextView) v.findViewById(R.id.expense);
//            expenseType =(TextView) v.findViewById(R.id.expenseType);
        }

//        public ItemTemplateBinding getBinding(){
//            return binding;
//        }
    }

    public ExpenseDataAdapter(Activity mainActivity, JSONArray expenseDataset) {
        this.expensesDataset = new JSONArray();
        this.expensesDataset = expenseDataset;
        this.mainActivity = mainActivity;
    }

    @Override
    public ExpenseDataHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        LinearLayout expenseLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_template, parent, false);
        expenseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mainActivity.getApplicationContext(), "Expense data", Toast.LENGTH_LONG);
                date = (TextView)view.findViewById(R.id.expenseDate);
                expenseAmount = (TextView)view.findViewById(R.id.expenseAmount);
                description = (TextView) view.findViewById(R.id.expenseDescription);
                expenseType = (TextView) view.findViewById(R.id.expenseType);

                JSONObject expense = new JSONObject();
                try {
                    expense.put("date", date.getText());
                    expense.put("amount",expenseAmount.getText());
                    expense.put("description",description.getText());
                    expense.put("category", expenseType.getText());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(mainActivity.getApplicationContext(), EditExpenseActivity.class);
                i.putExtra("expense",expense.toString());
                mainActivity.startActivityForResult(i, SAVE_EXPENSE);
            }
        });
        return new ExpenseDataHolder(expenseLayout);
    }

    @Override
    public void onBindViewHolder(ExpenseDataHolder holder, int position) {
        try {
            expense = expensesDataset.getJSONObject(expensesDataset.length()-position-1);

            holder.binding.expenseAmount.setText(expense.getString("amount"));
            holder.binding.expenseDate.setText(expense.getString("date"));
            holder.binding.expenseDescription.setText(expense.getString("description"));
            holder.binding.expenseType.setText(expense.getString("category"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return expensesDataset.length();
    }


}