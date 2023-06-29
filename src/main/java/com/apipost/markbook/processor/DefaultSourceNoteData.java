package com.apipost.markbook.processor;

import com.apipost.markbook.data.NoteData;

import java.util.List;

/**
 * @author 石玉龙 at 2023/6/29 14:53
 */
public class DefaultSourceNoteData implements SourceNoteData{


    private String fileName;

    private String topic;

    private List<NoteData> noteDataList;

    public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteDataList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteDataList = noteDataList;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<NoteData> getList() {
        return noteDataList;
    }
}
