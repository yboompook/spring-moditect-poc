package install.bo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import install.bo.Profiles;

/**
 * The type Tags.
 *
 * @author kevin
 */
@Entity
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private int idTag;
    @Column(length = 64, nullable = false)
    private String name;
    @Column(nullable = false)
    private boolean privacy;
    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private List<Profiles> profilesList = new ArrayList<>();

    public Tags() {
    }

    public Tags(String name, boolean privacy) {
        setName(name);
        setPrivacy(privacy);
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public List<Profiles> getProfilesList() {
        return profilesList;
    }

    public void setProfilesList(List<Profiles> profilesList) {
        this.profilesList = profilesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tags tags = (Tags) o;
        return idTag == tags.idTag &&
                privacy == tags.privacy &&
                Objects.equals(name, tags.name) &&
                Objects.equals(profilesList, tags.profilesList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTag, name, privacy, profilesList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tags{");
        sb.append("idTag=").append(idTag);
        sb.append(", name='").append(name).append('\'');
        sb.append(", privacy=").append(privacy);
        sb.append(", profilesList=").append(profilesList);
        sb.append('}');
        return sb.toString();
    }

    public String getInf() {
        final StringBuilder sb = new StringBuilder("Tags{");
        sb.append("idTag=").append(idTag);
        sb.append(", name='").append(name).append('\'');
        sb.append(", privacy=").append(privacy);
        sb.append('}');
        return sb.toString();
    }

    public String getInfo() {
        final StringBuilder sb = new StringBuilder("Tags{");
        sb.append("idTag=").append(idTag);
        sb.append(", name='").append(name).append('\'');
        sb.append(", privacy=").append(privacy);
        for (Profiles profile : getProfilesList())
        {
            sb.append(", profile=").append(profile.getName());
        }
        sb.append('}');
        return sb.toString();
    }
}
