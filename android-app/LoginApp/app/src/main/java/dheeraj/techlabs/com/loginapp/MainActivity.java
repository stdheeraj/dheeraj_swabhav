package dheeraj.techlabs.com.loginapp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dheeraj.techlabs.com.loginapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private DisplayVM displayVM;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main );
        displayVM = new DisplayVM(this, binding);

        binding.setVm(displayVM);

    }
}
