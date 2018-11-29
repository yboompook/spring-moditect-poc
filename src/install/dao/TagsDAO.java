package install.dao;

import install.bo.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsDAO extends JpaRepository<Tags, Integer> {
}
