package in.pavan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import in.pavan.entity.ContactInfo;
import in.pavan.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository repo;

	@Override
	public String Upsert( ContactInfo contactinfo) {
	//	ContactInfo save = repo.save(contactinfo);
		contactinfo.setActiveSwitch("Y");
		repo.save(contactinfo);
		return "sussess";
	}

	@Override
	public List<ContactInfo> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public ContactInfo getContact( int contactId) {
		Optional<ContactInfo> findById = repo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();

		}
		return null;
	}

	@Override
	public String deleteContact(int contactId) {
		// repo.deleteById(contactId);
		Optional<ContactInfo> findById = repo.findById(contactId);
		if (findById.isPresent()) {
			ContactInfo contact = findById.get();
			contact.setActiveSwitch("N");
			repo.save(contact);
		}
		return "Success";
	}

}
