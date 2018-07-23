package tracker.expense.techlabs.com.expensetracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ExpenseRepository {

    //private static SharedPreferences sharedPreferences;
    private static String expensePreferenceKey = "Expenses";

    private ExpenseRepository(){
    }

    private static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(expensePreferenceKey, Context.MODE_PRIVATE);
    }

    private static void setSharedPreferences(Context context, JSONArray expenses){
        getSharedPreferences(context)
                .edit()
                .putString(expensePreferenceKey, expenses.toString())
                .commit();
    }

    public static JSONArray getExpenses(Context context){
        try {
            return new JSONArray(getSharedPreferences(context).getString(expensePreferenceKey, "[]"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    public static void addExpense(Context context, JSONObject expense){
        setSharedPreferences(context, getExpenses(context).put(expense));
        //getExpenses(context).put(expense);
    }

    public static void removeExpense(Context context, int position){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            setSharedPreferences(context, (JSONArray) getExpenses(context).remove(position));
    }

    public static int countExpense(Context context){
        return getExpenses(context).length();
    }

}
