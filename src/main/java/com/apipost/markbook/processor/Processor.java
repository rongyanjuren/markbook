package com.apipost.markbook.processor;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author 石玉龙 at 2023/6/29 13:58
 */
public interface Processor {

    /**
     * 生成文件的接口（模版模式）
     * @param sourceNoteData
     */
    void processor(SourceNoteData sourceNoteData) throws TemplateException, IOException;
}
