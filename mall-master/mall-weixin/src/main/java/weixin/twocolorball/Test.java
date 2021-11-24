package weixin.twocolorball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		//List<String> codes = getCodes(100000);
		luckyNumber("19950805","魏建");
//		List<String> codes = new ArrayList<>();
//		System.out.println(codes);
	}

	public static List<String> luckyNumber(String birthday, String name){

		String str1 = birthday.substring(0, 4);
		String str2 = birthday.substring(4, 6);
		String str3 = birthday.substring(6, 8);

		String result = String.valueOf(str1.hashCode() + str2.hashCode() + str3.hashCode() + name.hashCode());
		Random random = new Random();
		char[] chars = result.toCharArray();
		List<String> list = new ArrayList<>();
		for (int i = 0;i<chars.length-1;i++) {
			char aChar = chars[i];
			int r = random.nextInt(4);
			String s = r + String.valueOf(aChar);
			while (true){
				if (list.contains(s) || s.equals("00") || Integer.valueOf(s)>33) {
					s = random.nextInt(4) + String.valueOf(aChar);
				}else {
					break;
				}
			}

			list.add(s);
		}
		int anInt = random.nextInt(2);
		String blue = anInt + String.valueOf(chars[chars.length-1]);
		while (true){
			if (blue.equals("00")){
				anInt = random.nextInt(2);
				blue = anInt + String.valueOf(chars[chars.length-1]);
			}else {
				break;
			}
		}
		List<String> collect = list.stream().sorted().collect(Collectors.toList());
		collect.add(blue);
		System.out.println(collect);
		return collect;
	}
	public static void matchCode() {
		List<String> list = Arrays.asList("01", "05", "07", "23", "28", "30", "12");
		long start = System.currentTimeMillis();
		int i = 0;
		while (true) {
			boolean b = compareCodes(list, getCodes().toString());
			i++;
			if (b) {
				System.out.println("找到了！");
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("用时：" + String.valueOf((end - start) / 1000) + "s");
		System.out.println("寻找次数：" + i + "次");
	}

	public static boolean compareCodes(List<String> list, String str) {
		StringBuilder builder = new StringBuilder();
		for (String s : list) {
			builder.append(s);
		}
		String string = builder.toString();
		String replace = str.replace(" ", "");
		System.out.println("replace:" + replace);
		System.out.println("目标:" + string);
		if (string.contains(replace)) {
			return true;
		}
		return false;
	}

	public static List<String> getCodes(int num) {
		List<String> builder = new ArrayList<>();
		if (num > 0) {
			for (int i = 0; i < num; i++) {
				builder.add(getCodes().toString());
			}
		}
		return builder;
	}

	public static StringBuilder getCodes() {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		boolean flag = true;
		while (flag) {
			int anInt = random.nextInt(34);
			if (anInt == 0) {
				anInt = random.nextInt(34);
			}
			set.add(anInt);
			if (set.size() == 6) {
				flag = false;
			}
		}
		int temp = 0;
		Object[] objects = set.toArray();
		for (int i = 0; i < objects.length; i++) {
			for (int j = i; j < objects.length - 1; j++) {
				if ((int) objects[i] > (int) objects[j + 1]) {
					temp = (int) objects[i];
					objects[i] = objects[j + 1];
					objects[j + 1] = temp;
				}
			}
		}
		for (Object object : objects) {
			if ((int) object < 10) {
				stringBuilder.append("0" + object);
				stringBuilder.append(" ");
			} else {
				stringBuilder.append(object);
				stringBuilder.append(" ");
			}

		}

		int blankCode = random.nextInt(17);
		if (blankCode == 0) {
			blankCode = random.nextInt(17);
		}
		if (blankCode < 10) {
			stringBuilder.append("0" + blankCode);
		} else {
			stringBuilder.append(blankCode);
		}
		return stringBuilder;
	}
}
