//package com.example.dividend;
//
//import org.apache.commons.collections4.Trie;
//import org.apache.commons.collections4.trie.PatriciaTrie;
//
//public class Application {
//    public static void main(String[] args) {
//        //이방식을 사용하면 tire 변수를 공유할 수 있음
//        Trie trie= new PatriciaTrie();
//        AutoComplete autoComplete = new AutoComplete(trie);
//        AutoComplete autoComplete1 = new AutoComplete(trie);
//
//        autoComplete.add("hello");
//        autoComplete1.add("hello");
//
//        System.out.println(autoComplete.get("hello"));
//        System.out.println(autoComplete1.get("hello"));
//
//    }
//
//}
