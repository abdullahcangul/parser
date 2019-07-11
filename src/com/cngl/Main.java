package com.cngl;


public class Main {

    public static void main(String[] args) {

        Parser parser=new Parser();
        ResultModel result=parser.parse("rrgoogle.com,10.0.0.5,[192.168.1.6-50],10.0.0.1/24");
    }
}
