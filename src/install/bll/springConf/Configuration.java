package install.bll.springConf;

/**
 * @author kevin
 *
 */
public class Configuration {

    private String user;
    private String pass;
    private String url;

    /**
     * create configuration with parameter
     * @param user
     * @param pass
     * @param url
     */
    public Configuration(String user, String pass, String url) {
        this.user = user;
        this.pass = pass;
        this.url = url;
    }

    /**
     *
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @return pass
     */
    public String getPass() {
        return pass;
    }

    /**
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }
}
