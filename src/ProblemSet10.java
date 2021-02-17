public class ProblemSet10 {

    public static void main(String[] args) {
        int[] a = {1,2,3,8,9,3,2,1};
        ProblemSet10 test = new ProblemSet10();
        test.maxMirror(a);
    }

    public String[] fizzBuzz(int start, int end) {
        String[] list = new String[end - start];
        if(start < end){
            int increase = start;
            for(int i = 0; i < list.length; i++){
                String valueString = "";
                if((increase) % 3 == 0){
                    valueString += "Fizz";
                }
                if((increase) % 5 == 0){
                    valueString += "Buzz";
                }
                if(valueString.equals("") || increase <= 0) {
                    valueString = String.valueOf(increase);
                }
                list[i] = valueString;
                increase++;
            }
            return list;
        }
        return null;
    }

    public int maxSpan(int[] numbers) {
        int answer = -1;
        int span = 0;
        if(numbers != null) {
            answer = span;
            for(int i = 0; i < numbers.length; i++){
                for(int j = i; j < numbers.length; j++){
                    span++;
                    if(numbers[i] == numbers[j]){
                        if(span > answer) {
                            answer = span;
                        }
                    }
                }
                span = 0;
            }
            return answer;
        }
        return answer;
    }

    public int[] fix34(int[] numbers) {
        if(numbers != null){
            int threes = 0;
            int fours = 0;
            int[] threesPlaces = new int[numbers.length];
            for(int i = 0; i < numbers.length; i++){
                if(numbers[numbers.length - 1] == 3){
                    return null;
                }
                if(numbers[i] == 3){
                    if(numbers[i + 1] == 3){
                        return null;
                    }
                    threes++;
                    threesPlaces[i] = 3;
                }
                if(numbers[i] == 4){
                    fours++;
                }
                if(threes == 0 && fours == 1){
                    return null;
                }
            }
            if(threes != fours) {
                return null;
            }
            int[] nonThrees = new int[numbers.length - (threes * 2)];
            int place = 0;
            for(int i = 0; i < numbers.length; i++){
                if (numbers[i] != 3 && numbers[i] != 4) {
                    nonThrees[place] = numbers[i];
                    place++;
                }
            }

            for(int j = 0; j < numbers.length; j++){
                if(numbers[j] == 3){
                    threesPlaces[j + 1] = 4;
                }
            }
            int morePlace = 0;
            for(int k = 0; k < threesPlaces.length; k++){
                if(threesPlaces[k] != 3 && threesPlaces[k] != 4){
                    threesPlaces[k] = nonThrees[morePlace];
                    morePlace++;
                }
            }
            return threesPlaces;
        }
        return null;
    }

    public int[] fix45(int[] numbers) {
        if(numbers != null){
            int threes = 0;
            int fours = 0;
            int[] threesPlaces = new int[numbers.length];
            for(int i = 0; i < numbers.length; i++){
                if(numbers[numbers.length - 1] == 4){
                    return null;
                }
                if(numbers[i] == 4){
                    if(numbers[i + 1] == 4){
                        return null;
                    }
                    threes++;
                    threesPlaces[i] = 4;
                }
                if(numbers[i] == 5){
                    fours++;
                }
            }
            if(threes != fours) {
                return null;
            }
            int[] nonThrees = new int[numbers.length - (threes * 2)];
            int place = 0;
            for(int i = 0; i < numbers.length; i++){
                if (numbers[i] != 4 && numbers[i] != 5) {
                    nonThrees[place] = numbers[i];
                    place++;
                }
            }

            for(int j = 0; j < numbers.length; j++){
                if(numbers[j] == 4){
                    threesPlaces[j + 1] = 5;
                }
            }
            int morePlace = 0;
            for(int k = 0; k < threesPlaces.length; k++){
                if(threesPlaces[k] != 4 && threesPlaces[k] != 5){
                    threesPlaces[k] = nonThrees[morePlace];
                    morePlace++;
                }
            }
            return threesPlaces;
        }
        return null;
    }

    public boolean canBalance(int[] numbers) {
        if(numbers != null) {
            int sum = 0;
            int half = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if (sum % 2 != 0 || numbers.length == 0) {
                return false;
            }
            half = sum / 2;
            int testSum = 0;
            int numTestedFirst = 0;
            for (int j = 0; j < numbers.length; j++) {
                testSum += numbers[j];
                numTestedFirst++;
                if (testSum == half) {
                    break;
                }
            }
            int testSumSecond = 0;
            for (int k = numTestedFirst; k < numbers.length; k++) {
                testSumSecond += numbers[k];
            }

            return testSum == testSumSecond;
        }
        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        if(inner != null && outer != null){
            if(outer.length > 0 && inner.length > 0){
                for(int i = 1; i < outer.length; i++){
                    if(outer[i] < outer[i - 1]){
                        return false;
                    }
                }
                for(int i = 1; i < inner.length; i++){
                    if(inner[i] < inner[i - 1]){
                        return false;
                    }
                }

                boolean located = false;

                for(int i = 0; i < inner.length; i++){
                    for(int j = 0; j < outer.length; j++){
                        located = outer[j] == inner[i];
                        if(located){
                            break;
                        }
                    }
                    if(!located){
                        return false;
                    }
                }
                return true;

            }
        }
        return false;
    }

    public int[] squareUp(int n) {
        if(n >= 0){
            int[][] arrays = new int[n][n];
            for(int k = n - 1; k >= 0; k--) {
                int nVal = n;
                for (int i = 0; i < arrays[k].length ; i++) {
                    arrays[k][i] = nVal;
                    nVal--;
                }
            }
            int index = n - 2;
            for(int i = 0; i <= n - 2; i++){
                for(int j = index; j >= 0; j--){
                    arrays[i][j] = 0;
                }
                index--;
            }

            int[] together = new int[n * n];
            int position = 0;
            for(int[] newArray : arrays){
                for(int number : newArray){
                    together[position] = number;
                    position++;
                }
            }
            return together;
        }
        return null;
    }

    public int[] seriesUp(int n) {
        if(n >= 0){
            int sum = 0;
            for(int i = n; i > 0; i--){
                sum += i;
            }

            int[] numbers = new int[sum];

            int index = 0;

            for(int j = 0; j <= n; j++){
                for(int k = 1; k < j + 1; k++){
                    numbers[index] = k;
                    index++;
                }

            }
            return numbers;
        }
        return null;
    }


    public int maxMirror(int[] numbers) {
        if(numbers != null){
            int maxMirror = 0;

            boolean inMirror = false;

            int mirrorCount = 0;

            for(int i = 0; i < numbers.length; i++){
                for(int j = (numbers.length - 1); j > i; j--){
                    if(numbers[i] == numbers[j]){
                        int x = 1;
                        inMirror = true;
                        while(inMirror){
                            if(numbers[i + x] == numbers[j - x] && x <= (j - i) - 1) {
                                x++;
                                mirrorCount = x;
                                System.out.println(x);
                            }
                            else{
                                inMirror = false;
                            }
                        }

                    }
                    if(mirrorCount > maxMirror){
                        maxMirror = mirrorCount;
                        mirrorCount = 0;
                    }
                }
            }
            return maxMirror;
        }
        return -1;
    }

    public int countClumps(int[] numbers) {
        if(numbers != null){
            int clumpCount = 0;
            boolean clumped = false;
            for(int i = 0; i < numbers.length - 1; i++){
                if(numbers[i] == numbers[i + 1]) {
                    if(!clumped) {
                        clumpCount++;
                        clumped = true;
                    }
                } else {
                    clumped = false;
                }
            }
            return clumpCount;
        }
        return -1;
    }
}
