package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {

    public static final String EDIT_ITEM_NAME = "edit_item_name";
    private EditText editItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        editItemView = (EditText) findViewById(R.id.etEditItem);
        Intent intent = getIntent();
        String editItemName = intent.getStringExtra(EDIT_ITEM_NAME);
        if(editItemName != null) {
            editItemView.setText(editItemName);
            editItemView.setSelection(editItemName.length());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onEditItem(View v){
        Intent returnIntent = new Intent();
        returnIntent.putExtra(EDIT_ITEM_NAME, editItemView.getText().toString());
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
