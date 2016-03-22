package ca.uwo.csd.cs2212.team05;

import java.io.Serializable;

public class PersonalData extends Data implements Serializable {
	private boolean male;
	private int age;
	private double weight;
	private double height;
	
	public PersonalData(boolean gender, int age, double weight, double height) {
		super("");
		this.male = gender;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
