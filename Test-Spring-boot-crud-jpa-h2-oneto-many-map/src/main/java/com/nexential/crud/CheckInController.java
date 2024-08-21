package com.nexential.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class CheckInController {
	@Autowired
	CheckInRepository checkInRepository;

	@GetMapping("/check-in/page")
	public Page<CheckIn> getAllCheckinDet(PageSettings pageSettings) {
		Pageable details = PageRequest.of(pageSettings.getPage(), pageSettings.getElementsPerPage());
		return checkInRepository.findAll(details);
	}

	@GetMapping("/check-in/sort")
	public List<CheckIn> getCheckInSorted(SortSettings sortSettings) {
		Sort sortedCheckin = sortSettings.buildSort();
		return checkInRepository.findAll(sortedCheckin);
	}

	@GetMapping("/check-in/{id}")
	public ResponseEntity<CheckIn> getCheckinById(@PathVariable(value = "id") int id) {
		CheckIn checkin = checkInRepository.findById(id).orElse(null);
		return ResponseEntity.ok(checkin);
	}

	@PostMapping("/check-in")
	public CheckIn inputCheckin(@RequestBody CheckIn checkin) {
		return checkInRepository.save(checkin);
	}

	@PutMapping("/check-in/{id}")
	public ResponseEntity<CheckIn> updateById(@PathVariable(value = "id") int id, @RequestBody CheckIn checkin) {
		CheckIn checkIn = checkInRepository.findById(id).orElse(null);
		checkIn.setNo(checkin.getNo());
		checkIn.setGuests(checkin.getGuests());
		CheckIn updated = checkInRepository.save(checkIn);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/check-in/{id}")
	public String deleteById(@PathVariable(value = "id") int id) {
		checkInRepository.deleteById(id);
		return "Check-In Deleted";
	}
}
