package com.code.test.problemset.companies.Pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Flatten a Dictionary
 * A dictionary is a type of data structure that is supported natively in all major interpreted languages such as JavaScript, Python, Ruby and PHP, where it’s known as an Object, Dictionary, Hash and Array, respectively. In simple terms, a dictionary is a collection of unique keys and their values. The values can typically be of any primitive type (i.e an integer, boolean, double, string etc) or other dictionaries (dictionaries can be nested). However, for this exercise assume that values are either an integer, a string or another dictionary.
 *
 * Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .
 *
 * If you’re using a compiled language such Java, C++, C#, Swift and Go, you may want to use a Map/Dictionary/Hash Table that maps strings (keys) to a generic type (e.g. Object in Java, AnyObject in Swift etc.) to allow nested dictionaries.
 *
 * If a certain key is empty, it should be excluded from the output (see e in the example below).
 *
 * Example:
 *
 * input:  dict = {
 *             "Key1" : "1",
 *             "Key2" : {
 *                 "a" : "2",
 *                 "b" : "3",
 *                 "c" : {
 *                     "d" : "3",
 *                     "e" : {
 *                         "" : "1"
 *                     }
 *                 }
 *             }
 *         }
 *
 * output: {
 *             "Key1" : "1",
 *             "Key2.a" : "2",
 *             "Key2.b" : "3",
 *             "Key2.c.d" : "3",
 *             "Key2.c.e" : "1"
 *         }
 * Important: when you concatenate keys, make sure to add the dot character between them. For instance concatenating Key2, c and d the result key would be Key2.c.d.
 *
 * Constraints:
 *
 * [time limit] 5000ms
 * [input] Dictionary dict
 * [output] Dictionary
 *
 */
public class FlattenDictionary {
    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> output = new HashMap<>();
        helper(output, "", dict);
        return output;
    }


    static void helper(HashMap<String, String> output, String parent, HashMap<String, Object> dict) {

        for(Map.Entry<String, Object> ent : dict.entrySet()){
            String newParent = (parent.length() > 0 ? parent+"." : parent) + ent.getKey();
            if (newParent.endsWith(".")){
                newParent = newParent.substring(0, newParent.length() - 1);
            }

            if(ent.getValue() instanceof Integer || ent.getValue() instanceof String){
                output.put(newParent, ent.getValue().toString());
            }else{
                //"Key2.c.e." => 1
                helper(output, newParent, (HashMap<String, Object>)ent.getValue());
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Object> test = new HashMap();
        HashMap<String, String> a = new HashMap();
        a.put("a", "1");

        test.put("",a );
        test.put("b", "3");
        flattenDictionary(test);
    }
}
