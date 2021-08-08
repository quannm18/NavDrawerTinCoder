package com.example.asm_ngominhquan_ph14304.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.asm_ngominhquan_ph14304.dao.AppDatabase;
import com.example.asm_ngominhquan_ph14304.dao.ThuDAO;
import com.example.asm_ngominhquan_ph14304.entity.Thu;

import java.util.List;

public class ThuRepository {
    private ThuDAO mThuDAO;
    private LiveData<List<Thu>> mAllThu;

    public ThuRepository(Application application) {
        this.mThuDAO = AppDatabase.getDatabase(application).thuDAO();
        mAllThu = mThuDAO.findAll();
    }

    public LiveData<List<Thu>> getAllThu() {
        return mAllThu;
    }

    public void insert(Thu Thu){
        new InsertAsyncTask(mThuDAO).execute(Thu);
    }

    public void delete(Thu Thu){
        new DeleteAsyncTask(mThuDAO).execute(Thu);
    }

    public void update(Thu Thu){
        new UpdateAsyncTask(mThuDAO).execute(Thu);
    }


    class InsertAsyncTask extends AsyncTask<Thu,Void,Void>{
        private ThuDAO mThuDAO;
        public InsertAsyncTask(ThuDAO ThuDAO) {
            this.mThuDAO = ThuDAO;
        }

        @Override
        protected Void doInBackground(Thu... Thus) {
            mThuDAO.insert(Thus[0]);
            return null;
        }
    }
    class DeleteAsyncTask extends AsyncTask<Thu,Void,Void>{
        private ThuDAO mThuDAO;
        public DeleteAsyncTask(ThuDAO ThuDAO) {
            this.mThuDAO = ThuDAO;
        }

        @Override
        protected Void doInBackground(Thu... Thus) {
            mThuDAO.delete(Thus[0]);
            return null;
        }
    }

    class UpdateAsyncTask extends AsyncTask<Thu,Void,Void>{
        private ThuDAO mThuDAO;
        public UpdateAsyncTask(ThuDAO ThuDAO) {
            this.mThuDAO = ThuDAO;
        }

        @Override
        protected Void doInBackground(Thu... Thus) {
            mThuDAO.update(Thus[0]);
            return null;
        }
    }
}
