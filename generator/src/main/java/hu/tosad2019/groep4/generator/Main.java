package hu.tosad2019.groep4.generator;

import hu.tosad2019.groep4.generator.domain.businessrule.attributerangerule.AttributeRangeRule;

public class Main
{
	public static void main(String[] args) {
		/*
		ServerListener server;
		try {
			server = ServerListener.create(8000);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		AttributeRangeRule.Builder test = new AttributeRangeRule.Builder();
		test.setTriggerName("Hree");
		AttributeRangeRule attribute = test.build();
		
		
	}
}
