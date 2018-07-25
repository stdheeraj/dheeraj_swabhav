package tracker.expense.techlabs.com.expensetracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ExpenseRepository {

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

    public static JSONObject getExpense(Context context, int id){
        try {
            return getExpenses(context).getJSONObject(id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addExpense(Context context, JSONObject expense){
        setSharedPreferences(context, getExpenses(context).put(expense));
    }

    public static void setExpense(Context context, int id, JSONObject expense){
        try {
            setSharedPreferences(context, getExpenses(context).put(id,expense));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void removeExpense(Context context, int position){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            JSONArray expenses = getExpenses(context);
            expenses.remove(position);
            setSharedPreferences(context, expenses);
        }

    }

}
