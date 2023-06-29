package com.apipost.markbook.data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 石玉龙 at 2023/6/28 15:23
 */
public class DataCenter {
    public static String SELECT_TEXT;
    public static String FILE_NAME;
    public static List<NoteData> NOTE_LIST = new LinkedList<>();
    private static String[] COLUMN_NAME={"标题","备注","文件名","代码段"};
    /**
     * 两个参数为数据和表头
     */
    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null,COLUMN_NAME);

    public static void reset(){
        NOTE_LIST.clear();
        TABLE_MODEL.setDataVector(null,COLUMN_NAME);
    }




}
