package install.bll;

import install.bll.createFolder.CreateDirectoryAppData;
import install.bll.springConf.InstallDB;
import install.bo.Profiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author kevin
 *
 */
public class Install {

    private static Logger log = LogManager.getLogger(Install.class);
    private static Install i = null;

    private Install() {}

    public static Install getInstance() {
        if (i == null) {
            i = new Install();
        }
        return i;
    }

    /**
     * create appdata files needed by other part of the application
     * create and setup database with spring-data and create the test printer
     */
    public void setup() {
        System.out.println("tata");
            CreateDirectoryAppData.create();
            System.out.println("toto");
            Profiles p = InstallDB.create();
            System.out.println(p);
    }
}
