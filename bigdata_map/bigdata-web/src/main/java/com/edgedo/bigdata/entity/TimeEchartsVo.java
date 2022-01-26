package com.edgedo.bigdata.entity;

import java.util.List;

public class TimeEchartsVo {

    //日期的集合
    private List<String> dateList;

    //一类
    private List<Integer> FirstCarNumList;

    //二类
    private List<Integer> SecondCarNumList;

    //三类
    private List<Integer> ThirdCarNumList;

    private String firstDangerCarNumLine;

    private String secondDangerCarNumLine;

    private String thirdDangerCarNumLine;


    public String getFirstDangerCarNumLine() {
        return firstDangerCarNumLine;
    }

    public void setFirstDangerCarNumLine(String firstDangerCarNumLine) {
        this.firstDangerCarNumLine = firstDangerCarNumLine;
    }

    public String getSecondDangerCarNumLine() {
        return secondDangerCarNumLine;
    }

    public void setSecondDangerCarNumLine(String secondDangerCarNumLine) {
        this.secondDangerCarNumLine = secondDangerCarNumLine;
    }

    public String getThirdDangerCarNumLine() {
        return thirdDangerCarNumLine;
    }

    public void setThirdDangerCarNumLine(String thirdDangerCarNumLine) {
        this.thirdDangerCarNumLine = thirdDangerCarNumLine;
    }

    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public List<Integer> getFirstCarNumList() {
        return FirstCarNumList;
    }

    public void setFirstCarNumList(List<Integer> firstCarNumList) {
        FirstCarNumList = firstCarNumList;
    }

    public List<Integer> getSecondCarNumList() {
        return SecondCarNumList;
    }

    public void setSecondCarNumList(List<Integer> secondCarNumList) {
        SecondCarNumList = secondCarNumList;
    }

    public List<Integer> getThirdCarNumList() {
        return ThirdCarNumList;
    }

    public void setThirdCarNumList(List<Integer> thirdCarNumList) {
        ThirdCarNumList = thirdCarNumList;
    }
}
