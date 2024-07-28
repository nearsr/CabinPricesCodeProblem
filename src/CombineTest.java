import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombineTest {
    @Test
    void exampleProblem() {
        Combine.Promotion p1 = new Combine.Promotion("P1", new ArrayList<>(List.of("P3"))); // P1 is not combinable with P3
        Combine.Promotion p2 = new Combine.Promotion("P2", new ArrayList<>(List.of("P4", "P5"))); // P2 is not combinable with P4 and P5
        Combine.Promotion p3 = new Combine.Promotion("P3", new ArrayList<>(List.of("P1"))); // P3 is not combinable with P1
        Combine.Promotion p4 = new Combine.Promotion("P4", new ArrayList<>(List.of("P2"))); // P4 is not combinable with P2
        Combine.Promotion p5 = new Combine.Promotion("P5", new ArrayList<>(List.of("P2"))); // P5 is not combinable with P2

        ArrayList<Combine.Promotion> allPromotions = new ArrayList<>();
        allPromotions.add(p1);
        allPromotions.add(p2);
        allPromotions.add(p3);
        allPromotions.add(p4);
        allPromotions.add(p5);

        ArrayList<Combine.PromotionCombo> allCombo = Combine.allCombinablePromotions(allPromotions);

        //todo - finish implementing

        Combine.PromotionCombo pc1 = new Combine.PromotionCombo(new ArrayList<>(List.of("P1", "P2")));
        Combine.PromotionCombo pc2 = new Combine.PromotionCombo(new ArrayList<>(List.of("P1", "P4", "P5")));
        Combine.PromotionCombo pc3 = new Combine.PromotionCombo(new ArrayList<>(List.of("P2", "P3")));
        Combine.PromotionCombo pc4 = new Combine.PromotionCombo(new ArrayList<>(List.of("P3", "P4", "P5")));
    }
}