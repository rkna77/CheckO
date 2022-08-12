package com.rikaadila.rajaongkir.network;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Rika Nur'adila
 */

public class Helper {
    public static boolean tiki = false;
    public static boolean jne = false;
    public static boolean pos = false;

    public static String formatRupiah(int price) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(localeID);
        return format.format(price);
    }
}
