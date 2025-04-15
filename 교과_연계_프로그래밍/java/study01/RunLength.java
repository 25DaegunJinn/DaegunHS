import java.util.Scanner;

public class RunLength {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String content;
        
        System.out.print("Input Text: ");
        content = input.nextLine();
        input.close();

        String encodedContent = Encoder.RunLength(content);
        String decodedContent = Decoder.RunLength(encodedContent);
        
        System.out.printf("Original Data: %s\n", content);
        System.out.printf("Encoded Data: %s\n", encodedContent);
        System.out.printf("Decoded Data: %s\n", decodedContent);
    }
}
