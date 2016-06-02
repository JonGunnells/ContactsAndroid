package com.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<Contact> items;

    ListView list;
    EditText name;
    EditText phone;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = (ListView) findViewById(R.id.list);
        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.phone);
        addButton = (Button) findViewById(R.id.button);

        items = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);


        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String phoneString = phone.getText().toString();
        String nameString = name.getText().toString();
        Contact contact = new Contact(nameString, phoneString);
        items.add(contact);
        phone.setText("");
        name.setText("");

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
         Contact contact = items.getItem(position);
        items.remove(contact);
        return true;
    }
}