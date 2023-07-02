package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shoesShop.common.Role.Role;
import shoesShop.common.Role.RoleService;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<Collection<Role>> retrieveAllRoles() {
		Collection<Role> roles = this.roleService.retrieveAll();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	// test Postman oke 15/6
	@GetMapping("{id}")
	public ResponseEntity<Role> retrieveRole(@PathVariable Integer id) {
		Role role = this.roleService.retrieveOne(id);
		if (role != null) {
			return new ResponseEntity<>(role, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	// test Postman oke 15/6
	@PostMapping
	public ResponseEntity<Role> createRole(@RequestBody Role role) {
		Role createdRole = this.roleService.create(role);
		return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
	}
	// test Postman oke 15/6
	@PutMapping("{id}")
	public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable Integer id) {
		Role updatedRole = this.roleService.update(role, id);
		if (updatedRole != null) {
			return new ResponseEntity<>(updatedRole, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	// test Postman oke 15/6
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
		Boolean deleted = this.roleService.delete(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
