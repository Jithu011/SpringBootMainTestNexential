package com.nexential.crud;
import jakarta.persistence.*;
@Entity
@Table(name="guests")
public class Guests {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
@Column(name="name")
String name;
@Column(name="age")
int age;
@ManyToOne
@JoinColumn(name="CheckIn_id")
CheckIn checkin;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

public CheckIn getCheckin() {
	return checkin;
}
public void setCheckin(CheckIn checkin) {
	this.checkin = checkin;
}
public Guests(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}
public Guests() {
	
}
}
