package com.hfad.rcyclo3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class EstablishmentMainActivity extends Activity {

    public static final String NAME= "name";
    TextView tvHelloUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment_main);

        String name = (String)getIntent().getExtras().get(NAME);
        tvHelloUser = (TextView) findViewById(R.id.helloUser);
        tvHelloUser.setText("BIENVENIDO!! " + name);
    }




}
