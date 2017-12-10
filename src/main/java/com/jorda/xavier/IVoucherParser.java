package com.jorda.xavier;

import com.jorda.xavier.model.Voucher;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads a list of commands from an input source
 */
public interface IVoucherParser
{
    ArrayList<Voucher> parseVouchers(String input) throws IOException;
}
