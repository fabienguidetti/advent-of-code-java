package adventofcode.computer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Memory {
	private Map<Integer, Long> state = new HashMap<>();

	public long get(int address) {
		if (address < 0) {
			throw new IllegalArgumentException("Illegal memory address : " + address);
		}
		Long value = state.get(address);
		return value == null ? 0 : value;
	}

	public void set(int address, Long value) {
		state.put(address, value);
	}

	public List<Long> toLongs() {
		return state.entrySet().stream()
				.sorted(Comparator.comparing(Entry<Integer, Long>::getKey))
				.map(e -> e.getValue())
				.collect(Collectors.toList());
	}
}
