package com.example.asm_ngominhquan_ph14304.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.asm_ngominhquan_ph14304.ui.thu.KhoanThuFragment;
import com.example.asm_ngominhquan_ph14304.ui.thu.LoaiThuFragment;

import org.jetbrains.annotations.NotNull;

public class ThuViewPager2Adapter extends FragmentStateAdapter {
    public ThuViewPager2Adapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if (position==0){
            fragment = KhoanThuFragment.newInstance();
        }
        else {
            fragment = LoaiThuFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
