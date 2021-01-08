package longest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Longest {
	
	public static void main(String[] args) throws IOException {
		printFullSeq();
		printLongest();
    }
	
	int[] theArr = {
        //2,3,4,6,1,9,12,14,16,37,99,98,97,0,-1,10
		13,666,69,420,69420,58008,5318008,24,25,1337
    };
	
	/*
	int[] theArr = setTheArr();
	
	public static int setSeqLength() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the length of the sequence?");
		int theLen = scanner.nextInt();
		if(theLen > 99) {
			theLen = 99;
		} else if(theLen < 1) {
			theLen = 1;
		}
		return theLen;
	}
	
	public int[] setTheArr() {
		Random randObj = new Random();
		int[] anArr = new int[setSeqLength()];
		for(int i = 0; i < anArr.length; i++) {
			anArr[i] = randObj.nextInt();
		}
		return anArr;
	}
	*/

    public Integer[] getLongest() {

        // Sequences we find
        List<Integer[]> seqs = new ArrayList<>();

        // Our method of recursion
        // helps to keep track of what we've seen previously
        Stack<Integer> items = new Stack<>();

        // step through our numbers
        for (int r = 0; r < this.theArr.length; r++) {

            // Our number we're looking at
            Integer item = this.theArr[r];

            // If this is our first number, we just add it and move on
            if (items.empty()) {
                items.push(item);
                continue;
            }

            // The previous number
            Integer previous = items.peek();

            // If our number is higher than the previous - add it to our stack
            if (previous < item) {
                items.push(item);
            }

            // if the number is decreasing
            // or if we are at the end
                // then capture the sequence
            boolean atEnd = (r == this.theArr.length - 1);
            if (previous >= item || atEnd) {

                // Capture the sequence we found
                seqs.add(toArr(items));

                // Starting over so we clear out stack
                // Start the next sequence
                items.push(item);

            }
        }

        return longest(seqs);
    }

    public Integer[] longest(List<Integer[]> candidates) {
        TreeMap<Integer, Integer[]> byLength = new TreeMap<>();
        for (Integer[] candidate: candidates) {
            byLength.put(candidate.length, candidate);
        }
        return byLength.lastEntry().getValue();
    }

    private Integer[] toArr(Stack<Integer> items) {
        Integer[] seq = new Integer[items.size()];
        int index = items.size() - 1;
        Integer seqItem = items.pop();
        while (seqItem != null) {
            seq[index] = seqItem;
            try {
                seqItem = items.pop();
            } catch (EmptyStackException e) {
                break;
            }
            index--;
        }
        return seq;
    }
    
    public static void printFullSeq() {
    	Longest longestIncSubseq = new Longest();
    	int[] result = longestIncSubseq.theArr;
    	System.out.println("Full sequence is: ");
        for (int i : result) {
            System.out.println(i);
        }
    }
    
    public static void printLongest() {
        Longest longestIncSubseq = new Longest();
        Integer[] result = longestIncSubseq.getLongest();
        System.out.println("Longest increasing subsequence is: ");
        for (Integer i : result) {
            System.out.println(i);
        }
        //System.out.println("End of sequence");
    }
}
