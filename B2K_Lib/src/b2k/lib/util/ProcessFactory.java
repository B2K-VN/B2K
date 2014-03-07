package b2k.lib.util;

import java.util.Hashtable;
import java.util.List;

import javax.swing.JFrame;

import com.mongodb.DBObject;

public class ProcessFactory {

	static final String Validate = "p1.Validate";

	static Hashtable<String, IMethod> hashProcessMethod = new Hashtable<String, IMethod>();
	static Hashtable<String, Object> hashClass = new Hashtable<String, Object>();

	/**
	 * @author Dung de load thu vien se goi trong database có bảng tên
	 *         ProcessMethod
	 * @author Cấu trúc: Queue, Operation, Class, Method, Type, Version,
	 *         Description
	 * @author Queue + Operation = key.
	 * @author Class: Tên đường dẫn của lớp sẽ gọi (package + className).
	 * @author Method: Tên hàm sẽ gọi trong Class.
	 * @author Type: Đê phân biệt chỉ xử lý chạy local (private) hay gửi qua
	 *         mạng network (public).
	 * @author Version: dùng để biết chức năng này đã được cập nhật đến phiên
	 *         bản nào.
	 * @author Description: Mô tả về chức năng được hiện thực.
	 */
	static {

		try {
			// ///////////////////////////////////////////////////////////////////////////
			// /////////////////////////////////TEST//////////////////////////////////////
			// ///////////////////////////////////////////////////////////////////////////

			List<List<String>> lst = ProcessData.getList();

			// ///////////////////////////////////////////////////////////////////////////
			// /////////////////////////////END
			// TEST//////////////////////////////////////
			// ///////////////////////////////////////////////////////////////////////////

			int size = lst.size();
			for (int i = 0; i < size; i++) {
				List<String> l = lst.get(i);

				String keycode = l.get(0) + l.get(1);

				Object object = hashClass.get(l.get(2));
				if (object == null) {
					object = Class.forName(l.get(2)).newInstance();
				}

				hashProcessMethod.put(keycode, new IMethod(object, object
						.getClass().getMethod(l.get(3), DBObject.class)));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends DBObject> T exec(String queuecode, String type,
			String operation, DBObject o) {

		String s = queuecode + operation;

		IMethod iMethod = hashProcessMethod.get(s);

		if (iMethod != null) {
			System.out.println(iMethod.getMethod());
			try {
				Object invoke = iMethod.getMethod().invoke(iMethod.getClazz(),
						o);
				return (T) invoke;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	};

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setVisible(true);

	}
}
