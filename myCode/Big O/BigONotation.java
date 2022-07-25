
public class BigONotation {

  private int[] theArray;
  private int arraySize;
  private int itemsInArray = 0;
  private static long startTime;
  private static long endTime;

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

  // 0(1)
  public void addItemToArray(int newItem) { 
    theArray[itemsInArray++] = newItem; 
  } 

  // O(N)
  public void linearSearchForValue(int value) {
    boolean valueInArray = false;

    startTime = System.currentTimeMillis();
    for(int i = 0; i < arraySize; i++) {
      if(theArray[i] == value) {
        valueInArray = true;
      }
    }
    System.out.println("Value found: " + valueInArray);
    endTime = System.currentTimeMillis();
    System.out.println("Linear search took:" + (endTime - startTime));
  }

  // O(N^2)
  public void bubbleSort() {
    startTime = System.currentTimeMillis(); 
    for(int i = arraySize -1; i > 1; i--) {
      for(int j = 0; j < i; j++) {
        if(theArray[j] == theArray[j + 1]) {
          swapValues(j, j+1);
        }
      }
    }
  }

  public void swapValues(int indexOne, int indexTwo) {
    int temp = theArray[indexOne];
    theArray[indexOne] = theArray[indexTwo];
    theArray[indexTwo] = temp;
  }

  // O(log N)
  public void binarySearchForValue(int value) {
    startTime = System.currentTimeMillis();

    int lowIndex = 0;
    int highIndex = arraySize - 1;

    int timesThrough = 0;

    while(lowIndex <= highIndex) {
      int middleIndex = (highIndex + lowIndex) / 2;

      if(theArray[middleIndex] < value) {
        lowIndex = middleIndex + 1;
      } else if(theArray[middleIndex] > value) {
        highIndex = middleIndex - 1;
      } else {
        System.out.println("Found matcg in index " + middleIndex);
        lowIndex = middleIndex + 1;
      }
      timesThrough++;
    }
    endTime = System.currentTimeMillis();
    System.out.println("BubbleSort Took " + (endTime - startTime));
    System.out.println("Times through " + timesThrough);
  }
  
  // O(n log n)
  public void quickSort(int left, int right) {
    if (right - left <= 0)
      return;
    else {
      int pivot = theArray[right];
      int pivotLocation = partitionArray(left, right, pivot);
      quickSort(left, pivotLocation - 1);
      quickSort(pivotLocation + 1, right);
    }
  }

  public int partitionArray(int left, int right, int pivot) {
    int leftPointer = left - 1;
    int rightPointer = right;
    while (true) {
      while (theArray[++leftPointer] < pivot);
      while (rightPointer > 0 && theArray[--rightPointer] > pivot);
      if (leftPointer >= rightPointer) {
        break;
      } else {
        swapValues(leftPointer, rightPointer);
      }
    }
    swapValues(leftPointer, right);
    return leftPointer;
  }    
}