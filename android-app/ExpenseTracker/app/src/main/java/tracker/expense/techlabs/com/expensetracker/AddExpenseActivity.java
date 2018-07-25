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

public class AddExpenseActivity extends Activity {
    private static final int SEND_EXPENSE = 1;
    private TextInputEditText date;
    private TextInputEditText amount;
    private TextInputEditText description;
    private Spinner category;
    private Button addBtn;
    private Button backBtn;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private List<String> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        date = (TextInputEditText) findViewById(R.id.date);
        amount = (TextInputEditText) findViewById(R.id.amount);
        description = (TextInputEditText) findViewById(R.id.description);
        category = (Spinner) findViewById(R.id.category);
        addBtn = (Button) findViewById(R.id.addBtn);
        backBtn = (Button) findViewById(R.id.backBtn);

        dateClickListener();
        addItemOnCategory();
        addBtnListener();
        backBtnListener();

    }

    private void addBtnListener() {
        addBtn.setOnClickListener(new View.OnClickListener() {
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

                        ExpenseRepository.addExpense(getBaseContext(), expense);
                        Intent intent = new Intent();
                        intent.putExtra("ack", "Expense added successfully.");
                        setResult(SEND_EXPENSE, intent);
                        finish();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
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

                datePickerDialog = new DatePickerDialog(AddExpenseActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, monthOfYear);
                                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
                                //Log.d("date",df.format(calendar.getTime()));
                                date.setText(df.format(calendar.getTime()));
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

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoryList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(dataAdapter);

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
