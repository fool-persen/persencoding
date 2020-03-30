package com.persen.beijing.springmybatis.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BalanceTypeDefineData implements Serializable {
    private int balanceType; // 账本类型
    private int priority; // 使用优先级
    private int unitType; // 资源类型 1:金钱2:流量
    private int unit; // 单位
    private String conditionId; // 条件ID
    private int carryOffFlag; // 可结转标识0：可结转实钱；可结转流量1：不可结转实钱；不可结转的流量2：虚钱可结转3：虚钱不结转
    private String feeGroupId; // 费用组标识,专款专用
    private String formulaGroup; // 公式组
    private String switchTimes;// 忙闲时

    public int getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(int balanceType) {
        this.balanceType = balanceType;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public int getCarryOffFlag() {
        return carryOffFlag;
    }

    public void setCarryOffFlag(int carryOffFlag) {
        this.carryOffFlag = carryOffFlag;
    }

    public String getFeeGroupId() {
        return feeGroupId;
    }

    public void setFeeGroupId(String feeGroupId) {
        this.feeGroupId = feeGroupId;
    }

    public String getFormulaGroup() {
        return formulaGroup;
    }

    public void setFormulaGroup(String formulaGroup) {
        this.formulaGroup = formulaGroup;
    }

    public String getSwitchTimes() {
        return switchTimes;
    }

    public void setSwitchTimes(String switchTimes) {
        this.switchTimes = switchTimes;
    }

    @Override
    public String toString() {
        return "BalanceTypeDefineData [balanceType=" + balanceType + ", priority=" + priority + ", unitType=" +
                unitType + ", unit=" + unit + ", conditionId=" + conditionId + ", carryOffFlag=" + carryOffFlag +
                ", feeGroupId=" + feeGroupId + ", formulaGroup=" + formulaGroup + ", switchTimes=" + switchTimes + "]";
    }
}
