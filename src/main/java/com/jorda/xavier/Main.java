package com.jorda.xavier;

import com.jorda.xavier.algorithms.AlgorithmTypes;
import com.jorda.xavier.algorithms.RandomNumbers;
import com.jorda.xavier.algorithms.SequentialNumbers;
import com.jorda.xavier.model.Voucher;
import com.jorda.xavier.utils.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    /**
     * Write a program in Java, which when run would generate a list of voucher codes based on "voucher type" and "number of vouchers to generate".
     */
    public static void main(String[] args)
    {
        Cli cli;

        try
        {
            cli = new Cli(args);
        }
        catch (IllegalArgumentException e)
        {
            handleException(e, 1);
            return;
        }

        try
        {
            IVoucherParser voucherGenerator = new VouchersParserReader();
            ArrayList<Voucher> vouchersArr = voucherGenerator.parseVouchers(cli.getFilePath());

            for (Voucher voucher: vouchersArr)
            {
                if (voucher.getAlgorithmType() == AlgorithmTypes.SEQUENTIAL_NUM)
                    Utils.generateVouchers(voucher, new SequentialNumbers(voucher.getLowerRange()));
                else if (voucher.getAlgorithmType() == AlgorithmTypes.RANDOM_NUM)
                    Utils.generateVouchers(voucher, new RandomNumbers(voucher.getLowerRange(), voucher.getUpperRange()));

                Utils.printVouchers(voucher);
            }
        }
        catch (FileNotFoundException e)
        {
            handleException(e, 2);
            return;
        }
        catch (IOException e)
        {
            handleException(e, 2);
            return;
        }
    }

    private static void handleException(Exception e, int exitCode)
    {
        e.printStackTrace();
        System.out.println(e.getMessage());
        System.exit(exitCode);
    }
}
