package com.trading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomUtil {
	
	public static Double getRandomDouble(Double max) {
		return getRandomDouble(0.0, max);
	}

	public static Double getRandomDouble(Double min, Double max) {
		Random random = new Random();
		if(max-min==0.0) {
			return min;
		}else {
			return min + (max - min) * random.nextDouble();
		}	
	}

	public static Integer getRandomInteger(Integer max) {
		return getRandomInteger(0, max);
	}

	public static Integer getRandomInteger(Integer min, Integer max) {
		Random random = new Random();
		if(max-min==0) {
			return min;
		}else {
			return min + random.nextInt(max - min);
		}
	}

	public static List<Integer> getPairRandomIntegers(Integer max) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < max; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		return list;
	}

}
