package com.rasion.api.homework;
// 枚举类 ---->自定义的数据类型
public enum Sex {
    BOY("男孩"),GIRL("女孩");
    private String info;

    Sex(String info) {
        this.info = info;
    }

    Sex() {
    }

    @Override
    public String toString() {
        return  info ;
    }
}
