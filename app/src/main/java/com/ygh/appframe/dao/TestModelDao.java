package com.ygh.appframe.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.ygh.appframe.mvp.game.model.TestModel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEST_MODEL".
*/
public class TestModelDao extends AbstractDao<TestModel, Long> {

    public static final String TABLENAME = "TEST_MODEL";

    /**
     * Properties of entity TestModel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Age = new Property(1, int.class, "age", false, "AGE");
        public final static Property Hight = new Property(2, int.class, "hight", false, "HIGHT");
    }


    public TestModelDao(DaoConfig config) {
        super(config);
    }
    
    public TestModelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEST_MODEL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"AGE\" INTEGER NOT NULL ," + // 1: age
                "\"HIGHT\" INTEGER NOT NULL );"); // 2: hight
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEST_MODEL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TestModel entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getAge());
        stmt.bindLong(3, entity.getHight());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TestModel entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getAge());
        stmt.bindLong(3, entity.getHight());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public TestModel readEntity(Cursor cursor, int offset) {
        TestModel entity = new TestModel( //
            cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // age
            cursor.getInt(offset + 2) // hight
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TestModel entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setAge(cursor.getInt(offset + 1));
        entity.setHight(cursor.getInt(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TestModel entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TestModel entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TestModel entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}