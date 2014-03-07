package b2k.lib.util;

import java.util.ArrayList;
import java.util.List;

public class ProcessData {
	/**
	 * @category Danh sách này dùng để đăng ký process trước khi chạy chương
	 *           trình
	 * @category Cấu tạo của chuỗi: numberkey:number; Queue:String;
	 *           Operation:String; Class:String; Method:String; Type:String;
	 *           Version:String; Description:String; Status:String;
	 */

	public static List<List<String>> list = null;

	public static List<List<String>> getList() {
		if (list == null)
			return new ArrayList<List<String>>();
		return list;
	}

	public static void setList(List<List<String>> list) {
		ProcessData.list = list;
	}

	public static void addData(List<String> lst) {
		if (list == null)
			list = new ArrayList<List<String>>();
		list.add(lst);
	}

}
