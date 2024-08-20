package com.nexential.crud;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name="check_in")
public class CheckIn {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
@Column(name="noOfGuests")
int no;
@OneToMany(mappedBy="check_in")
List<Guests> guests;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public List<Guests> getGuests() {
	return guests;
}
public void setGuests(List<Guests> guests) {
	this.guests = guests;
}
public CheckIn(int no, List<Guests> guests) {
	super();
	this.no = no;
	this.guests = guests;
}
public CheckIn() {
	
}
}
