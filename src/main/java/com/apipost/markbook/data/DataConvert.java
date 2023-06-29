package com.apipost.markbook.data;

/**
 * @author 石玉龙 at 2023/6/28 18:06
 */
public class DataConvert {

    public static String[] convert(NoteData noteData){
        String[] raw = new String[4];
        raw[0] = noteData.getTitle();
        raw[1] = noteData.getMark();
        raw[2] = noteData.getFileName();
        raw[3] = noteData.getContent();
        return raw;
    }
}
