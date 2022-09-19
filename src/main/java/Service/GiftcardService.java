package Service;

import DAO.GiftcardRepository;
import Model.Giftcard;
import Util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GiftcardService {

    GiftcardRepository gr;

    GiftcardService gs;
    Connection conn = ConnectionUtil.getConnection();

    public GiftcardService() throws SQLException {
        gr = new GiftcardRepository();
    }
    public GiftcardService( GiftcardRepository gr) throws SQLException {
        this.gr = gr;
    }
    public List<Giftcard> getAllGiftcards() {
        return gr.getAllGiftcards();
    }

    public List<Giftcard> getAllGiftcardsByGiftID(int id) {
        return gr.getAllGiftcardsByGiftID(id);
    }

    public List<Giftcard> getAllGiftcardsByName(String name) { return gr.getAllGiftcardsByName(name); }

    //public List<Giftcard> getDescriptionByName(String name) { return (List<Giftcard>) gr.getDescriptionByName(name); }
    public void addGiftcard(String name, int id, String description, String url) throws SQLException {
        Giftcard existingGiftcard = gr.getGiftcardByName(name);
        if(existingGiftcard == null) {
            Giftcard newGiftcard = new Giftcard(name, id, description, url );
            gr.addGiftcard(newGiftcard);
        }else{

        }
        conn.commit();
    }

}
