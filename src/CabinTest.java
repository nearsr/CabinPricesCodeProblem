import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

class CabinTest {
    @Test
    void exampleProblem() {
        Cabin.Rate r1 = new Cabin.Rate("M1", "Military");
        Cabin.Rate r2 = new Cabin.Rate("M2", "Military");
        Cabin.Rate r3 = new Cabin.Rate("S1", "Senior");
        Cabin.Rate r4 = new Cabin.Rate("S2", "Senior");

        Cabin.CabinPrice p1 = new Cabin.CabinPrice("CA", "M1", new BigDecimal("200.00"));
        Cabin.CabinPrice p2 = new Cabin.CabinPrice("CA", "M2", new BigDecimal("250.00"));
        Cabin.CabinPrice p3 = new Cabin.CabinPrice("CA", "S1", new BigDecimal("225.00"));
        Cabin.CabinPrice p4 = new Cabin.CabinPrice("CA", "S2", new BigDecimal("260.00"));
        Cabin.CabinPrice p5 = new Cabin.CabinPrice("CB", "M1", new BigDecimal("230.00"));
        Cabin.CabinPrice p6 = new Cabin.CabinPrice("CB", "M2", new BigDecimal("260.00"));
        Cabin.CabinPrice p7 = new Cabin.CabinPrice("CB", "S1", new BigDecimal("245.00"));
        Cabin.CabinPrice p8 = new Cabin.CabinPrice("CB", "S2", new BigDecimal("270.00"));

        ArrayList rates = new ArrayList<Cabin.Rate>();
        rates.add(r1);
        rates.add(r2);
        rates.add(r3);
        rates.add(r4);

        ArrayList prices = new ArrayList<Cabin.CabinPrice>();
        prices.add(p1);
        prices.add(p2);
        prices.add(p3);
        prices.add(p4);
        prices.add(p5);
        prices.add(p6);
        prices.add(p7);
        prices.add(p8);

        ArrayList<Cabin.BestGroupPrice> outputList = Cabin.getBestGroupPrices(rates, prices);

        // Expected results
        Cabin.BestGroupPrice gp1 = new Cabin.BestGroupPrice("CA", "M1", new BigDecimal("200.00"), "Military");
        Cabin.BestGroupPrice gp2 = new Cabin.BestGroupPrice("CA", "S1", new BigDecimal("225.00"), "Senior");
        Cabin.BestGroupPrice gp3 = new Cabin.BestGroupPrice("CB", "M1", new BigDecimal("230.00"), "Military");
        Cabin.BestGroupPrice gp4 = new Cabin.BestGroupPrice("CB", "S1", new BigDecimal("245.00"), "Senior");

        Assert.assertTrue(outputList.contains(gp1));
        Assert.assertTrue(outputList.contains(gp2));
        Assert.assertTrue(outputList.contains(gp3));
        Assert.assertTrue(outputList.contains(gp4));
    }
}