package com.example.secureaty;

public class ListViewItems {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    String name=null;

    public ListViewItems(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    String code = null;

    public ListViewItems(String name, Boolean selected) {
        this.name = name;
        this.selected = selected;
    }

    Boolean selected=false;
}
