package Tests.MostLovedDish;

import java.util.*;

// A restaurant has launched an app for their food delivery. 'n' reviews about various of their menu items have been submittted. User have submitted a rating out of 5 (1 being worst and 5 being best) . The manager wants to know the most loved dish in the restaurant.
// Find out the dish with the highest average rating
// Note: if two dishes are rated the same , return the dish with the smallest ID
//
// Complete the function solution() using java 8. The function takes the following 2 parameters and returns the solution:
// a) n: represents the number of reviews (this parameter is for internal purposes , don't remove it from the function)
// b) ratings: Represents the reviews of each dish
//
// Note: use this input format if you are testing against custom input or writing code in a language where we don't provide boilerplate code:
//
// - the first line contains n denoting the numer of reviews
// - Next, the n line contains two integers each, the ID and rating of the i'th review
//
// Constrains:
// 1 <= n <= 10]^5
// 1 <= ratings[i][0] <= 10^9
// 1 <= ratings[i][1] <= 5
//
// Sample input:
// 4
// 512 2
// 123 3
// 987 4
// 123 5
//
// Sample output:
// 123
//
//----
//
// Sample input:
// 5
// 987654423 4
// 987654220 5
// 987654202 4
// 987654250 1
// 987654419 5
//
// Sample output:
// 987654220
//
//----
//
// Sample input :
// 5
// 987654171 3
// 987654478 3
// 987654092 4
// 987654421 3
// 987654001 4
//
// Sample output:
// 987654001
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] ratings = new int[n][2];

        ratings[0][0] = 987654171;
        ratings[0][1] = 3;

        ratings[1][0] = 987654478;
        ratings[1][1] = 3;

        ratings[2][0] = 987654092;
        ratings[2][1] = 4;

        ratings[3][0] = 987654421;
        ratings[3][1] = 3;

        ratings[4][0] = 987654001;
        ratings[4][1] = 4;

        System.out.println(solution(n, ratings) == 987654001);
    }

    // This code reads the input, calculates the average ratings for each dish, and finds the dish with the highest
    // average rating. If there's a tie, it returns the dish with the smallest ID.
    public static int solution(int n, int[][] ratings) {
        Map<Integer, int[]> dishRatings = new HashMap<>();

        // Populate the dish ratings map
        for (int[] review : ratings) {
            int dishID = review[0];
            int rating = review[1];
            if (!dishRatings.containsKey(dishID)) {
                dishRatings.put(dishID, new int[]{rating, 1});
            } else {
                int[] currentRating = dishRatings.get(dishID);
                currentRating[0] += rating;
                currentRating[1]++;
            }
        }

        // Calculate average ratings for each dish
        double maxAverage = -1;
        int mostLovedDish = Integer.MAX_VALUE; // Smallest ID
        for (Map.Entry<Integer, int[]> entry : dishRatings.entrySet()) {
            int dishID = entry.getKey();
            int[] ratingsData = entry.getValue();
            double averageRating = (double) ratingsData[0] / ratingsData[1];
            if (averageRating > maxAverage || (averageRating == maxAverage && dishID < mostLovedDish)) {
                maxAverage = averageRating;
                mostLovedDish = dishID;
            }
        }

        return mostLovedDish;
    }
}
