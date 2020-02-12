package com.biz.memo.repository;

import android.app.Application;

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

    public List<MemoVO> selectAll(){
       return mDao.selectAll();
    }

    public void insert(MemoVO memoVO){
        mDao.save(memoVO);
    }
}
