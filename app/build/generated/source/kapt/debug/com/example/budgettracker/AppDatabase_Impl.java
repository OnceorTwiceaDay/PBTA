package com.example.budgettracker;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile AppDao _appDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `Expense` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `amount` REAL NOT NULL, `description` TEXT NOT NULL, `date` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `category` TEXT NOT NULL, `imageUri` TEXT, `username` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Category` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `username` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Goal` (`monthYear` TEXT NOT NULL, `username` TEXT NOT NULL, `minGoal` REAL NOT NULL, `maxGoal` REAL NOT NULL, PRIMARY KEY(`monthYear`, `username`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `User` (`username` TEXT NOT NULL, `password` TEXT NOT NULL, PRIMARY KEY(`username`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Income` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `amount` REAL NOT NULL, `description` TEXT NOT NULL, `date` TEXT NOT NULL, `time` TEXT NOT NULL, `username` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7dcc11cd2b07e0b9b691d111572081b1')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `Expense`");
        db.execSQL("DROP TABLE IF EXISTS `Category`");
        db.execSQL("DROP TABLE IF EXISTS `Goal`");
        db.execSQL("DROP TABLE IF EXISTS `User`");
        db.execSQL("DROP TABLE IF EXISTS `Income`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsExpense = new HashMap<String, TableInfo.Column>(9);
        _columnsExpense.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("imageUri", new TableInfo.Column("imageUri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExpense = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExpense = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExpense = new TableInfo("Expense", _columnsExpense, _foreignKeysExpense, _indicesExpense);
        final TableInfo _existingExpense = TableInfo.read(db, "Expense");
        if (!_infoExpense.equals(_existingExpense)) {
          return new RoomOpenHelper.ValidationResult(false, "Expense(com.example.budgettracker.Expense).\n"
                  + " Expected:\n" + _infoExpense + "\n"
                  + " Found:\n" + _existingExpense);
        }
        final HashMap<String, TableInfo.Column> _columnsCategory = new HashMap<String, TableInfo.Column>(3);
        _columnsCategory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategory = new TableInfo("Category", _columnsCategory, _foreignKeysCategory, _indicesCategory);
        final TableInfo _existingCategory = TableInfo.read(db, "Category");
        if (!_infoCategory.equals(_existingCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "Category(com.example.budgettracker.Category).\n"
                  + " Expected:\n" + _infoCategory + "\n"
                  + " Found:\n" + _existingCategory);
        }
        final HashMap<String, TableInfo.Column> _columnsGoal = new HashMap<String, TableInfo.Column>(4);
        _columnsGoal.put("monthYear", new TableInfo.Column("monthYear", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoal.put("username", new TableInfo.Column("username", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoal.put("minGoal", new TableInfo.Column("minGoal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoal.put("maxGoal", new TableInfo.Column("maxGoal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGoal = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGoal = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGoal = new TableInfo("Goal", _columnsGoal, _foreignKeysGoal, _indicesGoal);
        final TableInfo _existingGoal = TableInfo.read(db, "Goal");
        if (!_infoGoal.equals(_existingGoal)) {
          return new RoomOpenHelper.ValidationResult(false, "Goal(com.example.budgettracker.Goal).\n"
                  + " Expected:\n" + _infoGoal + "\n"
                  + " Found:\n" + _existingGoal);
        }
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(2);
        _columnsUser.put("username", new TableInfo.Column("username", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("User", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(db, "User");
        if (!_infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "User(com.example.budgettracker.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsIncome = new HashMap<String, TableInfo.Column>(6);
        _columnsIncome.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncome.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncome.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncome.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncome.put("time", new TableInfo.Column("time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncome.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIncome = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIncome = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIncome = new TableInfo("Income", _columnsIncome, _foreignKeysIncome, _indicesIncome);
        final TableInfo _existingIncome = TableInfo.read(db, "Income");
        if (!_infoIncome.equals(_existingIncome)) {
          return new RoomOpenHelper.ValidationResult(false, "Income(com.example.budgettracker.Income).\n"
                  + " Expected:\n" + _infoIncome + "\n"
                  + " Found:\n" + _existingIncome);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "7dcc11cd2b07e0b9b691d111572081b1", "85abc8c120c9adc662e2470905fd6c15");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Expense","Category","Goal","User","Income");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Expense`");
      _db.execSQL("DELETE FROM `Category`");
      _db.execSQL("DELETE FROM `Goal`");
      _db.execSQL("DELETE FROM `User`");
      _db.execSQL("DELETE FROM `Income`");
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
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(AppDao.class, AppDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public AppDao dao() {
    if (_appDao != null) {
      return _appDao;
    } else {
      synchronized(this) {
        if(_appDao == null) {
          _appDao = new AppDao_Impl(this);
        }
        return _appDao;
      }
    }
  }
}
