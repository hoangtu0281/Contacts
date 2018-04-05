package com.example.hoangtu.contacts;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogAdd.NoticeDialogListener {

    private static final int REQUEST_KEY_ADD = 1;
    private static final int REQUEST_KEY_EDIT = 2;

    public static final int REQUEST_RIGSTER = 1;

    private FloatingActionButton btnFloatAction;
    private ListView lvList;
    private ArrayList<Contact> arrContacts = new ArrayList<>();
    private AdapterContact adapterContact;
    private DialogAdd dialog;
    private Contact contact;
    private DBMaganer dbMaganer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbMaganer = new DBMaganer(MainActivity.this);
        initView();
        //initDatas();
    }

    private void initView() {
        lvList = findViewById(R.id.lvList);
        adapterContact = new AdapterContact(this,arrContacts);
        lvList.setAdapter(adapterContact);
        btnFloatAction = (FloatingActionButton) findViewById(R.id.btnFloatAction);
       // btnFloatAction.setOnClickListener(this);
        btnFloatAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAdd addContact = new DialogAdd();
                addContact.setOnPositiveClickListener(MainActivity.this);
                addContact.show(getFragmentManager(),"Add dialog");
                                              // dialog = new DialogAdd(this);

                                          }
        });


  }
//    private void initDatas() {
//        arrContacts.add(new Contact("Hoàng Văn Tú","nam","0979667588"));
//        arrContacts.add(new Contact("Hoàng Văn Tú","nam","0979667588"));
//        arrContacts.add(new Contact("Hoàng Văn Tú","nam","0979667588"));
//    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.btnFloatAction:
//                dialog = new DialogAdd(this);
//                dialog.show();
//        }
//    }


    @Override
    public void onDialogPositiveClick(Contact contact) {
        if(arrContacts.isEmpty()) {
            contact.setId(1);
            arrContacts.add(contact);
        } else {
            contact.setId(arrContacts.get(0).getId()+1);
            arrContacts.add(0,contact);
        }
        dbMaganer.addContact(contact);
        lvList.smoothScrollToPosition(0);
        adapterContact.notifyDataSetChanged();

    }

}
