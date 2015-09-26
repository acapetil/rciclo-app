package com.hfad.rcyclo3;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EstablishmentRegisterActivity extends Activity {

    EditText etName, etEmail, etPassword,etPhone, etAddress;
    RadioGroup rgWaste;
    RadioButton rbWaste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment_register);
        etName      = (EditText) findViewById(R.id.name);
        etEmail     = (EditText) findViewById(R.id.email);
        etPassword  = (EditText) findViewById(R.id.password);
        etPhone     = (EditText) findViewById(R.id.phone);
        etAddress   = (EditText) findViewById(R.id.address);
      //rgWaste     = (RadioGroup) findViewById(R.id.waste);
        int entero = rgWaste.getCheckedRadioButtonId();
        rbWaste = (RadioButton) findViewById(entero);
    }


    public void sendForm(View view){
        String name     = etName.getText().toString();
        String email    = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String phone    = etPhone.getText().toString();
        String address  = etAddress.getText().toString();
        String waste    = rbWaste.getText().toString();



        if (isEmailValid(email)) {
            ContentValues establishmentValues = new ContentValues();
            establishmentValues.put("NAME", name);
            establishmentValues.put("EMAIL", email);
            establishmentValues.put("PASSWORD", password);
            establishmentValues.put("PHONE", phone);
            establishmentValues.put("ADDRESS", address);
            establishmentValues.put("WASTE", "papel");

            SQLiteOpenHelper rcycloDatabaseHelper = new RcycloDatabaseHelper(this);
            SQLiteDatabase db = rcycloDatabaseHelper.getWritableDatabase();
            db.insert("ESTABLISHMENT", null, establishmentValues);
            db.close();
            Toast toast = Toast.makeText(this, "Fundacion Registrada!", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(this, EstablishmentLoginActivity.class);
            startActivity(intent);
        }

        else {Toast toast = Toast.makeText(this, "El mail debe ser valido!!", Toast.LENGTH_SHORT);
            toast.show();
            etEmail.setText("");
        }
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }


}
