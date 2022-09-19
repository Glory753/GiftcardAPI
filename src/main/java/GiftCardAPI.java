import Model.Giftcard;
import Service.GiftcardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import java.sql.SQLException;
import io.javalin.core.JavalinConfig;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.util.log.Log;

import java.time.LocalDateTime;

import static org.apache.logging.log4j.Logger.*;

public class GiftCardAPI {

    public static void main(String[] args) throws SQLException {
        GiftcardService gs = new GiftcardService();
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        app.start(9000);

        app.get("/giftcards/", ctx -> {
            ctx.json(gs.getAllGiftcards());
        });
        app.get("/giftcards/giftcardname/{name}", ctx ->
        {
            ctx.json(gs.getAllGiftcardsByName(ctx.pathParam("name")));
        });

        app.get("giftcards/giftid/{id}", ctx -> {
            ctx.json(gs.getAllGiftcardsByGiftID(Integer.parseInt(ctx.pathParam("id"))));
        });
        app.post("giftcards", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Giftcard requestGiftcard = mapper.readValue(ctx.body(), Giftcard.class);
            gs.addGiftcard(requestGiftcard.getName(), requestGiftcard.getGiftID(), requestGiftcard.getDescription(), requestGiftcard.getUrl());
        });
        app.delete("/giftcards/giftid/{id}", ctx -> {
            ctx.json(gs.getAllGiftcardsByGiftID(Integer.parseInt(ctx.pathParam("id"))));
        });
    }
}

//Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).start(7070);//