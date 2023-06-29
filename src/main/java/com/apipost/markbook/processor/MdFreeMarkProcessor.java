package com.apipost.markbook.processor;

import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 模版模式
 * @author 石玉龙 at 2023/6/29 14:19
 */
public class MdFreeMarkProcessor extends AbstractFreeMarkProcessor{

    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        Map<String,Object> map = new HashMap<>();
        map.put("topic",sourceNoteData.getTopic());
        map.put("noteList",sourceNoteData.getList());
        return map;
    }

    @Override
    protected Template getTemplate() throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        String templateContent = UrlUtil.loadText(Objects.requireNonNull(MdFreeMarkProcessor.class.getResource("/template/md.tfl")));
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("mdTemplate",templateContent);
        configuration.setTemplateLoader(stringTemplateLoader);
        return configuration.getTemplate("mdTemplate");
    }

    @Override
    protected Writer getWriter(SourceNoteData sourceNoteData) throws FileNotFoundException, UnsupportedEncodingException {
        String fileName = sourceNoteData.getFileName();
        File file = new File(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        return bufferedWriter;
    }




















}
