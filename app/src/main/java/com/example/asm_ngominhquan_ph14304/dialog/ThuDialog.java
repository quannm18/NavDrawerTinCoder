package com.example.asm_ngominhquan_ph14304.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.asm_ngominhquan_ph14304.R;
import com.example.asm_ngominhquan_ph14304.entity.Thu;
import com.example.asm_ngominhquan_ph14304.ui.thu.KhoanThuFragment;
import com.example.asm_ngominhquan_ph14304.ui.thu.KhoanThuViewModel;
import com.example.asm_ngominhquan_ph14304.ui.thu.ThuFragment;
import com.google.android.material.textfield.TextInputEditText;

public class ThuDialog {
    private KhoanThuViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextInputEditText edtID,edtName,edtNote,edtAmount;
    private Spinner spType;
    private boolean mEditMode;

    public ThuDialog(Context context, KhoanThuFragment fragment, Thu...thu){
        mViewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_thu,null);
        edtID = view.findViewById(R.id.edtID);
        edtName = view.findViewById(R.id.edtName);
        edtAmount = view.findViewById(R.id.edtAmount);
        edtNote = view.findViewById(R.id.edtNote);
        if (thu!=null&& thu.length>0){
            edtID.setText(""+thu[0].tID);
            edtName.setText(thu[0].ten);
            edtAmount.setText(thu[0].sotien+"");
            edtNote.setText(thu[0].ghichu);
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
                        Thu lt = new Thu();
                        lt.ten = edtName.getText().toString();
                        lt.sotien =Float.parseFloat(edtAmount.getText().toString());
                        lt.ghichu = edtNote.getText().toString();
//                        lt.tID = 1; đang lỗi
                        if (mEditMode){
                            lt.tID = Integer.parseInt(edtID.getText().toString());
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
