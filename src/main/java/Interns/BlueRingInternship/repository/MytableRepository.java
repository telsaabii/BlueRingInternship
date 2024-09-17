package Interns.BlueRingInternship.repository;

import Interns.BlueRingInternship.entity.MytableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MytableRepository extends JpaRepository<MytableEntity, Integer> {


}
