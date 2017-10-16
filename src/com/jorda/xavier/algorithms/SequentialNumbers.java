package com.jorda.xavier.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SequentialNumbers implements IAlgorithm
{
    private final long startingNum_;

    public SequentialNumbers(long startingNum)
    {
        startingNum_ = startingNum;
    }

    @Override
    public List<Long> generateSequenceNumber(long len)
    {
        List<Long> vouchersList = new ArrayList<>();

        for (int i=0; i<len; i++)
        {
            vouchersList.add(startingNum_+i);
        }

        return vouchersList;
    }
}
