package com.jorda.xavier.model;


public enum VoucherTypes
{
    VOUCHER_TYPE_1("voucher_type_1", 1),
    VOUCHER_TYPE_2("voucher_type_2", 2),
    VOUCHER_TYPE_3("voucher_type_3", 3);

    private final String typeStr_;
    private final int id_;

    VoucherTypes(String url, int prefix)
    {
        typeStr_ = url;
        id_ = prefix;
    }

    public String getTypeName()
    {
        return typeStr_;
    }

    public int getID()
    {
        return id_;
    }

    public static VoucherTypes byValue(String val)
    {
        VoucherTypes voucherTypesTmp = null;

        for(VoucherTypes en:values())
        {
            if(en.typeStr_.equalsIgnoreCase(val))
            {
                voucherTypesTmp = en;
                break;
            }
        }

        if (voucherTypesTmp == null)
            System.err.println("voucherType: " + val + " doesn't exist");

        return voucherTypesTmp;
    }
}