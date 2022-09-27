import com.monitor.service.PriceService;
import com.monitor.service.Watcher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class WatcherTests {

    @Test
    public void testLaunch(){
//        new Watcher().launch();
        new PriceService().getPricesByDate("dssa", 1,1);

    }
}
