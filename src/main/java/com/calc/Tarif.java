package com.calc;

public enum Tarif {


	
        Однозонный1("Однозонный"),
        Двухзонный2("Двухзонный"),
        Трехзонный3("Трёхзонный");

		
		private final String title;
		
		Tarif(String title) {
			this.title = title;
			
		}

	public String getTitle() {
		return title;
	}
}
