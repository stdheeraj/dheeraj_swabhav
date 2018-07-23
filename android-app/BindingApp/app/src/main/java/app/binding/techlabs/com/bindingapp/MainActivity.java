package app.binding.techlabs.com.bindingapp;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.binding.techlabs.com.bindingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //private Button changeName;
    private ActivityMainBinding binding;
    private DisplayVM displayVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        displayVM = new DisplayVM();
        binding.setVm(displayVM);

//        changeName = (Button) binding.changeName;
//
//        changeName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                displayVM.setFirstName("Sarvesh");
//            }
//        });



    }
}
