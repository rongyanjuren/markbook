package com.apipost.markbook.processor;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * @author 石玉龙 at 2023/6/29 14:04
 */
public abstract class AbstractFreeMarkProcessor implements Processor {

    /**
     * 获取数据
     * @return
     */
    protected abstract Object getModel(SourceNoteData sourceNoteData);

    /**
     * 获取FreeMark模版
     * @return
     */
    protected abstract Template getTemplate() throws IOException;

    /**
     * 写的位置
     * @return
     */
    protected abstract Writer getWriter(SourceNoteData sourceNoteData) throws FileNotFoundException, UnsupportedEncodingException;


    @Override
    public final void processor(SourceNoteData sourceNoteData) throws TemplateException, IOException {
        Template template = getTemplate();
        Object model = getModel(sourceNoteData);
        Writer writer = getWriter(sourceNoteData);
        template.process(model,writer);
    }
}
