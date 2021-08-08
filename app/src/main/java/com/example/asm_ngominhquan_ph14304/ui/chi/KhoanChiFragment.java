package com.example.asm_ngominhquan_ph14304.ui.chi;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asm_ngominhquan_ph14304.R;

public class KhoanChiFragment extends Fragment {

    private KhoanChiViewModel mViewModel;

    public static KhoanChiFragment newInstance() {
        return new KhoanChiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.khoan_chi_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KhoanChiViewModel.class);
        // TODO: Use the ViewModel
    }

}