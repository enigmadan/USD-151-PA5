/**
* File: Sort.java
* @author Mingyu Chen
* @author Daniel Myers
* @version 5/9/13
* Description: Class to Sort Comparable objects using
* a "quicksort" method returns number of comparisons required to sort an array
*/

import java.util.Random;


public class Sort {
/**
* Public method of quicksort
* creates a new random instance and passes on to private
* @param T[] Array of comparable objects
* @return int number of comparisons made to sort the array
*/
  public static<T extends Comparable<? super T>> int quicksort(T[] ar){
		Random rand = new Random();
		return quicksort(ar,rand,0,ar.length-1);
	}
/**
* Private method of quicksort
* @param T[] Array of comparable objects
* @param Random
* @param int index of first item in current set
* @param int index of last item in current set
* @return int number of comparisons made in current set
*/
	private static<T extends Comparable<? super T>> int quicksort(T[] ar,Random rand,int first,int last){
		int compared = 0;
		if(first>=last){
			return 0;
		}
		int pivot = rand.nextInt(last+1-first)+first;
		int low = first;
		int high = last;
		while(high>low){
			//increment low until i find the pivot or higher
			while(ar[low].compareTo(ar[pivot])<0){
				low++;
				//i compared!
				compared++;
			} 
			//increment high until i find the pivot or lower
			while(ar[high].compareTo(ar[pivot])>0&& high>0){
				high--;
				//i compared!
				compared++;
			}
			if(low==high){
				//get out of there
				break;
			}
			else{
				//logic to keep track of pivot and prevent re-comparing the same 
				//two objects repeatedly redundantly over-again
				if(low==pivot){
					pivot=high;
					T temp = ar[low];
					ar[low]=ar[high];
					ar[high]=temp;
					low++;
				}
				else if(high==pivot){
					pivot=low;
					T temp = ar[low];
					ar[low]=ar[high];
					ar[high]=temp;
					high--;
				}else{
					T temp = ar[low];
					ar[low]=ar[high];
					ar[high]=temp;
				}
			}
		}
		//lets add this to compared
		compared += quicksort(ar,rand,first,pivot-1);
		compared += quicksort(ar,rand,pivot+1,last);
		return compared;
	}
}
