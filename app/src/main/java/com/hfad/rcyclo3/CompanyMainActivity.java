package com.hfad.rcyclo3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class CompanyMainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);
    }

    public void request(View view){
        Intent intent = new Intent(this, SelectWasteActivity.class);
        startActivity(intent);

    }

}
