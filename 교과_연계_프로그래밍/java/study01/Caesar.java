import java.util.Scanner;
import java.util.InputMismatchException;

public class Caesar {
    public static void main(String[] args) {
        String content;
        int counts;
       
        Scanner input = new Scanner(System.in);
        

        System.out.print("Input Text: ");
        content = input.nextLine();
        while(true) {
            try {    
                System.out.print("Input Counts: ");
                counts = input.nextInt();
                input.close();
                break;
            } catch(InputMismatchException e) {
                System.out.print("Please input counts by int.\n\n");
                input.next();
                continue;
            }
        }
        
        String encodedContent = Encoder.Caesar(content, counts);
        String decodedContent = Decoder.Caesar(encodedContent, counts);
        
        System.out.printf("Input Text: %s\n", content);
        System.out.printf("Encoded Text: %s\n", encodedContent);
        System.out.printf("Decoded Text: %s\n", Decoder.Caesar(decodedContent, counts));
    }
}
