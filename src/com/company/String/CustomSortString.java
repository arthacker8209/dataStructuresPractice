package com.company.String;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

    private static String customSort(String order, String str){
       HashMap<Character, Integer> map = new HashMap<>();
       StringBuilder result= new StringBuilder();
       for (int i=0 ; i<str.length();  i++){
           map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
       }
       for (int i=0 ; i<order.length(); i++){
           char ch = order.charAt(i);
           if (!map.containsKey(ch))continue;
           result.append(String.valueOf(ch).repeat(Math.max(0, map.get(ch))));
           map.remove(ch);
       }

       for (Character entry :map.keySet()){
                result.append(String.valueOf(entry).repeat(Math.max(0,map.get(entry))));

            }

       return result.toString();
       }





    public static void main(String[] args){

    }

}