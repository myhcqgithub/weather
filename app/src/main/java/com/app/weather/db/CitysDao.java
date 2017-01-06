package com.app.weather.db;

import android.content.Context;

import com.app.weather.bean.Citys;

import java.util.List;

/**
 * Created by wangshuo on 16/12/9.
 */

public class CitysDao {


    private Context mContext;

    public CitysDao(Context context) {
        mContext = context;
    }

    public long add(Citys citys) {
        return DaoUtils.getInstance(mContext).getWriDaoSession().insert(citys);
    }

    public List<Citys> findAllCity() {
        return DaoUtils.getInstance(mContext).getReadDaoSession().queryBuilder(Citys.class).list();
    }

    public void delete(Citys citys) {
        DaoUtils.getInstance(mContext).getWriDaoSession().delete(citys);
    }
}
