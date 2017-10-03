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
	
	public Model(V v) {
		this.v = v;
		this.version = 0;
	}
	
	public Model(V v, int version) {
		this.v = v;
		this.version = version;
	}
	

	@Override
	public int getVersion() {
		return version;
	}
}
