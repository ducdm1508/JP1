package Global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Global {
    public static boolean ignoreCase(String reg, String str) {
        Pattern pattern = Pattern.compile(Pattern.quote(reg), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
