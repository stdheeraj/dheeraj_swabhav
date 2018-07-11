package matcher.name.techlabs.com.namematcher;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int FNAME_PICK_CONTACT = 1;
    private static final int SNAME_PICK_CONTACT = 2;
    private TextView fName;
    private TextView sName;
    private EditText fNameInput;
    private EditText sNameInput;
    private TextView percentageMatch;
    private ImageView fNameContact;
    private ImageView sNameContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        fName = (TextView) this.findViewById(R.id.f_name);
        sName = (TextView) this.findViewById(R.id.s_name);
        percentageMatch = (TextView) this.findViewById(R.id.match_percentage);

        fNameContact = (ImageView) this.findViewById(R.id.fNameContact);
        sNameContact = (ImageView) this.findViewById(R.id.sNameContact);

        fNameInput = (EditText) this.findViewById(R.id.first_name);
        sNameInput = (EditText) this.findViewById(R.id.second_name);


        percentageMatch.setText("0%");

        fNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fName.setText(s.toString());
                Log.d("per1",(Math.abs(s.toString().compareToIgnoreCase(sName.getText().toString()))+100)%101+"%");
                percentageMatch.setText((Math.abs(s.toString().compareToIgnoreCase(sName.getText().toString()))+100)%101+"%");
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                Log.d("per2",(Math.abs(s.toString().compareToIgnoreCase(sName.getText().toString()))+100)%101+"%");
            }
        });

        sNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sName.setText(s.toString());
                Log.d("per1s",(Math.abs(fName.getText().toString().compareToIgnoreCase(s.toString()))+100)%101+"%");
                percentageMatch.setText((Math.abs(fName.getText().toString().compareToIgnoreCase(s.toString()))+100)%101+"%");
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                Log.d("per2s",(Math.abs(fName.getText().toString().compareToIgnoreCase(s.toString()))+100)%101+"%");

            }
        });

        fNameContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, FNAME_PICK_CONTACT);
            }
        });

        sNameContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, SNAME_PICK_CONTACT);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);

        if (requestCode == FNAME_PICK_CONTACT && resultCode == RESULT_OK) {
                Uri contactData = i.getData();
                Cursor cursor = getContentResolver().query(contactData, null, null, null, null);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                fNameInput.setText(name+"");
                cursor.close();
        }

        if (requestCode == SNAME_PICK_CONTACT && resultCode == RESULT_OK) {
                Uri contactData = i.getData();
                Cursor cursor = getContentResolver().query(contactData, null, null, null, null);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                sNameInput.setText(name+"");
                cursor.close();
        }
    }
}
