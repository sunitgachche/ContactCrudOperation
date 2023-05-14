package in.pavan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.pavan.entity.ContactInfo;

@Repository
public interface ContactRepository extends JpaRepository<ContactInfo, Integer> {

}
