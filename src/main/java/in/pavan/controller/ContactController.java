package in.pavan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.pavan.entity.ContactInfo;
import in.pavan.service.ContactService;

@RestController
public class ContactController {
	@Autowired
	private ContactService service;

	@PostMapping("/contact")
	public ResponseEntity<String> contact(@RequestBody ContactInfo contactinfo) {
		String status = service.Upsert(contactinfo);
		return new ResponseEntity<>(status, HttpStatus.CREATED);

	}

	@GetMapping("/contacts")
	public ResponseEntity<List<ContactInfo>> getAllContact() {
		List<ContactInfo> allContacts = service.getAllContacts();
		return new ResponseEntity<>(allContacts, HttpStatus.OK);

	}

	@GetMapping("/contact/{cid}")
	public ResponseEntity<ContactInfo> getContact(@PathVariable("cid") int contactId) {
		ContactInfo info = service.getContact(contactId);
		return new ResponseEntity<>(info, HttpStatus.OK);

	}

	@DeleteMapping("/contact/{cid}")
	public ResponseEntity<String> deleteContact(@PathVariable("cid") int contactId) {
		String deletecontact = service.deleteContact(contactId);
		return new ResponseEntity<>(deletecontact, HttpStatus.OK);

	}
}
