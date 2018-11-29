package install.bll.springConf;

import install.bo.Profiles;
import install.bo.Tags;
import install.service.ProfilesManager;
import install.ui.Toolbox.ValueTB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author kevin
 *
 */
public class InstallDB {

    private static Logger log = LogManager.getLogger(InstallDB.class);

    /**
     * create database, user and register first printer to test printer installation
     * @return printer test
     */
    public static Profiles create()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        ValueTB.setContext(context);

        ProfilesManager profilesM = context.getBean(ProfilesManager.class);

        Profiles p = new Profiles("test", "test");
        Tags t = new Tags("toto", true);
        p.addTag(t);
        profilesM.addProfile(p);

        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:file:" + Paths.get(System.getenv("APPDATA"), "certytech", "certyprint", "db") + "/certyprint;CIPHER=AES;AUTO_SERVER=TRUE", "sa", " ");
        } catch (SQLException e) {
            log.fatal("creation h2 database fail, error : " + e);
        }
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            log.error("statement creation error : " + e);
        }
        try {
            statement.execute("CREATE USER CORE PASSWORD 'CORE'");
        } catch (SQLException e) {
            log.fatal("create user core fail, error : " + e);
        }
        try {
            statement.execute("GRANT ALL ON documents, printers, profiles, settings to CORE");
        } catch (SQLException e) {
            log.fatal("grant right to core fails, error : " + e);
        }

        System.out.println(p.toString());

        return p;
    }

}
