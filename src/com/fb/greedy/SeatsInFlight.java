package com.fb.greedy;

import java.util.*;

/**
 * Task is to find the max number of 4 person seating available, given number of rows and current
 * booked seats. You can split 4 person groups across aisles, but only in 2-2 configuration. 1-3,
 * 3-1 is invalid (from what i understood).
 *
 * @author swamy on 2/26/21
 */
public class SeatsInFlight {
  static   int filled = 0;
  public static void main(String[] args) {
    /*  SeatsInFlight s = new SeatsInFlight();
      int N = 2;
      String[][] seats = {{"1A", "2F", "1C"}};
      int res = s.maxNumberOfFamilies(N, seats);*/





          // two- dimensional array with 7 rows and 4 columns
          char[][] seats = new char[7][4];
          for (int i = 0; i < 7; i++) {
              seats[i][0] = 'A';
              seats[i][1] = 'B';
              seats[i][2] = 'C';
              seats[i][3] = 'D';
          }

          String seatNumber = " ";
          String q = " ";
          System.out.println("Welcome to the Airplane Seating Reservation System.");
          System.out.println("Please enter the seat (e.g.- 1A) you wish to reserve.");
          System.out.println("Enter q to exit.");
          Scanner keyboard = new Scanner(System.in);
          seatNumber = keyboard.nextLine();
          if (seatNumber.equals("q")) {
              System.out.println("Program ended.");
              System.exit(0);
          }
          // print seating pattern and put an X in the seatNumber location
          while (filled < 28 && seatNumber.length() > 0) {
              int row = seatNumber.charAt(0) - '1';
              int col = seatNumber.charAt(1) - 'A';
              if (row < 0 || row > 7 || col < 0 || col > 4) {
                  System.out.println("Input error. Enter seat to assign (e.g., '1A')," + "or q to quit.");
                  seatNumber = keyboard.nextLine();
                  if (seatNumber.equals("q")) {
                      System.out.println("Program ended.");
                      System.exit(0);
                  }
              } else {
                  if (seats[row][col] != 'X') {
                      seats[row][col] = 'X';
                      filled++;
                      System.out.println(" ");
                      printSeats(seats);
                  }
                  if (filled < 28) {
                      System.out.println("Enter seat to assign (e.g., '1A')," + "or q to quit.");
                      seatNumber = keyboard.nextLine();
                      if (seatNumber.equals("q")) {
                          System.out.println("Program ended.");
                          System.exit(0);
                      }
                  }
              }
          }


  }

    private static void printSeats(char[][] seats) {
        System.out.println("Row");
        for (int i = 0; i < seats.length; i++) {
            System.out
                    .println((i + 1) + "  " + seats[i][0] + " " + seats[i][1] + "  " + seats[i][2] + " " + seats[i][3]);

        }
        int numberOfSeatsAvailable = (28 - filled);
        System.out.println("There are " + numberOfSeatsAvailable + " seats available.");
    } // end mai

  /**
   * // Just code for rules, no need to merge intervals
   * // Make sure you seat 2 families for rows with no reservations
   * // Greedy approach
   * // First possibility: Split seating at [2, 3 4, 5]
   * //
   * Second possibility: Split seating at [6, 7 8, 9]
   * // Only possibility: Center four seats [ 4, 5,6, 7 ]
   *
   * @param n
   * @param reservedSeats
   * @return
   */
  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] res : reservedSeats) {
            Set<Integer> set = map.getOrDefault(res[0], new HashSet<>());
            set.add(res[1]);
            map.put(res[0], set);
        }

        int result = (n - map.size()) * 2;
        boolean flag = false;

        for (Set<Integer> set : map.values()) {
            flag = false;

            if (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)) {
                result++;
                flag = true;
            }

            if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) {
                result++;
                flag = true;
            }

            if (!flag && !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) {
                result++;
            }
        }

        return result;
    }

}
