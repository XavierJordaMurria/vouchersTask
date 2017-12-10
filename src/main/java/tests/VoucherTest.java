package tests;

import com.jorda.xavier.algorithms.AlgorithmTypes;
import com.jorda.xavier.model.Voucher;
import com.jorda.xavier.model.VoucherTypes;
import org.junit.Test;

import static org.junit.Assert.*;

public class VoucherTest
{
    @Test
    public void testVoucherConstructor()
    {
        try
        {
            new Voucher(VoucherTypes.byValue("voucher_type_1"),
                    Integer.parseInt("5"),
                    AlgorithmTypes.byValue("sequentialNumbers"),
                    Long.parseLong("0"),
                    Long.parseLong("1000"));

            new Voucher(VoucherTypes.byValue("voucher_type_2"),
                    Integer.parseInt("2"),
                    AlgorithmTypes.byValue("randomNumbers"),
                    Long.parseLong("500"),
                    Long.parseLong("1000"));
        }
        catch (Exception e)
        {
            fail(e.getMessage());
        }
    }

    @Test
    public void testNonExistingVoucherType()
    {
        try
        {
            new Voucher(VoucherTypes.byValue("non_existing_voucher_type"),
                    Integer.parseInt("5"),
                    AlgorithmTypes.byValue("sequentialNumbers"),
                    Long.parseLong("0"),
                    Long.parseLong("1000"));
            fail("Exception was expected for non existing voucher type.");
        }
        catch (IllegalArgumentException ignored) {}
    }

    @Test
    public void testNonExistingAlgorithmType()
    {
        try
        {
            new Voucher(VoucherTypes.byValue("voucher_type_1"),
                    Integer.parseInt("5"),
                    AlgorithmTypes.byValue("non_existing_algorithm_type"),
                    Long.parseLong("0"),
                    Long.parseLong("1000"));
            fail("Exception was expected for non existing algorithm type.");
        }
        catch (IllegalArgumentException ignored) {}
    }

    @Test
    public void testNegativeAmountValue()
    {
        try
        {
            new Voucher(VoucherTypes.byValue("voucher_type_1"),
                    Integer.parseInt("-5"),
                    AlgorithmTypes.byValue("sequentialNumbers"),
                    Long.parseLong("0"),
                    Long.parseLong("1000"));
            fail("Exception was expected for a negative amount value");
        }
        catch (IllegalArgumentException ignored) {}
    }

    @Test
    public void testNegativeUpperRanges()
    {
        try
        {
            new Voucher(VoucherTypes.byValue("voucher_type_1"),
                    Integer.parseInt("5"),
                    AlgorithmTypes.byValue("sequentialNumbers"),
                    Long.parseLong("0"),
                    Long.parseLong("-1000"));
            fail("Exception was expected for a negative ragnes value");
        }
        catch (IllegalArgumentException ignored) {}
    }

    @Test
    public void testNegativeLowerRanges()
    {
        try
        {
            new Voucher(VoucherTypes.byValue("voucher_type_1"),
                    Integer.parseInt("5"),
                    AlgorithmTypes.byValue("sequentialNumbers"),
                    Long.parseLong("-100"),
                    Long.parseLong("1000"));
            fail("Exception was expected for a negative ragnes value");
        }
        catch (IllegalArgumentException ignored) {}
    }

    @Test
    public void testLowerRangeBiggerThanUpper()
    {
        try
        {
            new Voucher(VoucherTypes.byValue("voucher_type_1"),
                    Integer.parseInt("5"),
                    AlgorithmTypes.byValue("sequentialNumbers"),
                    Long.parseLong("1000"),
                    Long.parseLong("100"));
            fail("Exception was expected Lower range can not be bigger than the upper range.");
        }
        catch (IllegalArgumentException ignored) {}
    }
}