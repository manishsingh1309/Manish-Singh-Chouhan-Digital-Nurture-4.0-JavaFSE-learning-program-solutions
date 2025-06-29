import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemoApp {

    private static final Logger log = LoggerFactory.getLogger(LogDemoApp.class);

    public static void main(String[] args) {
        log.error("❌ Critical system error encountered. Please check configuration.");
        log.warn("⚠️ Memory usage is approaching the upper limit.");
    }
}
