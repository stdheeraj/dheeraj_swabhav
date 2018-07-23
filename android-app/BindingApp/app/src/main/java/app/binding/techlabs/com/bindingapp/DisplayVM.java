package app.binding.techlabs.com.bindingapp;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

public class DisplayVM extends BaseObservable {

    private String firstName;
    private String lastName;
    private String address;

    public DisplayVM(){
        this.firstName = "Dheeraj";
        this.lastName = "Chaurasia";
        this.address = "Mumbai";
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    public void changeName(View v){
        this.setFirstName("Santosh");
    }
}
