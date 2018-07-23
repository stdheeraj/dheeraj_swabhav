package dheeraj.techlabs.com.loginapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        name = (TextView)findViewById(R.id.name);

        Bundle extras = getIntent().getExtras();
        name.setText(extras.getString("name"));

    }

}
