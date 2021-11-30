package adventofcode.day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrbitMap {

	private Map<String, String> orbits = new HashMap<>();

	void addOrbit(String center, String satellite) {
		orbits.put(satellite, center);
	}

	int checksum() {
		int result = 0;
		for (String satellite : orbits.keySet()) {
			String object = satellite;
			while (orbits.get(object) != null) {
				result++;
				object = orbits.get(object);
			}
		}
		return result;
	}

	int minTransfersRequired(String from, String to) {
		List<String> fromChain = chainFrom(from);
		List<String> toChain = chainFrom(to);
		removeCommonObjects(fromChain, toChain);
		return fromChain.size() + toChain.size();
	}

	private List<String> chainFrom(String object) {
		List<String> chain = new ArrayList<>();
		while ((object = orbits.get(object)) != null) {
			chain.add(object);
		}
		return chain;
	}

	private void removeCommonObjects(List<String> chain1, List<String> chain2) {
		while (last(chain1).equals(last(chain2))) {
			removeLast(chain1);
			removeLast(chain2);
		}
	}

	private String last(List<String> list) {
		return list.get(list.size() - 1);
	}

	private void removeLast(List<String> list) {
		list.remove(list.size() - 1);
	}
}
