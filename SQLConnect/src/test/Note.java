package test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import b2k.generic.objects.Entity;
import b2k.generic.sqlite.function.MyConnection;
import b2k.generic.sqlite.function.SQLFunction;

public class Note extends Entity{
/*
 * 30/05
 * Điều chỉnh ABS thống nhất theo kiểu dữ liệu mới..
 * Điều chỉnh các gói phù hợp với ABS mới
 * Thêm Entity là lớp trừu tượng hiện thực các thành phần ABS. Các đối tượng kế thừa Entity này
 * 
 */
	
	
		public static void main(String[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
			SQLFunction.save(MyConnection.getSQLiteConnection("test"), new Note()) ;
		}

}

