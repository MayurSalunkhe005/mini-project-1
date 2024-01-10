package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.StudentEnq;

@Repository
public interface StudentEnqRepo extends JpaRepository<StudentEnq, Integer> {

}
