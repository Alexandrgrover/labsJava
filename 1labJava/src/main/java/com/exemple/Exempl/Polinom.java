package com.exemple.Exempl;

public class Polinom{

    static public Json findPolinom(String mbPolinom) {
        for(int i = 0, j = mbPolinom.length()-1; i < mbPolinom.length() && j >= 0; i++, j--)
        {
            if(mbPolinom.charAt(i) != mbPolinom.charAt(j))
            {
                return new Json("not polinom");
            }
        }

        return new Json("polinom");
    }
}
