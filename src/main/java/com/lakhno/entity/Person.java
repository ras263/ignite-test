package com.lakhno.entity;

/**
 * Created by Lakhno Anton
 * at 23:48 17.05.2018.
 *
 * @author Lakhno Anton
 * @version 1.0.1
 * @since 1.0.1
 */
public class Person extends GenericEntity {

	private String name;
	private Integer age;
	private Sex sex;
	private NativeLanguage nativeLanguage;

	//region Properties' accessors.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public NativeLanguage getNativeLanguage() {
		return nativeLanguage;
	}

	public void setNativeLanguage(NativeLanguage nativeLanguage) {
		this.nativeLanguage = nativeLanguage;
	}
	//endregion

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", sex=" + sex +
				", nativeLanguage=" + nativeLanguage +
				'}';
	}

	public enum  Sex {
		MALE, FEMALE;
	}
	public enum NativeLanguage {
		RUSSIAN, ENGLISH, DEUTCH;
	}
}
