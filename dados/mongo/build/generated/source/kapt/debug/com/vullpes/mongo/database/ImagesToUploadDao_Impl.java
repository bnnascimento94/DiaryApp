package com.vullpes.mongo.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.vullpes.mongo.database.entity.ImageToUpload;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ImagesToUploadDao_Impl implements ImagesToUploadDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ImageToUpload> __insertionAdapterOfImageToUpload;

  private final SharedSQLiteStatement __preparedStmtOfCleanupImage;

  public ImagesToUploadDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfImageToUpload = new EntityInsertionAdapter<ImageToUpload>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `images_to_upload_table` (`id`,`remoteImagePath`,`imageUri`,`sessionUri`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ImageToUpload value) {
        stmt.bindLong(1, value.getId());
        if (value.getRemoteImagePath() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRemoteImagePath());
        }
        if (value.getImageUri() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImageUri());
        }
        if (value.getSessionUri() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSessionUri());
        }
      }
    };
    this.__preparedStmtOfCleanupImage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM images_to_upload_table where id=?";
        return _query;
      }
    };
  }

  @Override
  public Object addImageToUpload(final ImageToUpload imageToUpload,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfImageToUpload.insert(imageToUpload);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object cleanupImage(final int imageId, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfCleanupImage.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, imageId);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfCleanupImage.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllImages(final Continuation<? super List<ImageToUpload>> continuation) {
    final String _sql = "SELECT * FROM images_to_upload_table ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ImageToUpload>>() {
      @Override
      public List<ImageToUpload> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRemoteImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteImagePath");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfSessionUri = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionUri");
          final List<ImageToUpload> _result = new ArrayList<ImageToUpload>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ImageToUpload _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpRemoteImagePath;
            if (_cursor.isNull(_cursorIndexOfRemoteImagePath)) {
              _tmpRemoteImagePath = null;
            } else {
              _tmpRemoteImagePath = _cursor.getString(_cursorIndexOfRemoteImagePath);
            }
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final String _tmpSessionUri;
            if (_cursor.isNull(_cursorIndexOfSessionUri)) {
              _tmpSessionUri = null;
            } else {
              _tmpSessionUri = _cursor.getString(_cursorIndexOfSessionUri);
            }
            _item = new ImageToUpload(_tmpId,_tmpRemoteImagePath,_tmpImageUri,_tmpSessionUri);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
