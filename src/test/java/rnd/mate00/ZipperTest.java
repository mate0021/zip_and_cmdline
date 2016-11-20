package rnd.mate00;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by mate00 on 2016-11-19.
 */
public class ZipperTest {

    private static final String TEST_ZIP = "src/test/resources/pom.zip";

    private static final String UNPACKED_FILE = "src/test/resources/pom.xml";

    @After
    public void tearDown() {
        File extracted = new File(UNPACKED_FILE);
        if (extracted.exists()) {
            extracted.delete();
        }
    }

    @Test
    public void zipExists() {
        File zip = new File(TEST_ZIP);

        assertTrue(zip.exists());
    }

    @Test
    public void shouldUnzipFile() throws ZipException {
        ZipFile zip = new ZipFile(new File(TEST_ZIP));

        zip.extractAll("src/test/resources/");

        File extracted = new File(UNPACKED_FILE);
        assertTrue(extracted.exists());
    }

    @Test
    public void unzipAlreadyExisting() throws ZipException, IOException {
        File f = new File(UNPACKED_FILE);
        if (!f.exists()) {
            f.createNewFile();
        }
        ZipFile zip = new ZipFile(new File(TEST_ZIP));

        zip.extractAll("src/test/resources");
    }
}
