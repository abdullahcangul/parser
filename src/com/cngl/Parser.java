package com.cngl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    //          1           2           3           4
    //    "rrgoogle.com,10.0.0.5,[192.168.1.6-50],10.0.0.1/24"

    public ResultModel parse(String text){
         //Temel Parcalama islemi 4 parcaya ayrıldı
        List<String> parts= smash(text);

        //3  numaralı bölümü parçala
        List<String> part3= smash3(parts.get(2));

        //4  numaralı bölümü parçala
        List<String> part4= smash4(parts.get(3));

        ResultModel result=new ResultModel.Builder(parts.get(0))
                .text(parts.get(1))
                .ipAdresses (part3)
                .ipAdresses2(part4.get(0))
                .submask (part4.get(0))
                .build();
        //(parts.get(0),parts.get(1),part3,part4.get(0),part4.get(1)
        return result;
    }
    
   private List<String> smash3(String s) {
       s=s.replace("[","");
       s=s.replace("]","");
       //192.168.1.2-100
       String[] parts=s.split("-");
        //100
       Integer max=Integer.parseInt(parts[1]);
      //192,168,1,2
       String[] partsForMin=parts[0].split("[.]");
        //2
       Integer min=Integer.parseInt(partsForMin[partsForMin.length-1]);
       //192.168.1
       String firstPart=parts[0].substring( 0,parts[0].lastIndexOf(".")+1);
       //en küçükden en büyüge listeye alma
       List<String> list=new ArrayList<>();
       for (int i=min;i<=max;i++){
           list.add(firstPart+i);
       }
       return list;
    }
    
    private List<String> smash4(String s) {

        List<String> list=new ArrayList<>();

       String[] parts=s.split("/");

       String maskAdresi= parts[0];

       String altAgMaskesi = findSubmask(parts[1]);

       list.add(maskAdresi);
       list.add(altAgMaskesi);

        return list;
    }

    private String findSubmask(String s) {
        String number="";
       switch (s){
           case "32":
               number="255.255.255.255";
               break;
           case "31":
               number="255.255.255.254";
               break;
           case "30":
               number="255.255.255.252";
               break;
           case "29":
               number="255.255.255.248";
               break;
           case "28":
               number="255.255.255.240";
               break;
           case "27":
               number="255.255.255.224";
               break;
           case "26":
               number="255.255.255.192";
               break;
           case "25":
               number="255.255.255.128";
               break;
           case "24":
               number="255.255.255.0";
               break;
           case "23":
               number="255.255.254.0";
               break;
           case "22":
               number="255.255.252.0";
               break;
           case "21":
               number="255.255.248.0";
               break;
           case "20":
               number="255.255.240.0";
               break;
           case "19":
               number="255.255.224.0";
               break;
           case "18":
               number="255.255.192.0";
               break;
           case "17":
               number="255.255.128.0";
               break;
           case "16":
               number="255.255.0.0";
               break;
           case "15":
               number="255.254.0.0";
               break;
           case "14":
               number="255.252.0.0";
               break;
           case "13":
               number="255.248.0.0";
               break;
           case "12":
               number="255.240.0.0";
               break;
           case "11":
               number="255.224.0.0";
               break;
           case "10":
               number="255.192.0.0";
               break;
           case "9":
               number="255.128.0.0";
               break;
           case "8":
               number="255.0.0.0";
               break;
           case "7":
               number="254.0.0.0";
               break;
           case "6":
               number="252.0.0.0";
               break;
           case "5":
               number="248.0.0.0";
               break;
           case "4":
               number="240.0.0.0";
               break;
           case "3":
               number="224.0.0.0";
               break;
           case "2":
               number="192.0.0.0";
               break;
           case "1":
               number="128.0.0.0";
               break;
           case "0":
               number="0.0.0.0";
               break;
       }
        return number;
    }

    public List<String> smash(String text){
       List<String> list=Arrays.asList( text.split(","));
       return list;
    }
}
