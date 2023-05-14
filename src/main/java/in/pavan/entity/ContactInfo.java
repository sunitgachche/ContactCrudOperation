package in.pavan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CONTACT_DTLS")
@Data
public class ContactInfo {
	@Id
	@GeneratedValue
	private int contactId;
	private String name;
	private String email;
	private Long phnNo;
	private String activeSwitch;

}
