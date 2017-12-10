package tests;

import com.jorda.xavier.algorithms.AlgorithmTypes;
import com.jorda.xavier.algorithms.SequentialNumbers;
import com.jorda.xavier.model.Voucher;
import com.jorda.xavier.model.VoucherTypes;
import com.jorda.xavier.utils.Utils;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UtilsTest
{
    private Voucher voucher_;
    private List<String> voucherListMock = Arrays.asList("1 0", "1 1", "1 2", "1 3", "1 4");

    @org.junit.Before
    public void setUp() throws Exception
    {
        voucher_ = new Voucher(VoucherTypes.byValue("voucher_type_1"),
                Integer.parseInt("5"),
                AlgorithmTypes.byValue("sequentialNumbers"),
                Long.parseLong("0"),
                Long.parseLong("1000"));
    }

    @org.junit.After
    public void tearDown() throws Exception
    {
    }

    //Test that the generated List<String> vouchers is the same in size and value that voucherListMock.
    @org.junit.Test
    public void generateVouchers() throws Exception
    {
        Utils.generateVouchers(voucher_, new SequentialNumbers(0));

        List<String> voucherList = voucher_.getVoucherList();
        //Check if the size matches.
        if (voucherList.size() != voucherListMock.size())
            fail("Voucher List size mismatch, was expecting:" + voucherListMock.size() + " and received:" + voucherList.size());

        int voucherListSize = voucherList.size();
        //Check that the proper voucher list with a sequential algorithm is the same that the mock one.
        for (int i=0; i<voucherListSize;i++)
        {
            if (!voucherList.get(i).equalsIgnoreCase(voucherListMock.get(i)))
                fail("ArrayList mismatch, was expecting: " + voucherListMock.get(i) + " and got: " + voucherList.get(i));
        }
    }
}