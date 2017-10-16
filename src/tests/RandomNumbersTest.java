package tests;

import com.jorda.xavier.algorithms.RandomNumbers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.fail;

public class RandomNumbersTest
{
    private RandomNumbers randomNumbers_ ;
    private final int amountOfGeneratedNumbers_ = 10;
    private final int upperRange_ = 10;
    private final int lowerRange = 0;
    @Before
    public void setUp() throws Exception
    {
        randomNumbers_ = new RandomNumbers(0,10);
    }

    @Test
    public void generateSequenceNumber() throws Exception
    {
        List<Long> tmp = randomNumbers_.generateSequenceNumber(10);

        if (tmp.size() != amountOfGeneratedNumbers_)
            fail("Array size mismatch, was expecting: " + amountOfGeneratedNumbers_ + " and received: " + tmp.size());

        for (Long value: tmp)
        {
            if (value > upperRange_ || value < lowerRange)
                fail("Generated value is out of range, value:" + value + " lowerRange:" + lowerRange + " upperRange:" + upperRange_);
        }
    }
}