package tracker.expense.techlabs.com.expensetracker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EditExpenseActivity extends Activity {

    private static final int EDIT_EXPENSE = 2;
    private static final int DELETE_EXPENSE = 3;
    private TextInputEditText date;
    private TextInputEditText amount;
    private TextInputEditText description;
    private TextView dateView;
    private TextView descriptionView;
    private Spinner category;
    private Button saveBtn;
    private Button deleteBtn;
    private Button backBtn;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private List<String> categoryList;
    private ArrayAdapter<String> dataAdapter;
    private int id;
    private JSONObject expense;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_expense);

        date = (TextInputEditText) findViewById(R.id.date);
        amount = (TextInputEditText) findViewById(R.id.amount);
        description = (TextInputEditText) findViewById(R.id.description);
        category = (Spinner) findViewById(R.id.category);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        backBtn = (Button) findViewById(R.id.backBtn);
        dateView = (TextView) findViewById(R.id.dateView);
        descriptionView = (TextView) findViewById(R.id.descriptionView);

        displayExpense();
    }

    private void saveBtnListener() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isValidData(view)) {
                    JSONObject expense = new JSONObject();

                    TextView selectedCategory = (TextView) category.getSelectedView();

                    try {
                        expense.put("date", DateFormat.getDateInstance().format(new Date(date.getText().toString())));
                        expense.put("amount", amount.getText());
                        expense.put("description", description.getText().toString());
                        expense.put("category", selectedCategory.getText().toString());
                        // Log.d("selected",selectedCategory.getText().toString());

                        ExpenseRepository.setExpense(getBaseContext(), id, expense);
                        Intent intent = new Intent();
                        intent.putExtra("ack", "Expense updated successfully.");
                        setResult(EDIT_EXPENSE, intent);
                        finish();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void deleteBtnlistener() {
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExpenseRepository.removeExpense(getBaseContext(), id);
                Intent intent = new Intent();
                intent.putExtra("ack", "Expense deleted successfully.");
                setResult(DELETE_EXPENSE, intent);
                finish();
            }
        });

    }

    private void backBtnListener(){
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(0, new Intent());
                finish();
            }
        });
    }

    private void dateClickListener() {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar = Calendar.getInstance();

                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH);
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(EditExpenseActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, monthOfYear);
                                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
                                //Log.d("date",df.format(calendar.getTime()));
                                date.setText(df.format(calendar.getTime()));
                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, currentYear, currentMonth, currentDay);

                datePickerDialog.show();
            }
        });
    }

    private void addItemOnCategory() {
        categoryList = new ArrayList<String>();
        categoryList.add("Food");
        categoryList.add("Health Care");
        categoryList.add("Emergency Fund");

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoryList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(dataAdapter);

    }

    private void displayExpense() {
        dateClickListener();
        addItemOnCategory();
        saveBtnListener();
        deleteBtnlistener();
        backBtnListener();

        // Bundle extras = getIntent().getExtras();
        id = getIntent().getIntExtra("id", -1);
        //Log.d("id",id+"");

        try {
            expense = ExpenseRepository.getExpense(this, id); //new JSONObject(extras.getString("expense"));
            //Log.d("expense",expense.toString());

            dateView.setText(expense.getString("date"));
            date.setText(expense.getString("date"));
            amount.setText(expense.getString("amount"));
            description.setText(expense.getString("description"));
            descriptionView.setText(expense.getString("description"));
            category.setSelection(dataAdapter.getPosition(expense.getString("category")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidData(View view) {
        if (date.getText().toString().equals("")) {
            showMessage(view, "Date is required");
            return false;
        }
        if (amount.getText().toString().equals("") || Integer.parseInt(amount.getText().toString())<=0) {
            showMessage(view, "Amount is invalid");
            return false;
        }
        if (description.getText().toString().equals("")) {
            showMessage(view, "Description is required");
            return false;
        }
        return true;
    }

    private void showMessage(View view, String message) {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
    }

}
