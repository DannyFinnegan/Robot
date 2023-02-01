import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    Robot buddy = new Robot("Buddy");


    @Test
    public void testgetName() {
        assertEquals("Buddy", buddy.getName());
    }

    @Test
    public void testisNotWorking() {
        assertFalse(buddy.isWorking());
    }

    @Test
    public void testIsWorking() {
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void getWorkingMessageTest() {
        buddy.talkToRobot();
        assertEquals("I am in working mode", buddy.getWorkMsg());
    }

    @Test()
    //@DisplayName("Get Working message fail, catch exception")
    public void getWorkMsgNegative() {
        assertThrows(IllegalStateException.class, () -> {
            buddy.getWorkMsg();
        });
    }

    @Test
    public void testNameFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            Robot chuck = new Robot("");
        });
    }

    @Test
    void timeoutExceeded() {
        assertTimeout(Duration.ofMillis(10), () ->{
            buddy.waitTillWorking();
        });
    }

}