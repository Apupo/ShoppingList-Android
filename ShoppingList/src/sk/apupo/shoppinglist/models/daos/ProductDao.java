package sk.apupo.shoppinglist.models.daos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table PRODUCT.
*/
public class ProductDao extends AbstractDao<Product, Void> {

    public static final String TABLENAME = "PRODUCT";

    /**
     * Properties of entity Product.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Title = new Property(0, String.class, "title", false, "TITLE");
        public final static Property Description = new Property(1, String.class, "description", false, "DESCRIPTION");
        public final static Property UnitPrice = new Property(2, Float.class, "unitPrice", false, "UNIT_PRICE");
        public final static Property Bought = new Property(3, Boolean.class, "bought", false, "BOUGHT");
        public final static Property BoughtDate = new Property(4, java.util.Date.class, "boughtDate", false, "BOUGHT_DATE");
        public final static Property ModificationDate = new Property(5, java.util.Date.class, "modificationDate", false, "MODIFICATION_DATE");
        public final static Property TitleClean = new Property(6, String.class, "titleClean", false, "TITLE_CLEAN");
        public final static Property InBasket = new Property(7, Boolean.class, "inBasket", false, "IN_BASKET");
        public final static Property Quantity = new Property(8, Integer.class, "quantity", false, "QUANTITY");
        public final static Property QuantityType = new Property(9, Integer.class, "quantityType", false, "QUANTITY_TYPE");
        public final static Property Fk_category_id = new Property(10, long.class, "fk_category_id", false, "FK_CATEGORY_ID");
    };

    private DaoSession daoSession;

    private Query<Product> categoryEntity_ProductsQuery;

    public ProductDao(DaoConfig config) {
        super(config);
    }
    
    public ProductDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PRODUCT' (" + //
                "'TITLE' TEXT," + // 0: title
                "'DESCRIPTION' TEXT," + // 1: description
                "'UNIT_PRICE' REAL," + // 2: unitPrice
                "'BOUGHT' INTEGER," + // 3: bought
                "'BOUGHT_DATE' INTEGER," + // 4: boughtDate
                "'MODIFICATION_DATE' INTEGER," + // 5: modificationDate
                "'TITLE_CLEAN' TEXT," + // 6: titleClean
                "'IN_BASKET' INTEGER," + // 7: inBasket
                "'QUANTITY' INTEGER," + // 8: quantity
                "'QUANTITY_TYPE' INTEGER," + // 9: quantityType
                "'FK_CATEGORY_ID' INTEGER NOT NULL );"); // 10: fk_category_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PRODUCT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Product entity) {
        stmt.clearBindings();
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(1, title);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(2, description);
        }
 
        Float unitPrice = entity.getUnitPrice();
        if (unitPrice != null) {
            stmt.bindDouble(3, unitPrice);
        }
 
        Boolean bought = entity.getBought();
        if (bought != null) {
            stmt.bindLong(4, bought ? 1l: 0l);
        }
 
        java.util.Date boughtDate = entity.getBoughtDate();
        if (boughtDate != null) {
            stmt.bindLong(5, boughtDate.getTime());
        }
 
        java.util.Date modificationDate = entity.getModificationDate();
        if (modificationDate != null) {
            stmt.bindLong(6, modificationDate.getTime());
        }
 
        String titleClean = entity.getTitleClean();
        if (titleClean != null) {
            stmt.bindString(7, titleClean);
        }
 
        Boolean inBasket = entity.getInBasket();
        if (inBasket != null) {
            stmt.bindLong(8, inBasket ? 1l: 0l);
        }
 
        Integer quantity = entity.getQuantity();
        if (quantity != null) {
            stmt.bindLong(9, quantity);
        }
 
        Integer quantityType = entity.getQuantityType();
        if (quantityType != null) {
            stmt.bindLong(10, quantityType);
        }
        stmt.bindLong(11, entity.getFk_category_id());
    }

    @Override
    protected void attachEntity(Product entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public Product readEntity(Cursor cursor, int offset) {
        Product entity = new Product( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // title
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // description
            cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2), // unitPrice
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0, // bought
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)), // boughtDate
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // modificationDate
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // titleClean
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0, // inBasket
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // quantity
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // quantityType
            cursor.getLong(offset + 10) // fk_category_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Product entity, int offset) {
        entity.setTitle(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDescription(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUnitPrice(cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2));
        entity.setBought(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
        entity.setBoughtDate(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
        entity.setModificationDate(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setTitleClean(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setInBasket(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
        entity.setQuantity(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setQuantityType(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setFk_category_id(cursor.getLong(offset + 10));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(Product entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(Product entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "products" to-many relationship of CategoryEntity. */
    public List<Product> _queryCategoryEntity_Products(long fk_category_id) {
        synchronized (this) {
            if (categoryEntity_ProductsQuery == null) {
                QueryBuilder<Product> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Fk_category_id.eq(null));
                categoryEntity_ProductsQuery = queryBuilder.build();
            }
        }
        Query<Product> query = categoryEntity_ProductsQuery.forCurrentThread();
        query.setParameter(0, fk_category_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getCategoryEntityDao().getAllColumns());
            builder.append(" FROM PRODUCT T");
            builder.append(" LEFT JOIN CATEGORY_ENTITY T0 ON T.'FK_CATEGORY_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Product loadCurrentDeep(Cursor cursor, boolean lock) {
        Product entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        CategoryEntity categoryEntity = loadCurrentOther(daoSession.getCategoryEntityDao(), cursor, offset);
         if(categoryEntity != null) {
            entity.setCategoryEntity(categoryEntity);
        }

        return entity;    
    }

    public Product loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Product> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Product> list = new ArrayList<Product>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Product> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Product> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
