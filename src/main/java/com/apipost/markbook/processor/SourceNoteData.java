package com.apipost.markbook.processor;

import com.apipost.markbook.data.NoteData;

import java.util.List;

/**
 * @author 石玉龙 at 2023/6/29 14:00
 */
public interface SourceNoteData {


    String getFileName();

    String getTopic();

    List<NoteData> getList();


}
