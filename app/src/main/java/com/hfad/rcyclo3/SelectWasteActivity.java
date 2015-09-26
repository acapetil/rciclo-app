package com.hfad.rcyclo3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class SelectWasteActivity extends Activity implements View.OnClickListener{

    public String waste;
    ImageButton paper, plastic, glass, tin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_waste);
        paper   = (ImageButton) findViewById(R.id.paper);
        plastic = (ImageButton) findViewById(R.id.plastic);
        glass   = (ImageButton) findViewById(R.id.glass);
        tin     = (ImageButton) findViewById(R.id.tin);

        paper.setOnClickListener(this);
        plastic.setOnClickListener(this);
        glass.setOnClickListener(this);
        tin.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.paper:
                waste = "paper";
                Intent intent1 = new Intent(this, SelectCoordinatesActivity.class);
                intent1.putExtra(SelectCoordinatesActivity.WASTE, waste);
                startActivity(intent1);
                break;

            case R.id.plastic:
                waste = "plastic";
                Intent intent2 = new Intent(this, SelectCoordinatesActivity.class);
                intent2.putExtra(SelectCoordinatesActivity.WASTE, waste);
                startActivity(intent2);
                break;

            case R.id.glass:
                waste = "glass";
                Intent intent3 = new Intent(this, SelectCoordinatesActivity.class);
                intent3.putExtra(SelectCoordinatesActivity.WASTE, waste);
                startActivity(intent3);
                break;

            case R.id.tin:
                waste = "tin";
                Intent intent4 = new Intent(this, SelectCoordinatesActivity.class);
                intent4.putExtra(SelectCoordinatesActivity.WASTE, waste);
                startActivity(intent4);

                break;
        }
    }
}
/*public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegisterEmpresa:
                startActivity(new Intent(this, FormularioEmpresa.class));
                break;

            case R.id.bLoginEmpresa:
                startActivity(new Intent(this, MenuEmpresa.class));
                break;
        }
    }*/