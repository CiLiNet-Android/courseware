package com.cilinet.dbStorage.activity;

import android.test.AndroidTestCase;
import android.util.Log;

import com.cilinet.dbStorage.bean.Person;
import com.cilinet.dbStorage.service.PersonService;

/** Demo: 单元测试 **/
public class PersonServiceTest extends AndroidTestCase {
	
	private static final String TAG = "PersonServiceTest";
	
	public void testSave(){
		PersonService _personService = new PersonService(this.getContext());
		_personService.save(new Person("张湘鲁",30));
	}
	
	public void testFind(){
		PersonService _personService = new PersonService(this.getContext());
		Person _person = _personService.findById(1);
		
		Log.i(TAG, _person.toString());
	}
	
	public void testSaveTransaction(){
		PersonService _personService = new PersonService(this.getContext());
		_personService.save();
	}

}
