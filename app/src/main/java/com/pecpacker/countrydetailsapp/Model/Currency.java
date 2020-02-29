
package com.pecpacker.countrydetailsapp.Model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency implements Serializable {

    private final static long serialVersionUID = 1664493411339272466L;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    /**
     * No args constructor for use in serialization
     */
    public Currency() {
    }

    /**
     * @param symbol
     * @param code
     * @param name
     */
    public Currency(String code, String name, String symbol) {
        super();
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
