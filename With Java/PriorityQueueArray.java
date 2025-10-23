import java.util.Scanner;



public class PriorityQueueArray {

    static final int MAX = 4;

    static int[] priQue = new int[MAX];

    static int front = -1, rear = -1;

    static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {

        int n, ch;

        System.out.println("1 - Insert an element into queue");

        System.out.println("2 - Delete an element from queue");

        System.out.println("3 - Display queue elements");

        System.out.println("4 - Exit");



        while (true) {

            System.out.print("\nEnter your choice : ");

            ch = sc.nextInt();



            switch (ch) {

                case 1:

                    System.out.print("Enter value to be inserted : ");

                    n = sc.nextInt();

                    insertByPriority(n);

                    break;

                case 2:

                    System.out.print("Enter value to delete : ");

                    n = sc.nextInt();

                    deleteByPriority(n);

                    break;

                case 3:

                    displayPQueue();

                    break;

                case 4:

                    System.exit(0);

                default:

                    System.out.println("Choice is incorrect, Enter a correct choice");

            }

        }

    }



    static void insertByPriority(int data) {

        if (rear >= MAX - 1) {

            System.out.println("Queue overflow, no more elements can be inserted");

            return;

        }

        if (front == -1 && rear == -1) {

            front++;

            rear++;

            priQue[rear] = data;

            return;

        } else {

            check(data);

            rear++;

        }

    }



    static void check(int data) {

        int i, j;

        for (i = 0; i <= rear; i++) {

            if (data >= priQue[i]) {

                for (j = rear + 1; j > i; j--) {

                    priQue[j] = priQue[j - 1];

                }

                priQue[i] = data;

                return;

            }

        }

        priQue[i] = data;

    }



    static void deleteByPriority(int data) {

        if (front == -1 && rear == -1) {

            System.out.println("Queue is empty, no elements to delete");

            return;

        }

        for (int i = 0; i <= rear; i++) {

            if (data == priQue[i]) {

                for (; i < rear; i++) {

                    priQue[i] = priQue[i + 1];

                }

                priQue[rear] = 0;

                rear--;

                if (rear == -1)

                    front = -1;

                return;

            }

        }

        System.out.println(data + " not found in queue to delete");

    }



    static void displayPQueue() {

        if (front == -1 && rear == -1) {

            System.out.println("Queue is empty");

            return;

        }

        System.out.print("Queue elements: ");

        for (int i = front; i <= rear; i++) {

            System.out.print(priQue[i] + " ");

        }

        System.out.println();

    }

}