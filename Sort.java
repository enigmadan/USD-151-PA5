import java.util.Random;


public class Sort {
  public static<T extends Comparable<? super T>> int quicksort(T[] ar){
		Random rand = new Random();
		return quicksort(ar,rand,0,ar.length-1);





	}

	private static<T extends Comparable<? super T>> int quicksort(T[] ar,Random rand,int first,int last){
		int compared = 0;
		if(first>=last){
			
			return 0;
		}
		int pivot = rand.nextInt(last+1-first)+first;
		int low = first;
		int high = last;
         

		while(high>low){

			while(ar[low].compareTo(ar[pivot])<0){
				low++;
				compared++;

			}


			while(ar[high].compareTo(ar[pivot])>0&& high>0){
				high--;
				compared++;

			}

			if(low==high){
				break;

			}
			else{
				if(low==pivot){
					pivot=high;
				}
				else if(high==pivot){
					pivot=low;
				}


				T temp = ar[low];
				ar[low]=ar[high];
				ar[high]=temp;

			}


		}
		compared += quicksort(ar,rand,first,pivot-1);
		compared += quicksort(ar,rand,pivot+1,last);
		return compared;

	}




}
