package com.example.asm_ngominhquan_ph14304.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.asm_ngominhquan_ph14304.R;
import com.example.asm_ngominhquan_ph14304.entity.LoaiThu;
import com.example.asm_ngominhquan_ph14304.ui.thu.LoaiThuFragment;
import com.example.asm_ngominhquan_ph14304.ui.thu.LoaiThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiThuDialog {
    private LoaiThuViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextInputEditText edtID,edtName;
    private boolean mEditMode;

    public LoaiThuDialog(Context context, LoaiThuFragment fragment, LoaiThu...loaiThu){
        mViewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_loai_thu,null);
        edtID = view.findViewById(R.id.edtID);
        edtName = view.findViewById(R.id.edtName);

        if (loaiThu!=null&& loaiThu.length>0){
            edtID.setText(""+loaiThu[0].ltID);
            edtName.setText(loaiThu[0].ten);
            mEditMode = true;
        }
        else {
            mEditMode = false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Dong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Luu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoaiThu lt = new LoaiThu();
                        lt.ten = edtName.getText().toString();
                        if (mEditMode){
                            lt.ltID = Integer.parseInt(edtID.getText().toString());
                            mViewModel.update(lt);
                        }else {
                            mViewModel.insert(lt);
                            Toast.makeText(context, "Loai thu duoc luu!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
        mDialog = builder.create();
    }
    public void show(){
        mDialog.show();
    }
}
