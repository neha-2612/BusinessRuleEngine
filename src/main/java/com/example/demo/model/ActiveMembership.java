package com.example.demo.model;

public class ActiveMembership extends Membership{
	boolean isActiveMembership;
	String activeMembershipId;
	
	public boolean isActiveMembership() {
		return isActiveMembership;
	}
	public void setActiveMembership(boolean isActiveMembership) {
		this.isActiveMembership = isActiveMembership;
	}
	public String getActiveMembershipId() {
		return activeMembershipId;
	}
	public void setActiveMembershipId(String activeMembershipId) {
		this.activeMembershipId = activeMembershipId;
	}
	
	
}
