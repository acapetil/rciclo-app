package com.hfad.rcyclo3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EstablishmentLoginActivity extends Activity {

    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment_login);

        etEmail = (EditText) findViewById(R.id.email);
        etPassword = (EditText) findViewById(R.id.password);
    }

    public void enter(View view){
        String email    = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        SQLiteOpenHelper rcycloDatabaseHelper = new RcycloDatabaseHelper(this);
        SQLiteDatabase db = rcycloDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("ESTABLISHMENT", new String[]{"NAME", "EMAIL", "PASSWORD", "PHONE", "ADDRESS"}, "EMAIL = ? AND PASSWORD = ?", new String[]{email, password}, null, null, null);

        if (cursor.moveToFirst()) {
            String name = cursor.getString(0);
            cursor.close();
            db.close();
            Toast toast = Toast.makeText(this, "Bienvenido a Rcyclo "+name+"!", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(this, EstablishmentMainActivity.class);
            intent.putExtra(EstablishmentMainActivity.NAME, name);
            startActivity(intent);
        }

        else {
            mensaje_invalido();
        }
    }

    public void register(View view){
        Intent intent = new Intent(this, EstablishmentRegisterActivity.class);
        startActivity(intent);
    }

    public void mensaje_invalido() {

        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage("El usuario ingresado no esta registrado");
        dlgAlert.setTitle("Uusario invalido");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }


}
