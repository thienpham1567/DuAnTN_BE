package shoesShop.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Brand.Brand;
import shoesShop.common.Role.Role;
import shoesShop.common.Role.RoleService;
import shoesShop.common.UserRole.UserRole;
import shoesShop.common.UserRole.UserRoleService;
import shoesShop.common.User.UserSerivce;

@RestController
@RequestMapping("api/v1/userroles")
public class UserRoleController {
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	RoleService roleService;
	@Autowired
	UserSerivce userService;
	@GetMapping
	public ResponseEntity<Collection<UserRole>> retrieveAll() throws Exception {
		Collection<UserRole> userRoles = userRoleService.retrieveAll();
		
		return new ResponseEntity<Collection<UserRole>>(userRoles, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserRole> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		System.out.print(id+"");
		UserRole userRole = userRoleService.retrieveOne(id);
		if (userRole != null) {
			return new ResponseEntity<UserRole>(userRole, HttpStatus.OK);
		}

		return new ResponseEntity<UserRole>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<UserRole> create(@RequestBody @Valid UserRole userRole, BindingResult result) throws Exception {
		
		if (userRole == null || result.hasErrors()) {
			return new ResponseEntity<UserRole>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserRole>(this.userRoleService.create(userRole), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<UserRole> update(@RequestBody @Valid UserRole userRole ,@PathVariable("id") Integer id, BindingResult result) throws Exception {
		if (userRole == null || result.hasErrors()) {
			return new ResponseEntity<UserRole>(HttpStatus.BAD_REQUEST);
		}
		UserRole updatedUserRole = this.userRoleService.update(userRole, id);
		return userRole != null
				? new ResponseEntity<UserRole>(updatedUserRole, HttpStatus.OK)
				: new ResponseEntity<UserRole>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<UserRole> delete(@PathVariable("id") Integer id) throws Exception {
		return this.userRoleService.delete(id) ? new ResponseEntity<UserRole>(HttpStatus.NO_CONTENT) : new ResponseEntity<UserRole>(HttpStatus.BAD_REQUEST);
	}
}
