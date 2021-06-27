package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.LogModel;

@Repository
public interface LogRepo extends JpaRepository<LogModel, String>
{

	List<LogModel> findByDate(String date);
 
}
