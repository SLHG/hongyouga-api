package com.cn.beans.classinfo;

public class ClassType {
    private int typeId;
    private String classTypeName;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getClassTypeName() {
        return classTypeName;
    }

    public void setClassTypeName(String classTypeName) {
        this.classTypeName = classTypeName;
    }

    @Override
    public String toString() {
        return "ClassType{" +
                "typeId=" + typeId +
                ", classTypeName='" + classTypeName + '\'' +
                '}';
    }
}
