import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      // Start time for Bubble Sort
      long bubbleStartTime = System.nanoTime();

      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);

      // End time for Bubble Sort
      long bubbleEndTime = System.nanoTime();

      Lab4.outputList(bubbleSortedList);

      // Calculate the duration and print it out
      long bubbleDuration = (bubbleEndTime - bubbleStartTime);
      System.out.print("\nBubble sort time is " + bubbleDuration + " nanoseconds.");
      
      System.out.println("\n\nInsertion sort results -------------------------------------------");
      
      // Start time for Insertion Sort
      long insertionStartTime = System.nanoTime();

      ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);  
      
      // End time for Insertion Sort
      long insertionEndTime = System.nanoTime();

      Lab4.outputList(insertionSortedList);

      // Calculate the duration and print it out
      long insertionDuration = (insertionEndTime - insertionStartTime);
      System.out.print("\nInsertioin sort time is " + insertionDuration + " nanoseconds.");
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for (int i = 1; i < integerList.size(); i++){
      // Get the current element from the list
      int curElement = integerList.get(i);

      int j = i - 1;
      // While the previous element is grater than the current element
      while (j >= 0 && integerList.get(j) > curElement){
        // Move the grater value to the right
        integerList.set(j + 1, integerList.get(j));
        j--;
      }
      // Move the smaller value to the left
      integerList.set(j + 1, curElement);
    }
    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    boolean isSwapped = true;
    
    while (isSwapped){
      isSwapped = false;
      for (int i = 0; i < integerList.size() - 1; i++){
        // If the left is grator than the right element
        if (integerList.get(i) > integerList.get(i + 1)){
          // Swap the elements
          int temp = integerList.get(i);
          integerList.set(i, integerList.get(i + 1));
          integerList.set(i + 1, temp);
          // Set the codition to true
          isSwapped = true;
        }
      }
    }
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}