package install.service;

import install.bo.Profiles;
import install.dao.ProfilesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Profiles manager.
 *
 * @author kevin
 */
@Service
public class ProfilesManager {

    @Autowired
    private ProfilesDAO profilesDAO;

    /**
     * Gets profiles list.
     *
     * @return the profiles list
     */
    public List<Profiles> getProfilesList() { return profilesDAO.findAll(); }

    /**
     * Add profile.
     *
     * @param profile the profile
     */
    public void addProfile(Profiles profile) { profilesDAO.save(profile); }

    /**
     * Update profile.
     *
     * @param profile the profile
     */
    public void updateProfile(Profiles profile) { profilesDAO.save(profile); }

    /**
     * Gets profile.
     *
     * @param id the id
     * @return the profile
     */
    public Optional<Profiles> getProfile(String id) { return profilesDAO.findById(id); }

    /**
     * Delete profile.
     *
     * @param profile the profile
     */
    public void deleteProfile(Profiles profile) {
        Profiles profileToDelete = getProfile(profile.getIdProfile()).get();
        profilesDAO.delete(profileToDelete);
    }
}
