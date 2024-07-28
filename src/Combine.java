import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Combine {


    static class Promotion {
        private String code;
        private ArrayList<String> notCombinableWith;

        public Promotion(String code, ArrayList<String> notCombinableWith) {
            this.code = code;
            this.notCombinableWith = notCombinableWith;
        }

        public String getCode() {
            return code;
        }

        public ArrayList<String> getNotCombinableWith() {
            return notCombinableWith;
        }
    }

    static class PromotionCombo {
        private ArrayList<String> promotionCodes;

        public PromotionCombo(ArrayList<String> promotionCodes) {
            this.promotionCodes = promotionCodes;
        }

        public ArrayList<String> getPromotionCodes() {
            return promotionCodes;
        }
    }

    public static ArrayList<PromotionCombo> allCombinablePromotions(ArrayList<Promotion> allPromotions) {
        HashMap combinableMap = new HashMap<String, ArrayList<String>>();

        for (Promotion promotion : allPromotions) {
            combinableMap.put(promotion.code, promotion.notCombinableWith);
        }

        // Recursion
        // What are the possibilities if you narrow down the problem set
        // Start with P1, then cut off P1 and only look at the subset of things that are combinable with P1
        // Example:
        // P1 [P2 P3 P4 P5] --> P1 is not combinable with P3 --> LEFT BRANCH --> P1 [P2 P4 P5] (remove P3)
        //                                                      --> RIGHT BRANCH --> [P3 P2 P4 P5] (remove P1)
        // > LEFT BRANCH: Recurse with set [P2 P4 P5]
        // P2 [P4 P5] --> P2 is not combinable with P4/P5 --> P2 [] (remove P4/P5)
        //                                                  --> P4 P5 (remove P2)
        // >> LEFT BRANCH: Recurse with set []
        // Set has zero or only one member - base case. Return the member and build the array
        // as you walk back up the recursion.
        // The answer we get this iteration is: P1 P2

        HashSet fullSet = new HashSet<String>(combinableMap.keySet());

        recurse(combinableMap, fullSet);

        //todo - returns null because not finished implementing
        return null;
    }

    public static HashSet<String> recurse(HashMap<String, ArrayList<String>> combinableMap, HashSet<String> input) {
        if (input.size() == 0) {
            return null;
        }

        String focusElement = input.iterator().next();
        ArrayList<String> incompatibleElements = combinableMap.get(focusElement);

        // Remove incompatible elements
        HashSet<String> rightBranch = new HashSet<>();
        if (incompatibleElements.size() > 0) {
            rightBranch.addAll(input);
            rightBranch.removeAll(incompatibleElements);
            // Temporarily remove focus element so it doesn't go into the recursion
            rightBranch.remove(focusElement);
            recurse(combinableMap, rightBranch);
            // Add back focus element
            rightBranch.add(focusElement);
        }
        // Remove focus element
        HashSet<String> leftBranch = new HashSet<>();
        leftBranch.addAll(input);
        leftBranch.remove(focusElement);
        recurse(combinableMap, leftBranch);

        //todo - returns null because not finished implementing
        return null;
    }

    public static ArrayList<PromotionCombo> combinablePromotions(String promotionCode, ArrayList<Promotion> allPromotions) {
        // Todo - this can easily be derived from allCombinablePromotions()
        return null;
    }
}
