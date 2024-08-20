package com.nexential.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GuestsController {
@Autowired
GuestsRepository guestsRepository;

@GetMapping("/guests")
public Page<Guests> getAllguests(PageSettings pageSettings){
	Pageable details = PageRequest.of(pageSettings.getPage(),pageSettings.getElementsPerPage());
	return guestsRepository.findAll(details);
}
@GetMapping("/guests/{id}")
public ResponseEntity<Guests> getGuestsById(@PathVariable(value="id")int id) {
	Guests guests = guestsRepository.findById(id).orElse(null);
	return ResponseEntity.ok(guests);
}
@PostMapping("/guests")
public Guests inputCheckin(@RequestBody Guests guests) {
	return guestsRepository.save(guests);
}
@PutMapping("/guests/{id}")
public ResponseEntity<Guests> updateById(@PathVariable(value="id") int id, @RequestBody Guests guests){
	Guests Guests = guestsRepository.findById(id).orElse(null);
	Guests.setName(guests.getName());
	Guests.setAge(guests.getAge());
	Guests.setCheckin(guests.getCheckin());
	Guests updated = guestsRepository.save(Guests);
	return ResponseEntity.ok(updated);
}
@DeleteMapping("/guests/{id}")
public String deleteById(@PathVariable(value="id") int id) {
	guestsRepository.deleteById(id);
	return "guests Deleted";
	
}
}