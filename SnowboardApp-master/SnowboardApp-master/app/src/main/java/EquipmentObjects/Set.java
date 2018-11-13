package EquipmentObjects;

import EquipmentObjects.BindingsObj;

public class Set {
    private SnowboardObj board;
    private GoggleObj goggleObj;
    private BootObj boot;
    private HelmetObj helmetObj;
    private BindingsObj bindings;
    public Set(){}

    public Set(SnowboardObj boardData, GoggleObj goggleObjData, BootObj bootsData, HelmetObj helimtData, BindingsObj bindingsData){
        this.board = boardData;
        this.goggleObj = goggleObjData;
        this.boot = bootsData;
        this.helmetObj = helimtData;
        this.bindings = bindingsData;
    }

    public SnowboardObj getBoard() {
        return board;
    }

    public BootObj getBoot() {
        return boot;
    }

    public BindingsObj getBindings() {
        return bindings;
    }

    public GoggleObj getGoggleObj() {
        return goggleObj;
    }

    public HelmetObj getHelmetObj() {
        return helmetObj;
    }

    public void setBindings(BindingsObj bindings) {
        this.bindings = bindings;
    }

    public void setBoard(SnowboardObj board) {
        this.board = board;
    }

    public void setBoot(BootObj boot) {
        this.boot = boot;
    }

    public void setGoggleObj(GoggleObj goggleObj) {
        this.goggleObj = goggleObj;
    }

    public void setHelmetObj(HelmetObj helmetObj) {
        this.helmetObj = helmetObj;
    }
}
