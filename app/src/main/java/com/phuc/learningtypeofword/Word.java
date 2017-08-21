package com.phuc.learningtypeofword;

import java.util.ArrayList;

/**
 * Created by Phuc on 8/21/2017.
 */

public class Word {
    String endOfWord;
    int wordType; //noun: 0, adj: 1, verb: 2, adv: 3
    static String[] endOfWords = new String[] {"-tion", "-ation", "-ance", "-ence", "-ment",
            "-ness", "-ist", "-er", "-or", "-cy", "-tive", "-ful", "-al", "-able",
            "-ible", "-ish", "-ous", "-sive", "-ate", "-en", "-ize", "-fy", "-ly", "-ward", "-wise"};

    public String getEndOfWord(){
        return this.endOfWord;
    }

    public void setEndOfWord(String endOfWord){
        this.endOfWord = endOfWord;
    }

    public int getWordType(){
        return this.wordType;
    }

    public void setWordType(int wordType){
        this.wordType = wordType;
    }

    public static ArrayList<Word> getListWord(){
        ArrayList<Word> words = new ArrayList<>();
        for(int i = 0; i < endOfWords.length; i++){
            Word word = new Word();
            if(i < 10) {
                word.setWordType(0);
            }
            else if(i < 18) {
                word.setWordType(1);
            }
            else if(i < 22) {
                word.setWordType(2);
            }
            else {
                word.setWordType(3);
            }
            word.setEndOfWord(endOfWords[i]);
            words.add(word);
        }
        return  words;
    }
}

