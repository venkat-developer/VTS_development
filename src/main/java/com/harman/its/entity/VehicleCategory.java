/**
 * @author VAmukapati
 *
 */
package com.harman.its.entity;

import com.harman.its.entity.ientity.IEntity;

/**
 * 
DROP TABLE IF EXISTS vehicle_type;
CREATE TABLE vehicle_type(
vehicle_categoryId INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
vehicle_category VARCHAR(50)
)
--------------------------------------------
vehicle_categoryId	|	vehicle_category	|
--------------------------------------------
1					|	SUV					|
--------------------------------------------
2					|	Sedan				|	
--------------------------------------------
3					|	Mini-van			|		
--------------------------------------------
4					|	Bus					|
--------------------------------------------
*/
public class VehicleCategory implements IEntity<VehicleCategory> {

	private LongPrimaryKey vehicleCategoryId;
	
	private String vehicleCategory;

	public boolean equalsEntity(VehicleCategory object) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the vehicleCategoryId
	 */
	public LongPrimaryKey getVehicleCategoryId() {
		return vehicleCategoryId;
	}

	/**
	 * @param vehicleCategoryId the vehicleCategoryId to set
	 */
	public void setVehicleCategoryId(LongPrimaryKey vehicleCategoryId) {
		this.vehicleCategoryId = vehicleCategoryId;
	}

	/**
	 * @return the vehicleCategory
	 */
	public String getVehicleCategory() {
		return vehicleCategory;
	}

	/**
	 * @param vehicleCategory the vehicleCategory to set
	 */
	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}
	
	
}
