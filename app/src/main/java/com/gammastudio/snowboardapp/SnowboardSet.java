package com.gammastudio.snowboardapp;

public class SnowboardSet {
    private Snowboard board;
    private Goggle goggle;
    private Boot boot;
    private Helmit helmit;
    private Bindings bindings;
    public SnowboardSet(){}

    public SnowboardSet(Snowboard boardData, Goggle goggleData, Boot bootsData, Helmit helimtData, Bindings bindingsData){
        this.board = boardData;
        this.goggle = goggleData;
        this.boot = bootsData;
        this.helmit = helimtData;
        this.bindings = bindingsData;
    }

    public Snowboard getBoard() {
        return board;
    }

    public Boot getBoot() {
        return boot;
    }

    public Bindings getBindings() {
        return bindings;
    }

    public Goggle getGoggle() {
        return goggle;
    }

    public Helmit getHelmit() {
        return helmit;
    }

    public void setBindings(Bindings bindings) {
        this.bindings = bindings;
    }

    public void setBoard(Snowboard board) {
        this.board = board;
    }

    public void setBoot(Boot boot) {
        this.boot = boot;
    }

    public void setGoggle(Goggle goggle) {
        this.goggle = goggle;
    }

    public void setHelmit(Helmit helmit) {
        this.helmit = helmit;
    }
}
