package sk.apupo.shoppinglist.daos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import sk.apupo.shoppinglist.daos.ShoppingListEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table SHOPPING_LIST_ENTITY.
*/
public class ShoppingListEntityDao extends AbstractDao<ShoppingListEntity, Long> {

    public static final String TABLENAME = "SHOPPING_LIST_ENTITY";

    /**
     * Properties of entity ShoppingListEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property TitleClean = new Property(2, String.class, "titleClean", false, "TITLE_CLEAN");
        public final static Property Description = new Property(3, String.class, "description", false, "DESCRIPTION");
        public final static Property ModificationDate = new Property(4, java.util.Date.class, "modificationDate", false, "MODIFICATION_DATE");
    };


    public ShoppingListEntityDao(DaoConfig config) {
        super(config);
    }
    
    public ShoppingListEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SHOPPING_LIST_ENTITY' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'TITLE' TEXT," + // 1: title
                "'TITLE_CLEAN' TEXT," + // 2: titleClean
                "'DESCRIPTION' TEXT," + // 3: description
                "'MODIFICATION_DATE' INTEGER);"); // 4: modificationDate
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_SHOPPING_LIST_ENTITY__id ON SHOPPING_LIST_ENTITY" +
                " (_id);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SHOPPING_LIST_ENTITY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ShoppingListEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String titleClean = entity.getTitleClean();
        if (titleClean != null) {
            stmt.bindString(3, titleClean);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(4, description);
        }
 
        java.util.Date modificationDate = entity.getModificationDate();
        if (modificationDate != null) {
            stmt.bindLong(5, modificationDate.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ShoppingListEntity readEntity(Cursor cursor, int offset) {
        ShoppingListEntity entity = new ShoppingListEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // titleClean
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // description
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)) // modificationDate
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ShoppingListEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitleClean(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDescription(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setModificationDate(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ShoppingListEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ShoppingListEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
