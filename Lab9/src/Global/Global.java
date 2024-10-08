<<<<<<< HEAD
package Global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Global {
    public static boolean ignoreCase(String pre, String str) {
        Pattern p = Pattern.compile(Pattern.quote(pre), Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        return m.find();
    }
=======
package Global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Global {
    public static boolean ignoreCase(String pre, String str) {
        Pattern p = Pattern.compile(Pattern.quote(pre), Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        return m.find();
    }
>>>>>>> 3e5ea4afe43f2df485cc3e0318a4e6114beb1a57
}