package com.code.test.problemset.companies.Zalando;

import java.util.Arrays;

/**
 * Created by aliismail on 20/12/2017.
 */
public class Testing {

//    86654321
    public String getTimeStamp(int []array){
        int digits = 6;
        if(array.length < digits)
            return "-1";

        StringBuilder value = new StringBuilder();

        Arrays.sort(array);
        for(int i = 0 ; i < digits && i < array.length && value.length() < digits;){
            if(checkValidTime(value, array[i])){
                value.append(array[i]);
            }
            else{
                return "-1";
            }
            i++;
        }

        if(value.length() == digits)
            return value.toString();

        return "-1";
    }

    //check time prefix
    private boolean checkValidTime(StringBuilder currentValue, int next) {
        return true;
    }
}
