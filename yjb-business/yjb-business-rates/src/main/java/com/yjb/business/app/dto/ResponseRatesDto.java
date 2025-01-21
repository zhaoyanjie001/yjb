package com.yjb.business.app.dto;


public class ResponseRatesDto {
	private String currencyCode;
	private String buyingRate;
	private String purchasePriceOfCash;
	private String exchangeSellingPrice;
	private String sellingPriceOfCash;
	private String middPrice;
	private String releaseDate;
	private String releaseTime;
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getBuyingRate() {
		return buyingRate;
	}
	public void setBuyingRate(String buyingRate) {
		this.buyingRate = buyingRate;
	}
	public String getPurchasePriceOfCash() {
		return purchasePriceOfCash;
	}
	public void setPurchasePriceOfCash(String purchasePriceOfCash) {
		this.purchasePriceOfCash = purchasePriceOfCash;
	}
	public String getExchangeSellingPrice() {
		return exchangeSellingPrice;
	}
	public void setExchangeSellingPrice(String exchangeSellingPrice) {
		this.exchangeSellingPrice = exchangeSellingPrice;
	}
	public String getSellingPriceOfCash() {
		return sellingPriceOfCash;
	}
	public void setSellingPriceOfCash(String sellingPriceOfCash) {
		this.sellingPriceOfCash = sellingPriceOfCash;
	}
	public String getMiddPrice() {
		return middPrice;
	}
	public void setMiddPrice(String middPrice) {
		this.middPrice = middPrice;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	
}
