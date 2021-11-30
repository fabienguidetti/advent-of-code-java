package adventofcode.util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static List<Long> splitLongs(String stringOfLongs, String delimiter) {
		String[] longStrings = stringOfLongs.split(delimiter);
		List<Long> longs = new ArrayList<>();
		for (String s : longStrings) {
			longs.add(Long.valueOf(s));
		}
		return longs;
	}

	public static String joinLongs(List<Long> longs, String delimiter) {
		List<String> strings = new ArrayList<>();
		for (Long n : longs) {
			strings.add(Long.toString(n));
		}
		return String.join(delimiter, strings);
	}
}
