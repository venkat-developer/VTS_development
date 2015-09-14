package com.harman.its.entity;

public class SummaryReportEntity {

	private int Id;
	private String busRegNumber;
	private String conductorName;
	private String driverName;
	private String routeName;
	private float totalTransactionAmount;
	private long totalPassengers;
	private long totalTickets;
	private String busOperator;

	public SummaryReportEntity(int Id,String busRegNumber,String conductorName,String driverName,
			String routeName,float totalTransactionAmount,long totalPassengers,long totalTickets,String busOperator){
		this.Id=Id;
		this.busRegNumber=busRegNumber;
		this.routeName=routeName;
		this.conductorName=conductorName;
		this.driverName=driverName;
		this.totalTransactionAmount=totalTransactionAmount;
		this.totalPassengers=totalPassengers;
		this.totalTickets=totalTickets;
		this.busOperator = busOperator;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getBusRegNumber() {
		return busRegNumber;
	}
	public void setBusRegNumber(String busRegNumber) {
		this.busRegNumber = busRegNumber;
	}
	public String getConductorName() {
		return conductorName;
	}
	public void setConductorName(String conductorName) {
		this.conductorName = conductorName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public long getTotalPassengers() {
		return totalPassengers;
	}
	public float getTotalTransactionAmount() {
		return totalTransactionAmount;
	}
	public void setTotalTransactionAmount(float totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}
	public void setTotalPassengers(long totalPassengers) {
		this.totalPassengers = totalPassengers;
	}
	public long getTotalTickets() {
		return totalTickets;
	}
	public void setTotalTickets(long totalTickets) {
		this.totalTickets = totalTickets;
	}
	/**
	 * @return the busOperator
	 */
	public String getBusOperator() {
		return busOperator;
	}
	/**
	 * @param busOperator the busOperator to set
	 */
	public void setBusOperator(String busOperator) {
		this.busOperator = busOperator;
	}
}
