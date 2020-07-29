package com.stayready;
import java.util.*;

public class Problem03 {


    //https://www.thecodingshala.com/2020/02/hackerrank-new-year-chaos-solution.html

    //LOGIC:
    //make a copy of the array and sort it
    //compare the queued array and the sorted copy 
    //see how the sorted copy and compare in for loop
    //if queue!=sorted AND queue>sorted at same index=bribe and swap
    //if "" AND queue<sorted =swap only, continue the loop

    // 1 2 3 4 5 
    //2 1 3 4 5
    //2 1 3 5 4
    //2 1 5 3 4


    public String countBribes(int[] q) {
        //q is the original unsorted queue


        int[] sortedQ = q.clone();//make a copy of q, not sorted yet
        Arrays.sort(sortedQ); //sort the queue here
        int swap = 0;
        int indivBribe = 0;//bribes for each individual number (index)
        int totalBribes=0; ///bribes in the queue in total
        String ans = "";
        for (int i = 0; i < sortedQ.length ; i++) { //
            if (sortedQ[i] != q[i] && q[i] > sortedQ[i]) {
                indivBribe++;
                //swap++;
            }
            //or
            if (sortedQ[i] != q[i] && q[i] < sortedQ[i]) {
                swap++;
                if(swap>3){
                    indivBribe++; //bc 5 had 2 swaps but didnt count as 2 bribes,
                    // this offsets that error
                }
            }
        }
        if (indivBribe > 2) { //per number
            ans = "Too chaotic";

        } else {
            totalBribes+=indivBribe; //add indiv's total bribes
            indivBribe=0;///bring to zero, to count the next indiv's bribes separately

            ans = "Bribes: " + totalBribes;
        }
        return ans;
    }
}






/*

// Complete the minimumBribes function below.
static void minimumBribes(int[] q) {
    int ans = 0; //bribes 
    for(int i=q.length-1;i>=0;i--){//for loop starts at the end of the queue and back tracks 
        int ch_pos = q[i]-(i+1);//2-1=1, number of bribes 
        if(ch_pos>2) { //if no. of bribes is greater than 2 then 
            System.out.println("Too chaotic");
        }
        else{
            int st = Math.max(0,q[i]-2);//the max of the params is outputted 
            for(int j=st;j<i;j++){//j=max 
                if(q[j]>q[i]) ans++;
                //j is sorted, i is queue
            }
        }
    }



  







    let swaps = 0;
    let min = q.length;
    for (var i = q.length - 1; i >= 0; i--){
        if (q[i] - i > 3){
            return `Too chaotic`;
        }
        if (q[i] > i+1){
            swaps += (q[i]-(i+1));
        } else {
            if (min > q[i]){
                min = q[i];
            } else if (q[i] != min){
                swaps++;
            }
        }
    }
    
    return swaps;

    
}
*/


