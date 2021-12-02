package com.example.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.demo.model.ActiveMembership;
import com.example.demo.model.Membership;
import com.example.demo.model.PackingSlip;
import com.example.demo.model.PackingSlipRoyality;
import com.example.demo.model.PackingSlipShipping;
import com.example.demo.model.PackingSlipWithVideo;
import com.example.demo.model.UpgradeMembership;
import com.example.demo.service.BusinessRuleService;

@Service
public class BusinessRuleServiceImpl implements BusinessRuleService{
	
	@Override
	public Object processOrderSystem(String ruleName) {
		Object object = new Object();
		if(ruleName.equals("Physical Product"))
			object = generatePackingSlipShipping(ruleName);
		else if(ruleName.equals("Book"))
			object = generatePackingSlipRoyality(ruleName);
		else if(ruleName.equals("Activate Membership"))
			object = activateMembership(ruleName);
		else if(ruleName.equals("Upgrade Membership"))
			object = upgradeMembership(ruleName);
		else if(ruleName.equals("Video of Learning to Ski"))
			object = generatePackingSlipWithVideo(ruleName);
		System.out.println("Order Processed Successfully!");
		return object;
	}

	public PackingSlipShipping generatePackingSlipShipping(String ruleName) {
		PackingSlipShipping packingSlipShipping = new PackingSlipShipping();
		packingSlipShipping.setOrdertype(ruleName);
		packingSlipShipping.setOrderId("A1BSHIP001");
		packingSlipShipping.setOrderAmount(47.4);
		packingSlipShipping.setShippingMode("Cruise");
		packingSlipShipping.setCommissionPayment(generateCommisionPayment(packingSlipShipping));
		return packingSlipShipping;
	}
	
	public PackingSlipRoyality generatePackingSlipRoyality(String ruleName) {
		PackingSlipRoyality packingSlipRoyality = new PackingSlipRoyality();
		packingSlipRoyality.setOrdertype(ruleName);
		packingSlipRoyality.setOrderId("A1BROYAL002");
		packingSlipRoyality.setOrderAmount(5000);
		packingSlipRoyality.setRoyalityAmount(1000);
		packingSlipRoyality.setCommissionPayment(generateCommisionPayment(packingSlipRoyality));
		return packingSlipRoyality;
	}
	
	public PackingSlipWithVideo generatePackingSlipWithVideo(String ruleName) {
		PackingSlipWithVideo packingSlipWithVideo = new PackingSlipWithVideo();
		packingSlipWithVideo.setOrdertype(ruleName);
		packingSlipWithVideo.setOrderId("A1BROYAL002");
		packingSlipWithVideo.setOrderAmount(5000);
		packingSlipWithVideo.setFirstAidVideo("First Aid Video");
		packingSlipWithVideo.setCommissionPayment(generateCommisionPayment(packingSlipWithVideo));
		return packingSlipWithVideo;
	}
	
	public ActiveMembership activateMembership(String ruleName) {
		ActiveMembership activeMembership = new ActiveMembership();
		activeMembership.setActiveMembership(true);
		activeMembership.setMembershipType("activated");
		activeMembership.setActiveMembershipId("MEM01");
		activeMembership.setOrderType(ruleName);
		activeMembership.setOwner("John");
		activeMembership.setEmailMessage(sendEmail(activeMembership)+" Message Sent Successfully!");
		return activeMembership;
	}
	
	public UpgradeMembership upgradeMembership(String ruleName) {
		UpgradeMembership upgradeMembership = new UpgradeMembership();
		upgradeMembership.setUpgrade(true);
		upgradeMembership.setMembershipType("upgraded");
		upgradeMembership.setOrderType(ruleName);
		upgradeMembership.setOwner("Michelle");
		upgradeMembership.setEmailMessage(sendEmail(upgradeMembership)+" Message Sent Successfully!");
		return upgradeMembership;
	}
	
	public String sendEmail(Membership membership){
		return "Hi "+membership.getOwner()+" ,your id has been "+membership.getMembershipType()+".";
	}
	
	public double generateCommisionPayment(PackingSlip packingSlip){
		double commissionPayment = packingSlip.getOrderAmount()*0.05; //5% is commission payment of order amount.
		return commissionPayment;
	}

}
