package com.example.asm_ngominhquan_ph14304.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LoaiThu {
    @PrimaryKey(autoGenerate = true)
    public int ltID;
    @ColumnInfo(name = "ten")
    public String ten;
}
