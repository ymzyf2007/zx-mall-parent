package com.zx.mall.module;

public class VenderProductKind {
    private Long vKindId;

    private String vKindName;

    private Long vParentId;

    private Integer vLevel;

    public Long getvKindId() {
        return vKindId;
    }

    public void setvKindId(Long vKindId) {
        this.vKindId = vKindId;
    }

    public String getvKindName() {
        return vKindName;
    }

    public void setvKindName(String vKindName) {
        this.vKindName = vKindName == null ? null : vKindName.trim();
    }

    public Long getvParentId() {
        return vParentId;
    }

    public void setvParentId(Long vParentId) {
        this.vParentId = vParentId;
    }

    public Integer getvLevel() {
        return vLevel;
    }

    public void setvLevel(Integer vLevel) {
        this.vLevel = vLevel;
    }
}