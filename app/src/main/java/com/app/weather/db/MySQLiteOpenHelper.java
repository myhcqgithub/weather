package com.app.weather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.app.weather.bean.DaoMaster;


/**
 * Created by wangshuo on 16/11/28.
 */

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {


    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
//        MigrationHelper.DEBUG = true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
//        MigrationHelper.migrate(db, MetaDataDbDao.class, TemplateDbDao.class);
//        DaoMaster.dropAllTables(db,true);
//
//        onCreate(db);
    }

}
