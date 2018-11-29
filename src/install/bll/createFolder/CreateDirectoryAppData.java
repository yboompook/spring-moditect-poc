package install.bll.createFolder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author kevin
 *
 */
public class CreateDirectoryAppData {

    private static Logger log = LogManager.getLogger(CreateDirectoryAppData.class);

    /**
     * Create folder into AppData/Roaming to install and setup certyprint
     */
    public static void create()
    {
        Path path = Paths.get(System.getenv("APPDATA"), "certytech");
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            log.fatal("directory creation of appdata/certytech impossible, error : " + e);
        }

        Path db = Paths.get(path.toString(), "db");
        try {
            Files.createDirectories(db);
        } catch (IOException e) {
            log.fatal("directory creation of appdata/certytech/db impossible, error : " + e);
        }
    }
}
