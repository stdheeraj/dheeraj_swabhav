package dheeraj.techlabs.com.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import dheeraj.techlabs.com.loginapp.databinding.ActivityMainBinding;

public class DisplayVM extends BaseObservable {

    private String userName;
    private String password;
    private Activity activity;
    private ActivityMainBinding binding;

    public DisplayVM(Activity activity, ActivityMainBinding binding){
        this.activity = activity;
        this.binding = binding;
    }


    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(dheeraj.techlabs.com.loginapp.BR.userName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(dheeraj.techlabs.com.loginapp.BR.password);
    }

    public void login(View v){
        Intent intent = new Intent(activity.getApplicationContext(),WelcomeActivity.class );
        intent.putExtra("name",binding.userName.getText().toString());
        activity.startActivity(intent);
    }
}
