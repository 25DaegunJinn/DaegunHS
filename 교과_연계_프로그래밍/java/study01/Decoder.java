import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;

public class Decoder {
    public static String RunLength(String content) {
        Pattern pattern = Pattern.compile("(\\d+)(\\D)");
        Matcher matcher = pattern.matcher(content);
        StringBuffer decoded = new StringBuffer();

        int lastEnd = 0;

        while(matcher.find()) {
            decoded.append(content, lastEnd,  matcher.start());
            int count = Integer.parseInt(matcher.group(1));
            char ch = matcher.group(2).charAt(0);

            for(int i = 0; i < count; i++) {
                decoded.append(ch);
            }
            lastEnd = matcher.end();
        }
    decoded.append(content.substring(lastEnd));
    return decoded.toString();
    }

    public static String Caesar(String content, int counts) {
        String[] caps = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] smalls = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] elements = content.split("");
        for(int index = 0; index < elements.length; index++) {
            if(Arrays.asList(caps).indexOf(elements[index]) != -1) {
                
                int targetIndex = Arrays.asList(caps).indexOf(elements[index]);
                targetIndex = targetIndex - counts < 0 ? caps.length + targetIndex - counts : targetIndex - counts;
                elements[index] = caps[targetIndex];

            } else if(Arrays.asList(smalls).indexOf(elements[index]) != -1) {

                int targetIndex = Arrays.asList(smalls).indexOf(elements[index]);
                targetIndex = targetIndex - counts < 0 ? smalls.length + targetIndex - counts: targetIndex - counts;
                elements[index] = smalls[targetIndex];

            }
        }
    return String.join("", elements);
    }
}
