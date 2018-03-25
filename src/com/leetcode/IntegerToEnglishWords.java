package com.leetcode;
/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

*/

public class IntegerToEnglishWords {

    private static final String[] UNITS = {"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private static final String HUNDRED = "Hundred";
    private static final String THOUSAND = "Thousand";
    private static final String MILLION = "Million";
    private static final String BILLION = "Billion";
        
    public String numberToWords(int num) {
        if (num < 20) { 
            return UNITS[num];
        } else if (num < 100) {
            return TENS[num/10] + this.numberToWordsNonZero(num, 10);
        } else if (num < 1000) {
            return this.numberToWords(num/100) + " " + HUNDRED + this.numberToWordsNonZero(num, 100);
        } else if (num < 1000000) {
            return this.numberToWords(num/1000) + " " + THOUSAND + this.numberToWordsNonZero(num, 1000);
        } else if (num < 1000000000) {
            return this.numberToWords(num/1000000) + " " + MILLION + this.numberToWordsNonZero(num, 1000000);
        } else {
            return this.numberToWords(num/1000000000) + " " + BILLION + this.numberToWordsNonZero(num, 1000000000);
        }
    }
    
    public String numberToWordsNonZero(int num, int divisor) {
        return (num%divisor == 0) ? "" : " " + this.numberToWords(num % divisor);
    }

}
