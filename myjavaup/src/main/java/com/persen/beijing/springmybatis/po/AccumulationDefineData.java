package com.persen.beijing.springmybatis.po;

import java.io.Serializable;

/**
 * Created by xugq on 16/7/17.
 */
@SuppressWarnings("serial")
public class AccumulationDefineData implements Serializable {
    private String accumulationCode; // 累积量代码
    private int accumulationType; // 累积量类型
    private int accumulationUnit; // 累积量单位
    private int cycleType; // 周期类型
    private int cycleUnit;// 周期量
    private int accumulationLevel; // 累积量级别
    private int refOffset; // 累积量参考偏移
    private String conditionId; // 条件ID
    private int timeType;

    public String getAccumulationCode() {
        return accumulationCode;
    }

    public void setAccumulationCode(String accumulationCode) {
        this.accumulationCode = accumulationCode;
    }

    public int getAccumulationType() {
        return accumulationType;
    }

    public void setAccumulationType(int accumulationType) {
        this.accumulationType = accumulationType;
    }

    public int getAccumulationUnit() {
        return accumulationUnit;
    }

    public void setAccumulationUnit(int accumulationUnit) {
        this.accumulationUnit = accumulationUnit;
    }

    public int getCycleType() {
        return cycleType;
    }

    public void setCycleType(int cycleType) {
        this.cycleType = cycleType;
    }

    public int getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(int cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public int getAccumulationLevel() {
        return accumulationLevel;
    }

    public void setAccumulationLevel(int accumulationLevel) {
        this.accumulationLevel = accumulationLevel;
    }

    public int getRefOffset() {
        return refOffset;
    }

    public void setRefOffset(int refOffset) {
        this.refOffset = refOffset;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public int getTimeType() {
        return timeType;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }

    @Override
    public String toString() {
        return "AccumulationDefineData{" + "accumulationCode='" + accumulationCode + '\'' + ", accumulationType='" +
                accumulationType + '\'' + ", accumulationUnit=" + accumulationUnit + ", cycleType=" + cycleType +
                ", cycleUnit=" + cycleUnit + ", accumulationLevel=" + accumulationLevel + ", refOffset=" + refOffset +
                ", conditionId='" + conditionId + '\'' + ", timeType=" + timeType + '}';
    }
}
