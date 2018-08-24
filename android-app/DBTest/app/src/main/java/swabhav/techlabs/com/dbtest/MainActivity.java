package swabhav.techlabs.com.dbtest;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        Toast.makeText(getApplicationContext(), db.userDao().getAll().toString(), Toast.LENGTH_LONG).show();
        Log.d("user",db.userDao().getAll().toString());
        //db.userDao().getAll();
    }
}
