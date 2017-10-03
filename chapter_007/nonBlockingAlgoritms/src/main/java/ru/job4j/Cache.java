package ru.job4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * Class is for saving Models.
 * @author Anton Oleynikov
 * created on 26.09.2017
 * @param <K> key
 * @param <V> value
 */
public class Cache <K, V extends Versionable> {
	
	/**
	 * Concurrent map.
	 */
	private ConcurrentHashMap<K, V> map =  new ConcurrentHashMap<>();
	

	
	
	public void start() throws OplimisticException {
		
	}
	
	/**
	 * Adds model.
	 * @param k key
	 * @param v value
	 */
	public void add(K k, V v) {
		//System.out.println(k + "  " + v);
		map.put(k, v);
	}
	
	/**
	 * Updates model in map.
	 * @param k key
	 * @param v value
	 */
	public void update(K k, V newModel) {
		//map.computeIfPresent(k, (key, value) -> newModel);
		//map.computeIfPresent(k, (key, value) -> newModel.getVersion());
		
		if (newModel.getVersion() > map.get(k).getVersion()) {
			map.computeIfPresent(k, (key, value) -> newModel);
		} else {
			try {
				throw new OplimisticException();
			} catch (OplimisticException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Deletes.
	 * @param k key
	 */
	public void delete(K k) {
		map.remove(k);
	}
	
	/**
	 * Gets model.
	 * @param k key
	 * @return value
	 */
	public V get(K k) {
		return map.get(k);
	}
	
	//private void versionManager() {}
}
