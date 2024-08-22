package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author diego
 */
public class ValidacaoUtil {
    
    public boolean validarEmail(String email) {
        String regex = "^[\\w-\\.]+@[\\w-\\.]+\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    

    
}
