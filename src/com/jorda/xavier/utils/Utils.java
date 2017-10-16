package com.jorda.xavier.utils;

import com.jorda.xavier.algorithms.IAlgorithm;
import com.jorda.xavier.model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class Utils
{
    /**
     * Given an algorithm IAlgorithm that returns a list<Long> and a voucher instance
     * it appens the voucherType ID as a prefix of all the list<Long> returned by the algorithm
     * @param voucher obj. instance that defines the type/amount/min/max properties for the generated vouchers.
     * @param algorithm that will genereate a list<Long>
     */
    public static void generateVouchers(Voucher voucher, IAlgorithm algorithm)
    {
        List<Long> tmpList = algorithm.generateSequenceNumber(voucher.getAmount());
        List<String> vouchersStrTmpList = new ArrayList<>();

        for (Long voucherLng: tmpList)
        {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(Integer.toString(voucher.getType().getID()) + " ");
            stringBuilder.append(Long.toString(voucherLng));
            vouchersStrTmpList.add(stringBuilder.toString());
        }

        voucher.setVoucherList(vouchersStrTmpList);
    }

    /**
     * Print all the generated vouchers after its voucherType name.
     * @param voucher Obj from where it will print the vouchers.
     */
    public static void printVouchers(Voucher voucher)
    {
        System.out.println(voucher.getType().getTypeName());

        for (String voucherStr: voucher.getVoucherList())
        {
            System.out.println(voucherStr);
        }

        System.out.println("\n");
    }
}
