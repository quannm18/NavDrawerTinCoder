package com.example.asm_ngominhquan_ph14304.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.asm_ngominhquan_ph14304.entity.Thu;
import com.example.asm_ngominhquan_ph14304.repository.ThuRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class KhoanThuViewModel extends AndroidViewModel {
    private ThuRepository mThuRepository;
    private LiveData<List<Thu>> mAllThu;

    public KhoanThuViewModel(@NonNull @NotNull Application application) {
        super(application);
        mThuRepository = new ThuRepository(application);
        mAllThu = mThuRepository.getAllThu();
    }

    public LiveData<List<Thu>> getAllThu() {
        return mAllThu;
    }

    public void insert(Thu thu){
        mThuRepository.insert(thu);
    }

    public void delete(Thu thu){
        mThuRepository.delete(thu);
    }
    public void update(Thu thu){
        mThuRepository.update(thu);
    }

}