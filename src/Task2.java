import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int i=0;
        Deque<Integer> deque = new ArrayDeque<>();
        int n;
        Scanner in = new Scanner(System.in);    //Deque
        System.out.println("Enter:");
        while(in.hasNextInt()){
            n = in.nextInt();
            deque.add(n);
        }
        for(int m : deque)
        {
            System.out.print(m + " ");
        }
        System.out.println("\n");
        while (deque.size() > 1) {
            int first = deque.poll(); 
            int second = deque.poll(); 
            int sum = first + second;
            deque.offer(sum); // кінець черги
            for(int m : deque)
            {
                System.out.print(m + " ");
            }
            System.out.println("!"+ ++i+"!\n");
        }

        int result = deque.peek(); 
        System.out.println("Результат: " + result); 
    }
}