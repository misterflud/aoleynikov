package org.annotation;

public enum Apple {
	Jonathan(34), GoldenDel(22), RedDel(70), Winesap(41), Cortland;
	
	int price;
	
	Apple(int price) {
		this.price = price;
	}
	
	Apple() {
		this.price = -1;
	}
}
