/**
 * @author VAmukapati
 *
 */
package com.harman.its.entity;

import com.harman.its.entity.ientity.IEntity;

/**
 * 
DROP TABLE IF EXISTS vendor_agreement
CREATE TABLE vendor_agreement(
agreement_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
user_id INT(6) NOT NULL,
vendor_id INT(6),
local_ac_per_km DECIMAL(5 ,4),
local_non_ac_per_km DECIMAL(5 ,4),
outstation_ac_per_km DECIMAL(5, 4 ),
outstation_non_ac_per_km DECIMAL(5, 4 ),
driver_beta DECIMAL(5,4 ),
tax DECIMAL(5, 4)
)
*/
public class VendorAgreement implements IEntity<VendorAgreement> {

	private LongPrimaryKey agreementId;
	
	private long userId;
	
	private long vendorId;
	
	private double localACPerKM;
	
	private double localNoACPerKM;
	
	private double outStatationNoACPerKM;

	private double outStatationACPerKM;
	
	private double driverBeta;
	
	private double tax;
	
	/**
	 * 
	 */
	public VendorAgreement() {
		
	}
	/**
	 * @param agreementId
	 * @param userId
	 * @param vendorId
	 * @param localACPerKM
	 * @param localNoACPerKM
	 * @param outStatationNoACPerKM
	 * @param outStatationACPerKM
	 * @param driverBeta
	 * @param tax
	 */
	public VendorAgreement(LongPrimaryKey agreementId,long userId,long vendorId,double localACPerKM,
			double localNoACPerKM,double outStatationNoACPerKM,double outStatationACPerKM,double driverBeta,double tax) {
		this.agreementId= agreementId;
		this.userId = userId;
		this.vendorId = vendorId;
		this.localACPerKM = localACPerKM;
		this.localNoACPerKM = localNoACPerKM;
		this.outStatationACPerKM = outStatationACPerKM;
		this.outStatationNoACPerKM = outStatationNoACPerKM;
		this.driverBeta = driverBeta;
		this.tax = tax;
	}
	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}

	/**
	 * @return the driverBeta
	 */
	public double getDriverBeta() {
		return driverBeta;
	}

	/**
	 * @param driverBeta the driverBeta to set
	 */
	public void setDriverBeta(double driverBeta) {
		this.driverBeta = driverBeta;
	}

	/**
	 * @return the outStatationACPerKM
	 */
	public double getOutStatationACPerKM() {
		return outStatationACPerKM;
	}

	/**
	 * @param outStatationACPerKM the outStatationACPerKM to set
	 */
	public void setOutStatationACPerKM(double outStatationACPerKM) {
		this.outStatationACPerKM = outStatationACPerKM;
	}

	/**
	 * @return the outStatationNoACPerKM
	 */
	public double getOutStatationNoACPerKM() {
		return outStatationNoACPerKM;
	}

	/**
	 * @param outStatationNoACPerKM the outStatationNoACPerKM to set
	 */
	public void setOutStatationNoACPerKM(double outStatationNoACPerKM) {
		this.outStatationNoACPerKM = outStatationNoACPerKM;
	}

	/**
	 * @return the localNoACPerKM
	 */
	public double getLocalNoACPerKM() {
		return localNoACPerKM;
	}

	/**
	 * @param localNoACPerKM the localNoACPerKM to set
	 */
	public void setLocalNoACPerKM(double localNoACPerKM) {
		this.localNoACPerKM = localNoACPerKM;
	}

	/**
	 * @return the localACPerKM
	 */
	public double getLocalACPerKM() {
		return localACPerKM;
	}

	/**
	 * @param localACPerKM the localACPerKM to set
	 */
	public void setLocalACPerKM(double localACPerKM) {
		this.localACPerKM = localACPerKM;
	}

	/**
	 * @return the vendorId
	 */
	public long getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the agreementId
	 */
	public LongPrimaryKey getAgreementId() {
		return agreementId;
	}

	/**
	 * @param agreementId the agreementId to set
	 */
	public void setAgreementId(LongPrimaryKey agreementId) {
		this.agreementId = agreementId;
	}

	
	public boolean equalsEntity(VendorAgreement object) {
		// TODO Auto-generated method stub
		return false;
	}
}
