package hu.tosad2019.groep4.generator.domain.businessrule.attributerangerule;

public class AttributeRangeRule {
	
	private String triggerName;
	private String tableName;
	private int position;
	private boolean forEachRow;
	
	private AttributeRangeRule() { }
	
	public static class Builder {
		private AttributeRangeRule instance;
		public Builder() { instance = new AttributeRangeRule(); }
		
		public Builder setTriggerName(String triggerName) {
			instance.triggerName = triggerName;
			return this;
		}
		
		
		
		public AttributeRangeRule build() {
			return instance;
		}
	}

}
