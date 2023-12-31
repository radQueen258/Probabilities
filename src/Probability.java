import java.util.Scanner;

public class Probability {
    public static void main(String[] args) {
        Scanner radka = new Scanner(System.in);

        System.out.println("Does it allow repetitions ?" );
        System.out.println("[Y] for Yes / [N] for No");
        char wish = radka.next().charAt(0);


        System.out.println("For Placements[1] - Permutation[2] - Combinations[3]");
        int x = radka.nextInt();


        switch (wish) {
            case 'Y':
                switch (x) {
                    case 1 -> {
                        System.out.println("What is the n ?");
                        int n = radka.nextInt();

                        System.out.println("What is the k ?");
                        int k = radka.nextInt();

                        System.out.println(placementRepetition(n,k));
                    }

                    case 2 -> {
                        System.out.println("What is the n ?");
                        int n = radka.nextInt();

                        System.out.print("Enter the number of k values: ");
                        int k = radka.nextInt();

                        System.out.println();
                        System.out.println("THE VALUES OF k MUST BE SUMMING UP TO n");

                        int[] kValues = new int[k];
                        for (int i = 0; i < k; i ++) {
                            System.out.print("Enter the value of n" + (i + 1) + ": ");
                            kValues[i] = radka.nextInt();
                        }
                        System.out.println(permutationRepetition(n,kValues));
                    }

                    case 3 -> {
                        System.out.println("What is the n ?");
                        int n = radka.nextInt();

                        System.out.println("What is the k ?");
                        int k = radka.nextInt();
                        int y = n + k - 1;
                        System.out.println(combination(n,y));
                    }
                }
                break;

            case 'N' :
                switch (x) {
                    case 1 -> {
                        System.out.println("What is the n ?");
                        int n = radka.nextInt();

                        System.out.println("What is the k ?");
                        int k = radka.nextInt();

                        System.out.println(placementsNoRepetition(n,k));
                    }
                    case 2 -> {
                        System.out.println("What is the n ?");
                        int n = radka.nextInt();

                        System.out.println("What is the k ?");
                        int k = radka.nextInt();

                        System.out.println(permutationNoRepetition(n));
                    }
                    case 3 -> {
                        System.out.println("What is the n ?");
                        int n = radka.nextInt();

                        System.out.println("What is the k ?");
                        int k = radka.nextInt();

                        System.out.println(combination(n,k));
                    }
                }
        }

    }

    //-------PLACEMENT WITH NO REPETITION----------

    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must not be a non-negative integer");
        }

        long factorial = 1;
        for (int i = 1; i <= n; i ++) {
            factorial *= i;
        }

        return factorial;
    }

    public static long placementsNoRepetition (int n, int k) {
        if (n < 0 || k < 0 || k > n) {
            throw new IllegalArgumentException("Both n and k must be non-negative integers, " +
                    "and k must be less than or equal to n.");
        }

        long numerator = calculateFactorial(n);
        long denominator = calculateFactorial(n-k);

        return numerator /denominator;
    }

    //---------------PERMUTATION WITH NO REPETITION-------------

    public static long permutationNoRepetition (int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must not be a non-negative integer");
        }

        long factorial = 1;
        for (int i = 1; i <= n; i ++) {
            factorial *= i;
        }

        return factorial;
    }

    //--------------COMBINATION WITH NO REPETITION------------

    public static  long combination (int n, int k) {
        if (n < 0 || k < 0 || k > n) {
            throw new IllegalArgumentException("Both n and k must be non-negative integers, " +
                    "and k must be less than or equal to n.");
        }

        long numerator = calculateFactorial(n);
        long K = calculateFactorial(k);
        long  denominator = calculateFactorial(n-k);

        return  numerator / (K * denominator);
    }

    //----------------------------------------------------------------------------------------

    //-------------------PLACEMENT WITH REPETITION---------------

    public static double placementRepetition(int n, int k) {
        return Math.pow(n,k);
    }

    //---------------------PERMUTATION WITH REPETITION---------------

    public static long permutationRepetition (int n, int[] kValues) {

        int k = kValues.length;
        int sumK = 0;

        for (int i = 0; i < k; i ++) {
            if (kValues[i] < 0) {
                throw new IllegalArgumentException("All k values must be non-negative integers.");
            }

            sumK += kValues[i];
        }

        if (sumK != n) {
            throw new IllegalArgumentException("The sum of k values must equal n.");
        }

        long numerator = calculateFactorial(n);
        long denominator = 1;

        for (int i = 0; i < k; i ++) {
            denominator *= calculateFactorial(kValues[i]);
        }

        return numerator / denominator;
    }

}
