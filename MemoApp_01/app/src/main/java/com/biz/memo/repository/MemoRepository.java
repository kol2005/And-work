package com.biz.memo.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.biz.memo.db.MemoDataBase;
import com.biz.memo.domain.MemoVO;

import java.util.List;

/*
DB에 접근할때 사용할 Service 클래스
 */
public class MemoRepository {

    private MemoDao mDao;

    public MemoRepository(Application application) {
        MemoDataBase db = MemoDataBase.getInstance(application);
        mDao = db.getMemoDao();
    }

    public LiveData<List<MemoVO>> selectAll(){
       return mDao.selectAll();
    }

    // Thread로 insert 실행
    public void insert(MemoVO memoVO){

/*
        MemoDataBase.dbWriterThread.execute(new Runnable() {
            @Override
            public void run() {
                mDao.insert(memoVO);
            }
        });
*/

        MemoDataBase.dbWriterThread.execute( ()->mDao.save(memoVO) );

    }

    public void delete(MemoVO memoVO){
        MemoDataBase.dbWriterThread.execute( ()->mDao.delete(memoVO) );
    }
}
