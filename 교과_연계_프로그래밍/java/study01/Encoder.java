import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.regex.Matcher;

public class Encoder {
    public static String RunLength(String content) {
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(content);
        StringBuilder encoded = new StringBuilder();

        while(matcher.find()) {
            String group = matcher.group();
            if(group.length() > 1)
                encoded.append(group.length()).append(group.charAt(0));
            else
                encoded.append(group.charAt(0));
        }
        return encoded.toString();
    }
    
    public static String Caesar(String content, int counts) {
        String[] caps = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] smalls = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] elements = content.split("");
        for(int index = 0; index < elements.length; index++) {
            if(Arrays.asList(caps).indexOf(elements[index]) != -1) {
                
                int targetIndex = Arrays.asList(caps).indexOf(elements[index]);
                targetIndex = (targetIndex + counts) % 26;
                elements[index] = caps[targetIndex];

            } else if(Arrays.asList(smalls).indexOf(elements[index]) != -1) {

                int targetIndex = Arrays.asList(smalls).indexOf(elements[index]);
                targetIndex = (targetIndex + counts) % 26;
                elements[index] = smalls[targetIndex];

            }
        }
    return String.join("", elements);
    }
}
