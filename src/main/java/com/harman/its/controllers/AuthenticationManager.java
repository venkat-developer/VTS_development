package com.harman.its.controllers;

import java.util.List;

import com.harman.its.entity.UserEntity;
import com.harman.its.entity.UserEntity.UserRole;
import com.harman.its.utils.SessionUtils;

/**
 * For user role based management
 * @author VAmukapati
 *
 */
public class AuthenticationManager {
	/**
	 * Checking the role of the logged in User.
	 * If it matches the roles defined in dispatcher xml returning to the requested URL.
	 * Else returning to home page.
	 * @param accessList
	 * @return true if the user is valid, else return false 
	 */
	public static boolean validateAccess(List<String> accessList){
		UserEntity user = SessionUtils.getCurrentlyLoggedInUser();
		boolean isvalidUser = false;
		if(accessList !=null){
			if(accessList.size()!=0){
				for(int i=0;i<accessList.size();i++){
					String beanAuth = accessList.get(i);
					String loggedInUserRole = UserRole.getUserRole(user.getRole().getValue()).toString();
					if(beanAuth.equalsIgnoreCase(loggedInUserRole.toString())){
						isvalidUser=true;
						break;
					}
				}
			}	
		}
		return isvalidUser;
	}
}
