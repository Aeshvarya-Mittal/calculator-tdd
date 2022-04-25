public class StringCalculator {

    public static int add(String text) {
        if (text.equals("")) {
            return 0;
        }
        else{
            String delimiter = ",";
            if(text.matches("//(.*)\n(.*)")){
                delimiter = Character.toString(text.charAt(2));
                text = text.substring(4);
            }
            String[] numList = getNumbers(text, delimiter+ "|\n");
            return sum(numList);
        }
    }

    private static String[] getNumbers(String numbers, String divider){
        return numbers.split(divider);
    }
    private static int toInt(String number){
        return Integer.parseInt(number);
    }

    private static int sum(String[] numbers){
        int total = 0;
        StringBuilder negative = new StringBuilder();

        for(String number : numbers){
            if(toInt(number) < 0){
                if(negative.toString().equals(""))
                    negative = new StringBuilder(number);
                else
                    negative.append(",").append(number);
            }

            if(toInt(number)>0)
                total += toInt(number);
        }

        if(!negative.toString().equals("")){
            throw new IllegalArgumentException("Negatives not allowed: " + negative);
        }
        return total;
    }
}
