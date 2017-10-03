package ru.job4j;

/**
 * Model.
 * @author Anton Oleynikov
 * created on 26.09.2017
 */
public class Model<V> implements Versionable {
	
	/**
	 * Name.
	 */
	String name;
	
	V v;
	
	final private int version;
	
	/**
	 * Constructor.
	 */
	public Model() {
		this.version = 0;
	}
	
	/**
	 * Constructor.
	 * @param v v
	 */
	public Model(V v) {
		this.v = v;
		this.version = 0;
	}
	
	/**
	 * Constructor.
	 * @param v v
	 * @param version version
	 */
	public Model(V v, int version) {
		this.v = v;
		this.version = version;
	}
	
	/**
	 * Gets version.
	 */
	@Override
	public int getVersion() {
		return version;
	}
}
