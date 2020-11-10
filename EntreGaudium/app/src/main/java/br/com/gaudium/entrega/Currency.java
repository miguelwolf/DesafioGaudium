package br.com.gaudium.entrega;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class Currency {

    /**
     * Simbolos especificos do Dolar Americano
     */
    private static final DecimalFormatSymbols DOLAR = new DecimalFormatSymbols(Locale.US);

    /**
     * Mascara de dinheiro para Dolar Americano
     */
    public static final DecimalFormat DINHEIRO_DOLAR = new DecimalFormat("¤ ###,###,##0.00", DOLAR);

    /**
     * Simbolos especificos do Euro
     */
    private static final DecimalFormatSymbols EURO = new DecimalFormatSymbols(Locale.GERMANY);

    /**
     * Mascara de dinheiro para Euro
     */
    public static final DecimalFormat DINHEIRO_EURO = new DecimalFormat("¤ ###,###,##0.00", EURO);

    /**
     * Locale Brasileiro
     */
    private static final Locale BRAZIL = new Locale("pt", "BR");

    /**
     * Sï¿½mbolos especificos do Real Brasileiro
     */
    private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);

    /**
     * Mascara de dinheiro para Real Brasileiro
     */
    public static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00", REAL);

    /**
     * Sï¿½mbolos especificos para nenhuma moeda
     */
    private static final DecimalFormatSymbols NULL = new DecimalFormatSymbols(BRAZIL);

    /**
     * Mascara de dinheiro para nenhuma moeda
     */
    public static final DecimalFormat DINHEIRO_NULL = new DecimalFormat("###,###,##0.00", NULL);

    /**
     * Mascara texto com formatacao monetaria
     *
     * @param valor Valor a ser mascarado
     * @param moeda Padrao monetario a ser usado
     * @return Valor mascarado de acordo com o padrao especificado
     */
    public static String mascaraDinheiro(double valor, DecimalFormat moeda) {
        return moeda.format(valor);
    }

    public static BigDecimal duasCasas(double input) {
        return new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Método responsável por transformar um valor que estaja no formato de preço para um valor double
     * @param value, preço que deseja ser transoformado para double.
     * @return
     */
    public static double toDouble(String value){
        return Double.parseDouble(value.replace("R$", "").replace(" ", "").replace(".", "").replace(",","."));
    }

}
