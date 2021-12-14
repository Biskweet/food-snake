import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;
import java.awt.Robot;

public class AutoKeyPresser {
    public static void run() {
        Runnable autoPress = new Runnable() {
            @Override
            public void run() {
                Robot autoKey;
                try {
                    autoKey = new Robot();
                } catch (Exception error) {
                    System.out.println("Error.");
                    return;
                }

                while (!Engine.over) {
                    while (Engine.pressing) {
                        autoKey.keyPress(KeyEvent.VK_ENTER);
                        try { TimeUnit.MILLISECONDS.sleep(7); } catch (Exception err) {}
                    }
                }
            }
        };
        Thread thr = new Thread(autoPress);
        thr.run();
    }
}
