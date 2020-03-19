package com.cache.hazelcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cache.hazelcast.service.EmployeeService;

@RestController
public class Controller {

	@Autowired
	EmployeeService employeeService;
	
	/*
	@GetMapping(value="/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId")Integer ticketId){
		return ticketBookingService.getTicketById(ticketId);
	}
	
	@DeleteMapping(value="/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId")Integer ticketId){
		ticketBookingService.deleteTicket(ticketId);
	}
	
	@PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
	public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId,@PathVariable("newEmail")String newEmail){
		return ticketBookingService.updateTicket(ticketId,newEmail);
	}*/
}
