package com.kh.embl.beans;

import java.util.List;

public class ResultBean {
    private List<?> person;


    public ResultBean(List<?> person) {
        this.person = person;

    }

    public List<?> getPerson() {
        return person;
    }

    public void setPerson(List<?> person) {
        this.person = person;
    }


}
