package com.example.asm_ngominhquan_ph14304.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.asm_ngominhquan_ph14304.dao.AppDatabase;
import com.example.asm_ngominhquan_ph14304.dao.LoaiThuDAO;
import com.example.asm_ngominhquan_ph14304.entity.LoaiThu;

import java.util.List;

public class LoaiThuRepository {
    private LoaiThuDAO mLoaiThuDAO;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public LoaiThuRepository(Application application) {
        this.mLoaiThuDAO = AppDatabase.getDatabase(application).loaiThuDAO();
        mAllLoaiThu = mLoaiThuDAO.findAll();
    }

    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mAllLoaiThu;
    }

    public void insert(LoaiThu loaiThu){
        new InsertAsyncTask(mLoaiThuDAO).execute(loaiThu);
    }

    public void delete(LoaiThu loaiThu){
        new DeleteAsyncTask(mLoaiThuDAO).execute(loaiThu);
    }

    public void update(LoaiThu loaiThu){
        new UpdateAsyncTask(mLoaiThuDAO).execute(loaiThu);
    }


    class InsertAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDAO mLoaiThuDAO;
        public InsertAsyncTask(LoaiThuDAO loaiThuDAO) {
            this.mLoaiThuDAO = loaiThuDAO;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDAO.insert(loaiThus[0]);
            return null;
        }
    }
    class DeleteAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDAO mLoaiThuDAO;
        public DeleteAsyncTask(LoaiThuDAO loaiThuDAO) {
            this.mLoaiThuDAO = loaiThuDAO;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDAO.delete(loaiThus[0]);
            return null;
        }
    }

    class UpdateAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDAO mLoaiThuDAO;
        public UpdateAsyncTask(LoaiThuDAO loaiThuDAO) {
            this.mLoaiThuDAO = loaiThuDAO;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDAO.update(loaiThus[0]);
            return null;
        }
    }
}
