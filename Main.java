import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    Random rand = new Random();
    int upperBound = 10;

    int[] array = new int[10];

    for(int i =0; i<array.length; i++){
      array[i] = rand.nextInt(upperBound);
      System.out.println(array[i]);
    }


//1) Implement linear/sequential search in Java.

    System.out.print("Number to search for: ");
    int search = keyboard.nextInt();

    int caught = 0;
    int dupes = 0;

    for(int i =0; i<array.length; i++){
      if(array[i] == search){
        caught = i;
        System.out.println(search + " is at index: " + caught);
        break;
      }
    }

//2 a)
//Write a method that implements this technique to search an array of int values.

    System.out.println("\n");
    for(int i =0; i<array.length; i++){
      if(array[i] == search){
        if(i==0){
          break;
        }
        array[i] = array[i-1];
        array[i-1] = search;
        System.out.println(search + " is at index: " + (i-1));
        break;
        
      }
    }
    
    System.out.println(Arrays.toString(array));

    Arrays.sort(array);

    System.out.println(Arrays.toString(array));

//5) Write a version of binary search that will return the index of an element closest to the search value, if the search value is not in the list. If there is a tie, return the smaller index.
    int mid, lower, upper;
    boolean check;
    check = true;

    lower = 0;
    upper = (int)(array.length);
    
    do{
      
      mid = (int)(upper+lower)/2;

      System.out.println("mid: " + mid + " lower: " + lower + " upper: " + upper);
      if((lower == mid)||(upper==mid)){//modification check for non match
        System.out.println("binary search approximates index at: " + lower);
        check = false;
      }
      if(array[mid] > search){
        upper = mid;
      }else if(array[mid] < search){
        lower = mid;
      }else{
        System.out.println("binary search index at: " + mid);
        check = false;
      }
      
    }while(check);
    
  }
}