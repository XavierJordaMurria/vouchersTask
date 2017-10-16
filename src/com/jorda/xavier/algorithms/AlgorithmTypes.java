package com.jorda.xavier.algorithms;


public enum AlgorithmTypes
{
    SEQUENTIAL_NUM("sequentialNumbers"),
    RANDOM_NUM("randomNumbers");

    private final String value_;

    AlgorithmTypes(String value)
    {
        value_ = value;
    }

    public String getValue()
    {
        return value_;
    }

    public static AlgorithmTypes byValue(String val)
    {
        AlgorithmTypes algorithmTypesTmp = null;

        for(AlgorithmTypes algorithmType:values())
        {
            if(algorithmType.value_.equals(val))
            {
                algorithmTypesTmp = algorithmType;
                break;
            }
        }

        if (algorithmTypesTmp == null)
            System.err.println("algorithmTypesTmp: " + val + " doesn't exist");

        return algorithmTypesTmp;
    }
}