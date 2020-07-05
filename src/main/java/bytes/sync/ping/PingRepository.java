package bytes.sync.ping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PingRepository extends JpaRepository<PingModel, Long> {
    @Override
    List<PingModel> findAll();
}
