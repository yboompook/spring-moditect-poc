package install.bo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Profiles.
 *
 * @author kevin
 */
@Entity
public class Profiles {
    @Id
    @PrimaryKeyJoinColumn
    @Column(name = "id_profile", length = 21, nullable = false, unique = true)
    private String idProfile;
    @Column(length = 31, nullable = false)
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable
    private List<Tags> tags = new ArrayList<>();

    /**
     * Instantiates a new Profiles.
     */
    public Profiles() {
    }

    /**
     * Instantiates a new Profiles.
     *
     * @param name     the name
     */
    public Profiles(String idProfile, String name) {
        setIdProfile(idProfile);
        setName(name);
    }

    /**
     * Gets id profile.
     *
     * @return the id profile
     */
    public String getIdProfile() {
        return idProfile;
    }

    /**
     * Sets id profile.
     *
     * @param idProfile the id profile
     */
    public void setIdProfile(String idProfile) {
        this.idProfile = idProfile;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void addTag(Tags tag) {
        this.tags.add(tag);
        tag.getProfilesList().add(this);
    }

    public void removeTag(Tags tag) {
        this.tags.remove(tag);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Profiles{");
        sb.append("idProfile=").append(idProfile);
        sb.append(", name='").append(name).append('\'');
        sb.append(", tags=").append(tags);
        sb.append('}');
        return sb.toString();
    }

    public String getInfo() {
        final StringBuilder sb = new StringBuilder("Profiles{");
        sb.append("idProfile=").append(idProfile);
        sb.append(", name='").append(name).append('\'');
        for (Tags tag : tags) {
            sb.append(", tags=").append(tag.getInfo());
        }
        sb.append('}');
        return sb.toString();
    }

}
