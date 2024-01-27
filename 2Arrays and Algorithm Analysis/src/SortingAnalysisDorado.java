import java.io.*;
import java.util.*;

/**
 * Compares the running times of sorting algorithms
 * @author bryann
 *
 */
public class SortingAnalysisDorado {
	
	public static void insertionSort(String[] a) {
		int n = a.length;
		for(int i = 1; i < n; i++) {
			String cur = a[i];
			int j = i - 1;
			while((j >= 0) && (a[j].compareTo(cur) > 0)) {
				a[j + 1] = a[j--];
			} // end while
			a[j + 1] = cur;
		} // end for
	} // end insertionSort

	
	public static void mergeSort(String[] a) { //merge sort
         if (a.length>1){ //segmentation
             
             String [] left= new String[a.length / 2 ];
             String [] right= new String[a.length - (a.length/2)];

             for(int i = 0; i < left.length; i++)
                 left[i] = a[i];
 
             for(int i = 0; i < right.length; i++)
                 right[i] = a[i + left.length];
             
             //function call
             mergeSort(left); 
             mergeSort(right);
             merge(a, left, right);
         }
     }

     public static void merge(String[] a, String[] left, String[] right) {
         int x = 0, y = 0;
         for(int i = 0; i < a.length; i++) {
             if(y >= right.length || (x < left.length && left[x].compareTo(right[y]) < 0)) {
                 a[i] = left[x];
                 x++;
             }
             else {
                 a[i] = right[y];
                 y++;
             }
         }
     }
	
     	
	public static void main(String[] args) {
		final int NO_OF_WORDS = 50000;
		try {
			Scanner file = new Scanner(new File(args[0]));
			String[] words = new String[NO_OF_WORDS];
			
			int i = 0;
			while(file.hasNext() && i < NO_OF_WORDS) {
				words[i] = file.next();
				i++;
			} // end while
			
			//for Insertion Sort
			long start = System.currentTimeMillis();
			insertionSort(words);
			long end = System.currentTimeMillis();
			System.out.println("Sorted Words: ");
			for(int j = 0; j < words.length; j++) {
				System.out.println(words[j]);
			} // end for		
			
			//for Merge Sort
			long go = System.currentTimeMillis();
			mergeSort(words);
			long stop = System.currentTimeMillis();
			System.out.println("Sorted Words: ");
			for(int j = 0; j < words.length; j++) {
				System.out.println(words[j]);
			} // end for		
			
			//print the running time of both algorithm
			System.out.println("Running time of insertion sort: " + (end - start) + "ms");
			System.out.println("Running time of merge sort: " + (stop - go) + "ms");
			
			
		} // end try
		catch(SecurityException securityException) {
			System.err.println("You do not have proper privilege to access the files.");
			System.exit(1);
		} // end catch
		catch(FileNotFoundException fileNotFoundException) {
			System.err.println("Error accessing file");
			System.exit(1);
		} // end catch		
	} // end main
} // end class SortingAnalysisDorado
