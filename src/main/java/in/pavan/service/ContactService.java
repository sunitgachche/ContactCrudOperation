package in.pavan.service;

import java.util.List;

import in.pavan.entity.ContactInfo;

public interface ContactService {

	String Upsert(ContactInfo contactinfo);

	List<ContactInfo> getAllContacts();

	ContactInfo getContact(int contactId);

	String deleteContact(int contactId);

}
