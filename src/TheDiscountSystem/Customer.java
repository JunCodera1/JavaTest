package TheDiscountSystem;

public class Customer {
	
	String name;
    private boolean member;
    private String memberType;
    
    public Customer(String name, boolean member, String memberType) {
       this.name = name;
       this.member = member;
       this.memberType = memberType;
    }
    
    private String getName() {
    	return name;
    }
    
    private void setName(String name) {
    	this.name = name;
    }
    
    private boolean isMember() {
    	return member;
    }
    
    private void setMember(boolean member) {
    	this.member = member;
    }
    
    private String getMemberType() {
    	return memberType;
    }
    
    private void setMemberType(String memberType) {
    	this.memberType = memberType;
    }
    
    public String toString() {
    	return "Name: " + name + ", Member: " + member + ", Member Type: " + memberType;
    }
}
