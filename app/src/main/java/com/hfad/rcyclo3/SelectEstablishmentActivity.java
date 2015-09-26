package com.hfad.rcyclo3;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SelectEstablishmentActivity extends ListActivity {
    private SQLiteDatabase db;
    private Cursor cursor;
    public static final String WASTE= "waste";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listEstablishment = getListView();

        String waste = (String)getIntent().getExtras().get(WASTE);

        SQLiteOpenHelper rcycloDatabaseHelper = new RcycloDatabaseHelper(this);
        db = rcycloDatabaseHelper.getReadableDatabase();
        cursor = db.query("ESTABLISHMENT", new String[]{"NAME", "WASTE"}, "WASTE = ? ", new String[]{waste}, null, null, null);

        CursorAdapter listAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1, cursor, new String[]{"NAME"}, new int[]{android.R.id.text1},0);
        listEstablishment.setAdapter(listAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        Intent intent = new Intent(SelectEstablishmentActivity.this, SelectCoordinatesActivity.class);
 //       intent.putExtra(DrinkActivity.EXTRA_DRINKNO, (int) id);
        startActivity(intent);
    }
}
