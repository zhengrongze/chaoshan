package com.mc.thinking.java.zhujie.sql;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String shuru = scanner.next();
        List<String> classNameList = new ArrayList<>();
        classNameList.add(shuru);
        if(classNameList.size() == 0){
            System.out.println("没有参数");
            System.exit(0);
        }
        for (String className : classNameList) {
            Class<?> cl  = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if(dbTable == null){
                System.out.println("没有注解");
            continue;
            }
            String tableName = dbTable.name();

            if(tableName.length() == 0){
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            //先获取字段，再获取注解
            for (Field field : cl.getDeclaredFields()){
                String columnName = null;
                Annotation[] anns = field.getAnnotations();
                if(anns.length < 1){
                    continue;
                }
                if(anns[0] instanceof  SQLInteger){
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if(sInt.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                if(anns[0] instanceof SQLString){
                    SQLString sString = (SQLString) anns[0];
                    if(sString.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value()+")"+ getConstraints(sString.constraints()));
                    }
                    StringBuilder stringBuilder = new StringBuilder("CREATE TABLE" + tableName + "(");
                for (String columnDef : columnDefs) {
                    stringBuilder.append("\n  "+ columnDef + ",");
                    String tableCreate = stringBuilder.substring(0,stringBuilder.length()-1)+" \n);";
                    System.out.println("Table Creation SQL for" + className + "is :\n" + tableCreate);
                }
                }

        }

    }
    private static String getConstraints(Constraints con){
        String constraints = "";
        if(!con.allowNull()){
            constraints +="NOT NULL";
        }
        if(con.primaryKey()){
            constraints +="PRIMARY KEY";
        }
        if(con.unique()){
            constraints +="UNIQUE";
        }
        return constraints;
    }
}
