package com.example.hoangtu.contacts;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by HoangTu on 01/04/2018.
 */

public class DialogAdd extends DialogFragment {

    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_SDT = "KEY_SDT";
    public static final String KEY_SEX = "KEY_SEX";


    public EditText edtTen;
    public EditText edtGioiTinh;
    public EditText edtSdt;
    public Button btnOk;
    public Button btnCancel;
    public ArrayList<Contact> arrData = new ArrayList<>();
    public AdapterContact adapterContact;
    public Contact contact;
    public NoticeDialogListener noticeDialogListener;

    private NoticeDialogListener mListener;

    public interface NoticeDialogListener {
        void onDialogPositiveClick(Contact contact);
    }
    public void setOnPositiveClickListener(NoticeDialogListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_addcontact,null);
        setCancelable(false);
        edtTen = (EditText) view.findViewById(R.id.edtTen);
        edtGioiTinh =(EditText)  view.findViewById(R.id.edtGioitinh);
        edtSdt =(EditText)  view.findViewById(R.id.edtSdt);
        builder.setView(view)
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Contact contact = new Contact();
                        String ten = edtTen.getText().toString();
                        String gioitinh = edtGioiTinh.getText().toString();
                        String sdt = edtSdt.getText().toString();
                        if(ten.isEmpty()|| gioitinh.isEmpty() || sdt.isEmpty()) {
                            Toast.makeText(getActivity(),"điền đầy đủ thông tin",Toast.LENGTH_LONG).show();
                        }
                        else {
                            contact.setHoTen(ten);
                            contact.setGioiTinh(gioitinh);
                            contact.setSdt(sdt);
                            mListener.onDialogPositiveClick(contact);
                        }

                    }
                })
                .setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setTitle("Add Contact")
        ;
        return builder.create();
   }


//    public DialogAdd(Context context) {
//        super(context);
//        setContentView(R.layout.layout_addcontact);
//        initView();
//        setCanceledOnTouchOutside(false);
//
//    }
//
//    private void initView() {
//
//        edtTen = (EditText) findViewById(R.id.edtTen);
//        edtGioiTinh =(EditText)  findViewById(R.id.edtGioitinh);
//        edtSdt =(EditText)  findViewById(R.id.edtSdt);
//        btnOk = findViewById(R.id.btnOk);
//        btnCancel = findViewById(R.id.btnCancel);
//        btnOk.setOnClickListener(this);
//        btnCancel.setOnClickListener(this);
//
//
//
//    }
//
//    @Override
//    public void onClick(View view) {
//        String ten = edtTen.getText().toString();
//        String gioitinh = edtGioiTinh.getText().toString();
//        String sdt = edtSdt.getText().toString();
//       switch(view.getId()){
//
//           case R.id.btnOk:
//               if (ten.isEmpty() || gioitinh.isEmpty() || sdt.isEmpty()){
//                   Toast.makeText(getContext(),"điền thông tin",Toast.LENGTH_LONG).show();
//               }
//
//               else{
//                   Intent intent = new Intent(this,contact);
//
////                   Contact contact = new Contact(ten,gioitinh,sdt);
////                   arrData.add(contact);
////                   adapterContact.notifyDataSetChanged();
//               }
//               break;
//
//           case R.id.btnCancel:
//               dismiss();
//               break;
//
//        }
//
//    }
}
