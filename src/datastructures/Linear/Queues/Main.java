package datastructures.Linear.Queues;

public class Main {
    public static void main(String[] args) {
      var queue = new LinkedListQueue();
      queue.enqueue(12);
      queue.enqueue(13);
      queue.enqueue(14);
      queue.enqueue(11);
      queue.dequeue();
      queue.dequeue();
      System.out.println(queue);



    }



}