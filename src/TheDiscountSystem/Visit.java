package TheDiscountSystem;

import java.util.Date;

public class Visit {
   Customer customer;
   Date date;
   double serviceExpense;
   double productExpense;
   
   public Visit(Customer customer, Date date, double serviceExpense, double productExpense) {
	   this.customer = customer;
	   this.date = date;
	   this.productExpense = productExpense;
	   this.serviceExpense = serviceExpense;
   }
   
   public String getName() {
	   return customer.name;
   }
   
   public double getServiceExpense() {
	   return serviceExpense;
   }
   
   public void setServiceExpense(double serviceExpense) {
	   this.serviceExpense = serviceExpense;
   }
   
   public double getProductExpense() {
	return productExpense;
   }
   
   public void setProductExpense(double productExpense) {
	   this.productExpense = productExpense;
   }
   
   public double getTotalExpense(){
	   return serviceExpense + productExpense;
   }
   
   public String toString() {
	   return "Total Expense:"
	   		+ "\n service expense = " + serviceExpense + ", product expense = " + productExpense + 
   "\n-> total expense = service expense + product expense = " + getTotalExpense()+"\n Date: " + date;
   }
}
