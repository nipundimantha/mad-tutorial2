package com.madtutorial2.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * The First Activity program implements an application that
 * simply displays and get to numbers as inputs and send it to the second Activity.
 *
 * @author  Dimantha H.V.N
 * @version 1.0
 * @since   2020-03-19
 */

public class FirstActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Log.i("Lifecycle", "OnCreate() Invoked");

        final EditText fno1 = (EditText)findViewById(R.id.editTextno1);
        final EditText fno2 = (EditText)findViewById(R.id.editTextno2);

        button = (Button) findViewById(R.id.btnok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String num1 = fno1.getText().toString();
                String num2 = fno2.getText().toString();

                if (num1.equals("") || num2.equals("")){
                    validate();
                }else{

                    displayToast();
//                    Intent intent = new Intent(FirstActivity.this, MainActivity.class);
//                    Context context = getApplicationContext();
//
//                    CharSequence message = "You just clicked the OK button";
//                    int duration = Toast.LENGTH_SHORT;
//
//                    Toast toast = Toast.makeText(context, message, duration);
//                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 25);
//
//                    toast.show();
                    openSecondActivity();

                }
            }
        });
    }

    public void openSecondActivity(){
        final EditText fno1 = (EditText)findViewById(R.id.editTextno1);
        final EditText fno2 = (EditText)findViewById(R.id.editTextno2);

        String number1 = fno1.getText().toString();
        String number2 = fno2.getText().toString();

        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);

        intent.putExtra("number1",fno1.getText().toString());
        intent.putExtra("number2",fno2.getText().toString());

        startActivity(intent);
        finish();
    }

    //Creating the custom toast instead of the default toast
    private void displayToast(){

        //Creating the LayoutInflater instance
        LayoutInflater li = getLayoutInflater();

        //Getting the View object as defined in the custom_toast.xml file
        View layout = li.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));

        //Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 70);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();


    }

    //Creating the custom toast validation
    private void validate(){

        //Creating the LayoutInflater instance
        LayoutInflater li = getLayoutInflater();

        //Getting the View object as defined in the custom_toast.xml file
        View layout = li.inflate(R.layout.custom_validate, (ViewGroup) findViewById(R.id.custom_toast_layout));

        //Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 70);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();
    }

    public void onStart() {
        super.onStart();
        Log.i("Lifecycle", "OnStart() invoked");
    }

    public void onRestart() {
        super.onRestart();
        Log.i("Lifecycle", "OnRestart() invoked");
    }

    public void onResume() {
        super.onResume();
        Log.i("Lifecycle", "OnResume() invoked");
    }
}
