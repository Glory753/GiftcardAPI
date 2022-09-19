import DAO.GiftcardRepository;
import Model.Giftcard;
import Service.GiftcardService;
//import jdk.jfr.internal.jfc.model.Constraint;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;

//import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;

public class GiftcardServiceTest {

    @Test
    public void addWhenGiftcardExistsDoNotAdd() throws SQLException {
        GiftcardRepository gr;
        gr = Mockito.mock(GiftcardRepository.class);
        Giftcard g = new Giftcard("TestGiftcard", 1, null, null);
        Mockito.when(gr.getGiftcardByName("TestGiftcard")).thenReturn(g);
        GiftcardService gs = new GiftcardService(gr);
        //Mockito.verify(gr).addGiftcard(g);
        Mockito.verify(gr, never()).addGiftcard(g);
    }
    /*@Test
    public void addGiftcardWhenGiftcardDoesNotExistAdd() throws SQLException {
        GiftcardRepository gr;
        gr = Mockito.mock(GiftcardRepository.class);
        Giftcard g =new Giftcard("TestGiftcard", 1, null, null);
        Mockito.when(gr.getGiftcardByName("TestGiftcard")).thenReturn(null);
        GiftcardService gs = new GiftcardService(gr);
        gs.addGiftcard("TestGiftcard", 1, null, requestGiftcard.getUrl());
        Mockito.verify(gr).addGiftcard(any(Giftcard.class));
        //Mockito.verify(gr).addGiftcard(Constraint.any(Giftcard.class));
    }*/
}

