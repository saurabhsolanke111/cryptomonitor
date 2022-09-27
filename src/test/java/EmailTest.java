import com.monitor.entities.EmailDetails;
import com.monitor.service.EmailService;
import org.junit.jupiter.api.Test;

public class EmailTest {
    @Test
    public void testEmailService(){
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient("xyz111@yopmail.com");
        emailDetails.setMsgBody(" checking if it working or not");
        emailDetails.setSubject(" test mail ");
        new EmailService().send(emailDetails);
    }
}
