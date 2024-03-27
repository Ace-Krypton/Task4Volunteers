import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1
        String result = generateAlternatingString(8);
        System.out.println(result);

        //Task 2
        System.out.println("The sum of the numbers in the array is: " + calcSumArray(new int[]{0, 1, 2, 3, 4}));

        // Task 3
        int[] arrResult = generateArray(4);

        System.out.println("Generated Array:");
        System.out.println(Arrays.toString(arrResult));

        int sum = Arrays.stream(arrResult).sum();
        System.out.println("Sum of Array Elements: " + sum);

        // Task 4
        int n = 213;
        int largestFamilyNumber = findLargestFamilyNumber(n);
        System.out.println("Largest number in the family of " + n + ": " + largestFamilyNumber);

        n = 553;
        largestFamilyNumber = findLargestFamilyNumber(n);
        System.out.println("Largest number in the family of " + n + ": " + largestFamilyNumber);

        // Task 5
        System.out.println(repFirstChar("test"));
    }

    // Task 1
    public static String generateAlternatingString(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('+');

        for (int i = 1; i < n; ++i) {
            if (i % 2 == 0) sb.append('+');
            else sb.append('-');
        }

        return sb.toString();
    }

    // Task 2
    public static int calcSumArray(int[] arr) {
        int result = 0;
        for (int j : arr)  result += j;
        return result;
    }

    // Task 3
    public static int[] generateArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n - 1; ++i) arr[i] = i + 1;
        arr[n - 1] = -(n * (n - 1)) / 2;
        shuffle(arr);
        return arr;
    }

    private static void shuffle(int[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; --i) {
            int index = rnd.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    // Task 4
    public static int findLargestFamilyNumber(int n) {
        int[] digitCount = new int[10];
        int num = n;
        while (num > 0) {
            int digit = num % 10;
            digitCount[digit]++;
            num /= 10;
        }

        int largestFamilyNumber = 0;
        for (int i = 9; i >= 0; --i) {
            while (digitCount[i] > 0) {
                largestFamilyNumber = largestFamilyNumber * 10 + i;
                digitCount[i]--;
            }
        }

        return largestFamilyNumber;
    }

    // Task 5
    public static String repFirstChar(String s) {
        char c = s.charAt(0);

        if (c >= 'A' && c <= 'Z')
            return "upper";
        else if (c >= 'a' && c <= 'z')
            return "lower";
        else if (c >= '0' && c <= '9')
            return "digit";
        else return "other";
    }
}
