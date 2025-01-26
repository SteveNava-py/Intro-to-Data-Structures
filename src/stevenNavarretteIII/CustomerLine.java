package stevenNavarretteIII;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class CustomerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter the length of the simulation (in minutes): ");
        int simLength = scanner.nextInt();

        Queue<Customer> queue = new LinkedList<>();
        int totalCustomersServed = 0;
        int totalWaitTime = 0;
        int maxWaitTime = 0;

        for (int minute = 0; minute < simLength; minute++) {
            //serve customer
            if (!queue.isEmpty()) {
                Customer servedCustomer = queue.poll();
                int waitTime = minute - servedCustomer.arrivalTime;
                totalWaitTime += waitTime;
                maxWaitTime = Math.max(maxWaitTime, waitTime);
                totalCustomersServed++;
            }

            //customers incoming
            int k = random.nextInt(4); //random # between 0 & 3
            if (k == 1) {
                queue.add(new Customer(minute));
            } else if (k == 2) {
                queue.add(new Customer(minute));
                queue.add(new Customer(minute));
            }

            //print queue
            System.out.println("Minute " + minute + ": Queue size = " + queue.size());
        }

        //print results
        System.out.println("\nSimulation Summary:");
        System.out.println("Total customers served: " + totalCustomersServed);
        System.out.println("Combined waiting time: " + totalWaitTime);
        System.out.println("Maximum wait time: " + maxWaitTime);
        System.out.println("Average wait time: " +
                (totalCustomersServed > 0 ? (double) totalWaitTime / totalCustomersServed : 0));
    }
}
