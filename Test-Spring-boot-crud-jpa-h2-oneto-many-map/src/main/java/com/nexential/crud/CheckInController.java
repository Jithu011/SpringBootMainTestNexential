package com.nexential.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CheckInController {
@Autowired
CheckInRepository checkInRepository;

@GetMapping
public List<CheckIn> getAllCheckinDet(){
	return check;
	
}
}
