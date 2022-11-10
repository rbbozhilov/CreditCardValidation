import java.util.ArrayList;
import java.util.List;


public class LuhnAlgorithm implements ILuhnAlgorithm
{
    private String creditCardNumber;

    public LuhnAlgorithm(String creditCardNumber){

        this.creditCardNumber = creditCardNumber;

    }


    public boolean validation(){

        return this.luhnAlgorithm() % 10 == 0;
    }


    private int luhnAlgorithm(){

        List<Integer> numbers = new ArrayList<>();
        List<Integer> finalNumbers = new ArrayList<>();

        numbers = this.getListNumbers();

        if(numbers.size() <=1){
            return -1;
        }

        boolean position = false;

        for(int i=numbers.size()-1;i>=0;i--){

            if(position == false){
                finalNumbers.add(numbers.get(i));
                position = true;
            }else{

                int currentSum = numbers.get(i) * 2;

                if(currentSum > 9){
                    String numberToString =Integer.toString(currentSum);
                    finalNumbers.add(Character.getNumericValue(numberToString.charAt(0)) + Character.getNumericValue(numberToString.charAt(1)));
                }else{
                    finalNumbers.add(currentSum);
                }
                position = false;
            }
        }
        return this.sumNumbers(finalNumbers);
    }


    private int sumNumbers(List<Integer> finalNumbers){

        int sum = 0;

        for(int i=0;i<finalNumbers.size();i++){
            sum += finalNumbers.get(i);
        }

        return sum;
    }


    private List<Integer> getListNumbers(){

        List<Integer> numbers = new ArrayList<>();

        for(int i=0;i<this.creditCardNumber.length();i++){

            //Checking if the char is number if is not continue the loop
            if(!Character.isDigit(this.creditCardNumber.charAt(i))){
                continue;
            }

            //Convert char to int
            int currentNumber = Character.getNumericValue(this.creditCardNumber.charAt(i));

            numbers.add(currentNumber);

        }

        return numbers;
    }
}
