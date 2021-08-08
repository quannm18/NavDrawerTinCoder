package com.example.asm_ngominhquan_ph14304.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asm_ngominhquan_ph14304.R;
import com.example.asm_ngominhquan_ph14304.entity.LoaiThu;
import com.example.asm_ngominhquan_ph14304.ui.thu.LoaiThuFragment;
import com.example.asm_ngominhquan_ph14304.ui.thu.LoaiThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiThuDetailDialog {
    private LoaiThuViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextView tvIDShow, tvNameShow;

    public LoaiThuDetailDialog(Context context, LoaiThuFragment fragment, LoaiThu loaiThu){
        mViewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_detail_loai_thu,null);
        tvIDShow = view.findViewById(R.id.tvIDShow);
        tvNameShow = view.findViewById(R.id.tvNameShow);
        tvIDShow.setText(loaiThu.ltID+"");
        tvNameShow.setText(loaiThu.ten);
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Dong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        mDialog = builder.create();
    }
    public void show(){
        mDialog.show();
    }
}
