package com.jorda.xavier.model;

import com.jorda.xavier.algorithms.AlgorithmTypes;

import java.util.List;

public class Voucher
{
    private final VoucherTypes type_;
    private final int amount_;
    private final AlgorithmTypes algorithmType_;
    private final long upperRange_;
    private final long lowerRange_;
    private List<String> vouchersStrList_;

    public Voucher(VoucherTypes type, int amount, AlgorithmTypes algorithmType, long lowerRange, long upperRange) throws IllegalArgumentException
    {
        if (type == null)
            throw new IllegalArgumentException("VoucherType was null, probably doesn't exist in the enum type.");

        if (algorithmType == null)
            throw new IllegalArgumentException("algorithmType was null, probably doesn't exist in the enum type.");

        if (amount <= 0)
            throw new IllegalArgumentException("Number of vouchers can not be 0 or negative.");

        if (lowerRange < 0 || upperRange < 0)
            throw new IllegalArgumentException("The lower and upper ranges must not be negative.");

        if (lowerRange > upperRange)
            throw new IllegalArgumentException("The lower range can NOT be bigger then the upper range.");

        type_ = type;
        amount_ = amount;
        algorithmType_  = algorithmType;
        lowerRange_ = lowerRange;
        upperRange_ = upperRange;
    }

    public VoucherTypes getType()
    {
        return type_;
    }

    public long getAmount()
    {
        return amount_;
    }

    public AlgorithmTypes getAlgorithmType()
    {
        return algorithmType_;
    }

    public long getUpperRange()
    {
        return upperRange_;
    }

    public long getLowerRange()
    {
        return lowerRange_;
    }

    public void setVoucherList(List<String> vouchers)
    {
        vouchersStrList_    = vouchers;
    }

    public List<String> getVoucherList()
    {
        return vouchersStrList_;
    }
}
