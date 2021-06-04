import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {

    public static boolean matchIngredient(String ingredientLine){
        String ingredientRegex = "^\\d+,[A-ZÖÄÜ][a-züäö]+,\\d+,(Stück|Gramm),((0[1-9])|([1-2]\\d)|(3[01]))\\.(0[1-9]|1[12])\\.(19|20)\\d{2}";
        Pattern pattern = Pattern.compile(ingredientRegex);
        Matcher matcher = pattern.matcher(ingredientLine);
        return matcher.matches();
    }
}