package navigation.name.techlabs.com.navigationalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class EmployeeDataActivity extends Activity {

    private TextView empId;
    private TextView empName;
    private int id;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_data_activity);

       // Log.d("act","inside emp data");

        empId = (TextView) findViewById(R.id.empId1);
        empName = (TextView) findViewById(R.id.name1);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        id =  extras.getInt("id");
        name = extras.getString("name");

        if (name != null) {
            //Log.d("act","inside emp data");
            empId.setText(id+"");
            empName.setText(name);
        }

    }
}
