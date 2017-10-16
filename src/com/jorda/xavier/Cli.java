package com.jorda.xavier;

/**
 * Class handling command line input
 */
public class Cli
{
    private String mFilePath;

    public Cli(String[] args) throws IllegalArgumentException
    {
        parse(args);
    }

    public String getFilePath()
    {
        return mFilePath;
    }

    /**
     * Parse input arguments
     *
     * @param args
     * @throws IllegalArgumentException if file path is not provided or an empty delimiter param is passed
     */
    private void parse(String[] args) throws IllegalArgumentException
    {
        if (args.length < 1)
            throw new IllegalArgumentException("File path not provided");

        mFilePath = args[0];

        if (mFilePath == null || mFilePath.isEmpty())
            throw new IllegalArgumentException("Invalid mFilePath provided");
    }
}
