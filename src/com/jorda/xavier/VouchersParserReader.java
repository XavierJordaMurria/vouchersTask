package com.jorda.xavier;

import com.jorda.xavier.algorithms.AlgorithmTypes;
import com.jorda.xavier.model.Voucher;
import com.jorda.xavier.model.VoucherTypes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class implementation of the IVoucherParser handling the reading operation from a command file
 */
public class VouchersParserReader implements IVoucherParser
{
    /**
     * Reads the input file
     * and parse vouchers for each input line
     */
    @Override
    public ArrayList<Voucher> parseVouchers(String inputFilePath) throws IOException
    {
        File inputFile = new File(inputFilePath);
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        ArrayList<Voucher> vouchersArr = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null)
        {
            String[] lineArr = line.split(" ");
            if (lineArr.length != 5)
            {
                System.err.println("parsing line:" + line + " /failed number of arguments was wrong.");
                continue;
            }

            try
            {
                Voucher voucher = new Voucher(VoucherTypes.byValue(lineArr[0]),
                        Integer.parseInt(lineArr[1]),
                        AlgorithmTypes.byValue(lineArr[2]),
                        Long.parseLong(lineArr[3]),
                        Long.parseLong(lineArr[4]));

                vouchersArr.add(voucher);
            }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }

            System.out.println(line);
        }

        System.out.println("Number of voucher in vouchersArr:" + vouchersArr.size());
        fileReader.close();

        return vouchersArr;
    }
}
