package com.example.asm_ngominhquan_ph14304.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Thu {
    @PrimaryKey(autoGenerate = true)
    public int ltID;
    @ColumnInfo(name = "tID")
    public int tID;
    @ColumnInfo(name = "ten")
    public String ten;
    @ColumnInfo(name = "sotien")
    public float sotien;
    @ColumnInfo(name = "ghichu")
    public String ghichu;
}
