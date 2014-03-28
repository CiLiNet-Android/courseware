package com.cilinet.dbStorage.service;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cilinet.dbStorage.bean.Person;
import com.cilinet.dbStorage.db.MySQLiteOpenHelper;

public class PersonService {
	
	public static final String DATABASE_NAME = "person";
	
	private MySQLiteOpenHelper mMySQLiteOpenHelper;
	
	public PersonService(Context context){
		mMySQLiteOpenHelper = new MySQLiteOpenHelper(context, DATABASE_NAME, 1);
	}

	public void save(Person person) {
		SQLiteDatabase _sqLiteDatabase = mMySQLiteOpenHelper.getWritableDatabase();
		_sqLiteDatabase.execSQL("INSERT INTO " + DATABASE_NAME + "(personName,personAge) VALUES(?,?)", new Object[]{person.personName,person.personAge});
	}
	
	/** 事务处理演示 ：三个重要的方法**/
	public void save() {
		SQLiteDatabase _sqLiteDatabase = mMySQLiteOpenHelper.getWritableDatabase();
		
		//事务第一步：开启事务
		_sqLiteDatabase.beginTransaction();
		try{
			_sqLiteDatabase.execSQL("INSERT INTO " + DATABASE_NAME + "(personName,personAge) VALUES(?,?)", new Object[]{"张三",50});
			_sqLiteDatabase.execSQL("INSERT INTO " + DATABASE_NAME + "(personName,personAge) VALUES(?,?)", new Object[]{"李四",80});
			_sqLiteDatabase.execSQL("INSERT INTO " + DATABASE_NAME + "(personName,personAge) VALUES(?,?)", new Object[]{"王五",53});
			_sqLiteDatabase.execSQL("INSERT INTO " + DATABASE_NAME + "(personName,personAge) VALUES(?,?)", new Object[]{"赵六",84});
			
			//事务第二步:设置成功标志
			_sqLiteDatabase.setTransactionSuccessful();
		}catch(Exception e){
			
		}finally{
			//事务第三步：结束事务（判断成功标志是否被设置，如果被设置，则提交事务，没有，则回滚）
			_sqLiteDatabase.endTransaction();
		}
		
	}

	public void update(Person person) {
		SQLiteDatabase _sqLiteDatabase = mMySQLiteOpenHelper.getWritableDatabase();
		_sqLiteDatabase.execSQL("UPDATE " + DATABASE_NAME + " SET personName=?,personAge=? WHERE personId=?",new Object[]{person.personName,person.personAge,person.personId});
	}

	/** _sqLiteDatabase.rawQuery execSQL的有返回值版本 
	 * 
	 * 注：sqlite数据库主键计数从1开始
	 * **/
	public Person findById(int id) {
		Person _person = null;
		
		SQLiteDatabase _sqLiteDatabase = mMySQLiteOpenHelper.getReadableDatabase();
		//类似于jdbc中的resultSet
		Cursor cursor = _sqLiteDatabase.rawQuery("SELECT * FROM " + DATABASE_NAME + " WHERE personId=?", new String[]{String.valueOf(id)});
		if(cursor.moveToNext()){//如果移到结尾，则返回false
			_person = new Person(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
		}
		
		return _person;
	}

	public void delete(Integer... ids) {
		if(0 < ids.length){
			StringBuilder sql = new StringBuilder("DELETE FROM " + DATABASE_NAME + " WHERE personId IN (");
			for(int i = 0; i < ids.length; i ++){
				sql.append("?").append(",");
			}
			sql.deleteCharAt(sql.lastIndexOf(","));
			sql.append(")");
			
			SQLiteDatabase _sqLiteDatabase = mMySQLiteOpenHelper.getWritableDatabase();
			
			_sqLiteDatabase.execSQL(sql.toString(),ids);
		}
		
		
	}

	public List<Person> getScrollPersonDatas(int startResult, int maxResult) {
		List<Person> _persons = new ArrayList<Person>();
		
		SQLiteDatabase _sqLiteDatabase = mMySQLiteOpenHelper.getWritableDatabase();
		//LIMIT m,n 跳过m条记录，获得n条记录
		Cursor cursor = _sqLiteDatabase.rawQuery("SELECT * FROM " + DATABASE_NAME + "LIMIT ?,?", new String[]{String.valueOf(startResult),String.valueOf(maxResult)});
		while(cursor.moveToNext()){
			_persons.add(new Person(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
		}
		return _persons;
	}

	public long getCount() {
		long _count = -1;
		
		SQLiteDatabase _sqLiteDatabase = mMySQLiteOpenHelper.getWritableDatabase();
		
		Cursor cursor = _sqLiteDatabase.rawQuery("SELECT COUNT(*) FROM " + DATABASE_NAME,null);
		if(cursor.moveToNext()){
			_count = cursor.getLong(0);
		}
		
		return _count;
	}

}
