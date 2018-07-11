package navigation.name.techlabs.com.navigationalapplication;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_CONTACT = 1;
    private static final int PICK_GENDER = 2;
    private Button empBtn;
    private Button genderBtn;
    private Button contactBtn;
    private TextView gender;
    private TextView contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empBtn = (Button) this.findViewById(R.id.empDataButton);
        genderBtn = (Button) this.findViewById(R.id.genderButton);
        contactBtn = (Button) this.findViewById(R.id.contactButton);
        gender = (TextView) this.findViewById(R.id.genderView);
        contact = (TextView) this.findViewById(R.id.contact);

        empBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EmployeeDataActivity.class);
                i.putExtra("id", 100);
                i.putExtra("name", "Dheeraj");
                startActivity(i);
            }
        });

        genderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, Gender.class);
                startActivityForResult(i, PICK_GENDER);
            }
        });

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i)
    {
        super.onActivityResult(requestCode, resultCode, i);

        if(requestCode==PICK_GENDER) {
            String g=i.getStringExtra("Gender");
            gender.setText("Selected Gender : "+g);
        }

        if (requestCode == PICK_CONTACT) {
            if (resultCode == RESULT_OK) {

                Uri contactData = i.getData();
                String number = "";
                String name = "";

                Cursor cursor = getContentResolver().query(contactData, null, null, null, null);
                cursor.moveToFirst();

                String hasPhone = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                String contactId = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                if (hasPhone.equals("1")) {
                    Cursor phones = getContentResolver().query
                            (ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                            + " = " + contactId, null, null);
                    while (phones.moveToNext()) {
                        number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replaceAll("[-() ]", "");
                        name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                    }

                    phones.close();

                    contact.setText("Selected Contact : "+name+" ("+number+")");

                } else {
                    Toast.makeText(getApplicationContext(), "This contact has no phone number", Toast.LENGTH_LONG).show();
                }
                cursor.close();
            }
        }
    }

}
