package install.service;

import install.bo.Profiles;
import install.bo.Tags;
import install.dao.TagsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagsManager {

    @Autowired
    private TagsDAO tagsDAO;

    /**
     * Gets profiles list.
     *
     * @return the profiles list
     */
    public List<Tags> getTagsList() { return tagsDAO.findAll(); }

    /**
     * Add profile.
     *
     * @param tag the profile
     */
    public void addTag(Tags tag) { tagsDAO.save(tag); }

    /**
     * Update profile.
     *
     * @param tag the profile
     */
    public void updateTag(Tags tag) { tagsDAO.save(tag); }

    /**
     * Gets profile.
     *
     * @param id the id
     * @return the profile
     */
    public Optional<Tags> getTag(int id) { return tagsDAO.findById(id); }

    /**
     * Delete profile.
     *
     * @param tag the profile
     */
    public void deleteTag(Tags tag) {
        Tags tagToDelete = getTag(tag.getIdTag()).get();
        tagsDAO.delete(tagToDelete);
    }

    public void deleteAllTags() {
        for (Tags tag : getTagsList()) {
            System.out.println(1);
            System.out.println(tag.getInf());
            System.out.println(tag.getInfo());
            System.out.println(2);
            for (Profiles profile : tag.getProfilesList()) {
                System.out.println(3);
                profile.removeTag(tag);
                System.out.println(profile.getInfo());
            }
//            tag.getProfilesList().remove(profile)
            System.out.println(4);
            deleteTag(tag);
        }
    }
}
