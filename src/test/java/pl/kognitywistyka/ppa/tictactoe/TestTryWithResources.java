package pl.kognitywistyka.ppa.tictactoe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by pwilkin on 24.02.2022.
 */
public class TestTryWithResources {

    @Test
    public void testTryWithResources() {
        File file = new File("tst");
        try (FileInputStream fis = new FileInputStream(file)) {
            int rd = fis.read();
            Assertions.fail("The file is not there, what are you reading?");
        } catch (IOException e) {
            // good, good!
        }
        FileInputStream fis2 = null;
        try {
            fis2 = new FileInputStream(file);
            int rd = fis2.read();
            Assertions.fail("The file is not there, what are you reading?");
        } catch (IOException e) {
            // good, good!
        } finally {
            if (fis2 != null) {
                try {
                    fis2.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }

}
