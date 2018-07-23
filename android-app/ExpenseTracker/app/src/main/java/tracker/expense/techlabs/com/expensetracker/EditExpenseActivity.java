package tracker.expense.techlabs.com.expensetracker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EditExpenseActivity extends Activity {

    private static final int SEND_EXPENSE = 2;
    private TextInputEditText date;
    private TextInputEditText amount;
    private TextInputEditText description;
    private TextView dateView;
    private Spinner category;
    private Button saveBtn;
    private DatePickerDialog datePickerDialog;
    private Calendar c;
    private List<String> categoryList;
    private ArrayAdapter<String> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_expense);

        date = (TextInputEditText) findViewById(R.id.date);
        amount = (TextInputEditText) findViewById(R.id.amount);
        description = (TextInputEditText) findViewById(R.id.description);
        category = (Spinner) findViewById(R.id.category);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        dateView = (TextView) findViewById(R.id.dateView);

        displayExpense();
    }

    private void saveBtnListener() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JSONObject expense = new JSONObject();

                TextView selectedCategory = (TextView)category.getSelectedView();

                try {
                    expense.put("date", DateFormat.getDateInstance().format(new Date(date.getText().toString())));
                    expense.put("amount", amount.getText());
                    expense.put("description", description.getText().toString());
                    expense.put("category", selectedCategory.getText().toString());
                    // Log.d("selected",selectedCategory.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent intent=new Intent();
                intent.putExtra("expense",expense.toString());
                setResult(SEND_EXPENSE,intent);
                finish();

            }
        });
    }

    private void dateClickListener(){
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c = Calendar.getInstance();

                int currentYear = c.get(Calendar.YEAR);
                int currentMonth = c.get(Calendar.MONTH);
                int currentDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(EditExpenseActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
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

    private void displayExpense(){
        dateClickListener();
        addItemOnCategory();
        saveBtnListener();

        Bundle extras = getIntent().getExtras();
        try {
            JSONObject expense = new JSONObject(extras.getString("expense"));
            dateView.setText(expense.getString("date"));
            date.setText(expense.getString("date"));
            amount.setText(expense.getString("amount"));
            description.setText(expense.getString("description"));
            category.setSelection(dataAdapter.getPosition(expense.getString("category")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

//    private TextInputEditText date;
//    private TextInputEditText amount;
//    private TextInputEditText description;
//    private Spinner category;
//    private DatePickerDialog datePickerDialog;
//    private Calendar c;
//    private List<String> categoryList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_expense);
//
//        date = (TextInputEditText) findViewById(R.id.date);
//        amount = (TextInputEditText) findViewById(R.id.amount);
//        description = (TextInputEditText) findViewById(R.id.description);
//        category = (Spinner) findViewById(R.id.category);
//
//        date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                c = Calendar.getInstance();
//
//                int currentYear = c.get(Calendar.YEAR);
//                int currentMonth = c.get(Calendar.MONTH);
//                int currentDay = c.get(Calendar.DAY_OF_MONTH);
//
//                datePickerDialog = new DatePickerDialog(EditExpenseActivity.this,
//                        new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
//                            }
//                        }, currentYear, currentMonth, currentDay);
//
//                datePickerDialog.show();
//            }
//        });
//
//        addItemOnCategory();
//    }
//
//    private void addItemOnCategory() {
//        categoryList = new ArrayList<String>();
//        categoryList.add("Food");
//        categoryList.add("Health Care");
//        categoryList.add("Emergency Fund");
//
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoryList);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        category.setAdapter(dataAdapter);
//
//    }

}
