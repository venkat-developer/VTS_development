package com.harman.its.entity;

import java.util.List;

public class ReportGenerateEntity {

	private String tableName;
	private List<String> tableColumnNamesList;
	private List<String[]> reportDataList;
	private int totalNoOfColumns;
	private String reportName;
	
	
	public ReportGenerateEntity(String tableName,List<String> tableColumnNamesList,List<String[]> reportDataList,int totalNoOfColumns,String reportName){
		this.tableName=tableName;
		this.tableColumnNamesList=tableColumnNamesList;
		this.reportDataList=reportDataList;
		this.totalNoOfColumns=totalNoOfColumns;
		this.reportName=reportName;
	}
		
	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public ReportGenerateEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<String> getTableColumnNamesList() {
		return tableColumnNamesList;
	}
	public void setTableColumnNamesList(List<String> tableColumnNamesList) {
		this.tableColumnNamesList = tableColumnNamesList;
	}
	public List<String[]> getReportDataList() {
		return reportDataList;
	}
	public void setReportDataList(List<String[]> reportDataList) {
		this.reportDataList = reportDataList;
	}
	public int getTotalNoOfColumns() {
		return totalNoOfColumns;
	}
	public void setTotalNoOfColumns(int totalNoOfColumns) {
		this.totalNoOfColumns = totalNoOfColumns;
	}
	
}
