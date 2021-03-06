package com.lucasgp.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasgp.demo.domain.User;
import com.lucasgp.demo.dto.UserDTO;
import com.lucasgp.demo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<UserDTO>> findAll(){
		
		
		List<User> getUsers = service.findAll();
		List<UserDTO> listDto = getUsers.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return  ResponseEntity.ok(listDto);
	}
	
}
