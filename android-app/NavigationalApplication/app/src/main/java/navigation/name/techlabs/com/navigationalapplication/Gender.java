package navigation.name.techlabs.com.navigationalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Gender extends Activity {

    private static final int SEND_GENDER = 2;
    private Button genderBtn;
    private RadioGroup gender;
    private RadioButton selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_selection_activity);

        // Log.d("act","inside emp data");

        genderBtn = (Button) findViewById(R.id.btnGender);
        gender = (RadioGroup) findViewById(R.id.gender);

        genderBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int selectedId = gender.getCheckedRadioButtonId();
                selectedGender = (RadioButton) findViewById(selectedId);

                Intent intent=new Intent();
                intent.putExtra("Gender",selectedGender.getText());
                setResult(SEND_GENDER,intent);
                finish();

            }

        });


    }

}
