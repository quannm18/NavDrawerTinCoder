package com.example.asm_ngominhquan_ph14304.dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.asm_ngominhquan_ph14304.entity.LoaiThu;
import com.example.asm_ngominhquan_ph14304.entity.Thu;

import org.jetbrains.annotations.NotNull;

@Database(entities = {LoaiThu.class, Thu.class},version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LoaiThuDAO loaiThuDAO();
    public abstract ThuDAO thuDAO();

    public static AppDatabase INSTANCE;
    private static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new PoulateDate(INSTANCE).execute();
        }
    };

    public static AppDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (AppDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,"personal_db")
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
        return INSTANCE;
    }
    public static class  PoulateDate extends AsyncTask<Void, Void, Void>{
        private LoaiThuDAO loaiThuDAO;
        private ThuDAO thuDAO;


        public PoulateDate(AppDatabase db) {
            this.loaiThuDAO = db.loaiThuDAO();
            thuDAO = db.thuDAO();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            String[] loaiThuList = new String[]{"Luong","Thuong","Co phieu"};

            for (String it: loaiThuList){
                LoaiThu lt = new LoaiThu();
                lt.ten = it;
                loaiThuDAO.insert(lt);
            }
            Thu thu = new Thu();
            thu.ten = "Luong thang 1";
            thu.sotien=3000;
            thu.tID = 2;
            thu.ghichu = "";
            thuDAO.insert(thu);
            return null;
        }
    }
}
