import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("CreditCardNumber.txt");


        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String number = sc.nextLine();
                ILuhnAlgorithm checker = new LuhnAlgorithm(number);

                if(checker.validation()){
                    System.out.println("Credit card number --> " + number + "  is valid");
                }else{
                    System.out.println("Credit card number --> " + number + "  is not valid");

                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}