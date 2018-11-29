package install.dao;

import install.bo.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Profiles dao.
 *
 * @author kevin
 */
@Repository
public interface ProfilesDAO extends JpaRepository<Profiles, String> {
}
