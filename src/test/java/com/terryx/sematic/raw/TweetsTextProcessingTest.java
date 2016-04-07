package com.terryx.sematic.raw;

import org.junit.Test;

import java.util.List;

/**
 * Created by xueta on 2016/3/25.
 */
public class TweetsTextProcessingTest {

    private String test_str = "Get cat an cats extra 25% off Homewares when you spend Â£30 or more using code HOME25 at Argos https://t.co/aEd7GBEwax https://t.co/V6pHo1gReH";

    @Test
    public void testProcessingBeforeTokenize() throws Exception {
        String str = TweetsTextProcessing.processingBeforeTokenize(test_str);
        System.out.println(str);
    }

    @Test
    public void testTokenzieStopStem() throws Exception {
        String str = TweetsTextProcessing.processingBeforeTokenize("happy people do the things");
        System.out.println(str);
        str = TweetsTextProcessing.tokenzieStopStem(str);
        System.out.println(str);
    }

    @Test
    public void testDoTweetsTextProcessing() throws Exception {
        List<String> words = TweetsTextProcessing.doTweetsTextProcessing(test_str);
        for (String word : words) {
            System.out.println(word);
        }
    }
}