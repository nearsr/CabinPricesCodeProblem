import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Cabin {
    public static ArrayList<BestGroupPrice> getBestGroupPrices(ArrayList<Rate> rates, ArrayList<CabinPrice> prices) {
        HashMap rateCodeMap = new HashMap<String, String>();

        // Generate map of rateCodes
        for (Rate rate : rates) {
            rateCodeMap.putIfAbsent(rate.rateCode, rate.rateGroup);
        }

        // Key: "CA-Military" (cabinCode and rate group, Value: BestGroupPrice object
        HashMap bestPricesMap = new HashMap<String, BestGroupPrice>();

        for (CabinPrice price : prices) {
            String mapKey = price.cabinCode + "_" + rateCodeMap.get(price.rateCode);

            if (bestPricesMap.containsKey(mapKey)) {
                BigDecimal otherPrice = ((BestGroupPrice) bestPricesMap.get(mapKey)).getPrice();

                // If the new price is less, replace the old one in the map.
                if (price.price.compareTo(otherPrice) == -1) {
                    bestPricesMap.put(mapKey, new BestGroupPrice(price.cabinCode, price.rateCode, price.price, (String) rateCodeMap.get(price.rateCode)));
                }
            } else {
                bestPricesMap.putIfAbsent(mapKey, new BestGroupPrice(price.cabinCode, price.rateCode, price.price, (String) rateCodeMap.get(price.rateCode)));
            }
        }

        return new ArrayList<BestGroupPrice>(bestPricesMap.values());
    }

    public static class Rate {
        private String rateCode;
        private String rateGroup;

        public Rate(String rateCode, String rateGroup) {
            this.rateCode = rateCode;
            this.rateGroup = rateGroup;
        }
    }

    public static class CabinPrice {
        private String cabinCode;
        private String rateCode;
        private BigDecimal price;

        public CabinPrice(String cabinCode, String rateCode, BigDecimal price) {
            this.cabinCode = cabinCode;
            this.rateCode = rateCode;
            this.price = price;
        }
    }

    public static class BestGroupPrice {
        private String cabinCode;
        private String rateCode;
        private BigDecimal price;
        private String rateGroup;

        public BigDecimal getPrice() {
            return price;
        }

        public BestGroupPrice(String cabinCode, String rateCode, BigDecimal price, String rateGroup) {
            this.cabinCode = cabinCode;
            this.rateCode = rateCode;
            this.price = price;
            this.rateGroup = rateGroup;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BestGroupPrice that = (BestGroupPrice) o;
            return Objects.equals(cabinCode, that.cabinCode) && Objects.equals(rateCode, that.rateCode) && Objects.equals(price, that.price) && Objects.equals(rateGroup, that.rateGroup);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cabinCode, rateCode, price, rateGroup);
        }
    }
}


