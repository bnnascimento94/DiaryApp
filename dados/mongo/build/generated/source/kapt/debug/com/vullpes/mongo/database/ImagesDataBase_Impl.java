package com.vullpes.mongo.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ImagesDataBase_Impl extends ImagesDataBase {
  private volatile ImagesToUploadDao _imagesToUploadDao;

  private volatile ImageToDeleteDao _imageToDeleteDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `images_to_upload_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `remoteImagePath` TEXT NOT NULL, `imageUri` TEXT NOT NULL, `sessionUri` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `image_to_delete_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `remoteImagePath` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ec39d8ece62c8071e75fc518ca24eecc')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `images_to_upload_table`");
        _db.execSQL("DROP TABLE IF EXISTS `image_to_delete_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsImagesToUploadTable = new HashMap<String, TableInfo.Column>(4);
        _columnsImagesToUploadTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImagesToUploadTable.put("remoteImagePath", new TableInfo.Column("remoteImagePath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImagesToUploadTable.put("imageUri", new TableInfo.Column("imageUri", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImagesToUploadTable.put("sessionUri", new TableInfo.Column("sessionUri", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysImagesToUploadTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesImagesToUploadTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoImagesToUploadTable = new TableInfo("images_to_upload_table", _columnsImagesToUploadTable, _foreignKeysImagesToUploadTable, _indicesImagesToUploadTable);
        final TableInfo _existingImagesToUploadTable = TableInfo.read(_db, "images_to_upload_table");
        if (! _infoImagesToUploadTable.equals(_existingImagesToUploadTable)) {
          return new RoomOpenHelper.ValidationResult(false, "images_to_upload_table(com.vullpes.mongo.database.entity.ImageToUpload).\n"
                  + " Expected:\n" + _infoImagesToUploadTable + "\n"
                  + " Found:\n" + _existingImagesToUploadTable);
        }
        final HashMap<String, TableInfo.Column> _columnsImageToDeleteTable = new HashMap<String, TableInfo.Column>(2);
        _columnsImageToDeleteTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageToDeleteTable.put("remoteImagePath", new TableInfo.Column("remoteImagePath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysImageToDeleteTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesImageToDeleteTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoImageToDeleteTable = new TableInfo("image_to_delete_table", _columnsImageToDeleteTable, _foreignKeysImageToDeleteTable, _indicesImageToDeleteTable);
        final TableInfo _existingImageToDeleteTable = TableInfo.read(_db, "image_to_delete_table");
        if (! _infoImageToDeleteTable.equals(_existingImageToDeleteTable)) {
          return new RoomOpenHelper.ValidationResult(false, "image_to_delete_table(com.vullpes.mongo.database.entity.ImageToDelete).\n"
                  + " Expected:\n" + _infoImageToDeleteTable + "\n"
                  + " Found:\n" + _existingImageToDeleteTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ec39d8ece62c8071e75fc518ca24eecc", "087f5a00c9a44037ec846b5162cd3954");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "images_to_upload_table","image_to_delete_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `images_to_upload_table`");
      _db.execSQL("DELETE FROM `image_to_delete_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ImagesToUploadDao.class, ImagesToUploadDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ImageToDeleteDao.class, ImageToDeleteDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public ImagesToUploadDao imageToUploadDao() {
    if (_imagesToUploadDao != null) {
      return _imagesToUploadDao;
    } else {
      synchronized(this) {
        if(_imagesToUploadDao == null) {
          _imagesToUploadDao = new ImagesToUploadDao_Impl(this);
        }
        return _imagesToUploadDao;
      }
    }
  }

  @Override
  public ImageToDeleteDao imageToDeleteDao() {
    if (_imageToDeleteDao != null) {
      return _imageToDeleteDao;
    } else {
      synchronized(this) {
        if(_imageToDeleteDao == null) {
          _imageToDeleteDao = new ImageToDeleteDao_Impl(this);
        }
        return _imageToDeleteDao;
      }
    }
  }
}
