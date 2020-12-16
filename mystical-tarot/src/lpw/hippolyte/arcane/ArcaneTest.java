package lpw.hippolyte.arcane;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArcaneTest {

    Arcane bateleur = new Arcane(1, "Bateleur", "Description de l'Arcane", "./assets/images/1.jpg");

    @Test
    void addDescription() {
        String desc = "Modification d'une description";
        Assertions.assertEquals(bateleur.addDescription(desc), desc);
    }

    @Test
    void delete() {
        Assertions.assertTrue(bateleur.delete());
    }

    @Test
    void contentCard() {
        String contentArcane = bateleur.toString();
        Assertions.assertEquals(contentArcane, "Vous avez pioché l'Arcane n°I, Bateleur");
    }
}
