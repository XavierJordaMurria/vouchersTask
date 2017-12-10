package com.jorda.xavier.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumbers implements IAlgorithm
{
    private final long upperRange_;
    private final long lowerRange_;

    public RandomNumbers(long lowerRange, long upperRange)
    {
        lowerRange_ = lowerRange;
        upperRange_ = upperRange;
    }

    @Override
    public List<Long> generateSequenceNumber(long len)
    {
        List<Long> vouchersList = new ArrayList<>();

        long randomValue;
        for (int i = 1; i<= len; i++)
        {
            randomValue = ThreadLocalRandom.current().nextLong(lowerRange_, upperRange_ + 1);
            vouchersList.add(randomValue);
        }

        return vouchersList;
    }
}
