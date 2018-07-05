
import java.util.HashSet;
import java.util.Iterator;

import java.util.TreeSet;

/**
 * 
 * TODO GitHub好玩 跟SVN差不多
 * @author huangzq
 * @time 2018年7月2日
 * @project_name Mytest
 * @mailbox 1375529585@qq.com
 */
public class MyPorker {
	// 初始化扑克牌 set hashSet 无序
	public static HashSet<Integer> getAllPorker() {

		HashSet<Integer> porkerSet = new HashSet<Integer>();

		for (int i = 1; i <= 54; i++) {
			porkerSet.add(i);
		}

		return porkerSet;
	}

	// 将牌数转换到花色
	public static String getColor(int data) {

		String result = "";
		// 商
		int dataN = data / 13;
		// 余数
		int dataM = data % 13;

//		String dataNstr = String.valueOf(dataN);
		String dataMstr = String.valueOf(dataM);

		switch (dataM) {
			case 11:
				dataMstr = "J";
				break;
			case 12:
				dataMstr = "Q";
				break;
			case 0:
				dataMstr = "K";
				break;
		}

		if (data <= 13) {
			result = "黑桃" + dataMstr;
		} else {
			switch (dataN) {
				case 1:
					result = "红桃" + dataMstr;
					break;
				case 2:
					result = "梅花" + dataMstr;
					break;
				case 3:
					result = "方块" + dataMstr;
					break;
				case 4:
					if (dataM == 1) {
						result = "大王";
					} else {
						result = "小王";
					}
					break;
			}
		}

		return result;
	}

	// 在所有的牌中随机拿出18张
	public static void getPorker(HashSet<Integer> set,
			HashSet<Integer> allPorkerSet) {
		
		Iterator<Integer> it = allPorkerSet.iterator();

		while (it.hasNext()) {
			Integer i = it.next();
			set.add(i);
		}
	}

	//
	public static String[] run(HashSet<Integer> set) {
		Iterator<Integer> it = set.iterator();
		TreeSet<String> setT = new TreeSet<String>();
		int count = 1;
		while (it.hasNext()) {
			int i = it.next();
			String result = getColor(i);
			setT.add(result);
			count += 1;
			if( count > 18){
				break;
			}
		}

		String[] strRes = (String[]) setT.toArray(new String[0]);
		return strRes;

	}

	public static void main(String[] args) {

		HashSet<Integer> Aset = new HashSet<Integer>();
		HashSet<Integer> Bset = new HashSet<Integer>();
		HashSet<Integer> Cset = new HashSet<Integer>();

		HashSet<Integer> allPorkerSet = getAllPorker();
		getPorker(Aset, allPorkerSet);
		// 执行方法
		getPorker(Aset, allPorkerSet);
		getPorker(Bset, allPorkerSet);
		getPorker(Cset, allPorkerSet);

		String[] strA = run(Aset);
//		String[] strB = run(Bset);
//		String[] strC = run(Cset);

		System.out.println(strA);
	}

}
