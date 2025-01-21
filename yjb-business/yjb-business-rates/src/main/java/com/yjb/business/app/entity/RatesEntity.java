package com.yjb.business.app.entity;


public class RatesEntity extends BaseEntity{
	private String currency_name;
	private String code;
	private String buy_exchange;
	private String buy_cash;
	private String selling_exchange;
	private String selling_cash;
	private String bank_conversion;
	public String getCurrency_name() {
		return currency_name;
	}
	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBuy_exchange() {
		return buy_exchange;
	}
	public void setBuy_exchange(String buy_exchange) {
		this.buy_exchange = buy_exchange;
	}
	public String getBuy_cash() {
		return buy_cash;
	}
	public void setBuy_cash(String buy_cash) {
		this.buy_cash = buy_cash;
	}
	public String getSelling_exchange() {
		return selling_exchange;
	}
	public void setSelling_exchange(String selling_exchange) {
		this.selling_exchange = selling_exchange;
	}
	public String getSelling_cash() {
		return selling_cash;
	}
	public void setSelling_cash(String selling_cash) {
		this.selling_cash = selling_cash;
	}
	public String getBank_conversion() {
		return bank_conversion;
	}
	public void setBank_conversion(String bank_conversion) {
		this.bank_conversion = bank_conversion;
	}
	
}
