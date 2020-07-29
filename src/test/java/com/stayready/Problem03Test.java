package com.stayready;
import org.junit.Assert;
import org.junit.Test;


public class Problem03Test {

    Problem03 problem03= new Problem03(); 
@Test 
public void countBribesTest(){
    int [] q={2,1,5,3,4};
    String expectedBribes="Bribes: 3";
    String actualBribes= problem03.countBribes(q);
    Assert.assertEquals(expectedBribes, actualBribes);  
}


}
