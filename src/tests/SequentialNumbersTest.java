package tests;

import com.jorda.xavier.algorithms.RandomNumbers;
import com.jorda.xavier.algorithms.SequentialNumbers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class SequentialNumbersTest
{
    private List<Long> expectedGeneratedSequentialVouchers = Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L);

    private SequentialNumbers sequentialNumbers_ ;
    @Before
    public void setUp() throws Exception
    {
        sequentialNumbers_ = new SequentialNumbers(1);
    }

    @Test
    public void generateSequenceNumber() throws Exception
    {
        List<Long> tmp = sequentialNumbers_.generateSequenceNumber(10);

        if (tmp.size() != expectedGeneratedSequentialVouchers.size())
            fail("Array size mismatch, was expecting: " + expectedGeneratedSequentialVouchers.size() + " and received: " + tmp.size());

        int tmpSize = tmp.size();
        for (int i=0; i<tmpSize;i++)
        {
            if (tmp.get(i) != expectedGeneratedSequentialVouchers.get(i))
                fail("Array mismatch, was expecting: " + expectedGeneratedSequentialVouchers.get(i) + " and got: " + tmp.get(i));
        }
    }
}