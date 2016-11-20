package rnd.mate00;

import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mate00 on 2016-11-20.
 */
public class CliTest {

    @Test
    public void happyPath_TwoPathsToZipFiles() {
        String cmd = "-f1=/path/to/file1 -f2=/path/to/file2 -c=1,2,3";

        App.main(cmd.split(" "));

        assertThat(App.getColumns(), containsInAnyOrder(1, 2, 3));
        assertThat(App.getPath1(), is("/path/to/file1"));
        assertThat(App.getPath2(), is("/path/to/file2"));
    }

    @Test
    public void missingArgument_DisplayHelp() {
        String cmd = "-f1=/path/to/file1 -f2";

        App.main(cmd.split(" "));
    }

    @Test
    public void noArgumentsAtAll() {
        App.main(null);
    }
}

