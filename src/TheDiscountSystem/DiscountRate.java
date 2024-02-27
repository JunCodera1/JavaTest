package TheDiscountSystem;


public enum DiscountRate {
	  SERVICE_DISCOUNT_PREMIUM(0.2), 
	  SERVICE_DISCOUNT_GOLD(0.15),
	  SERVICE_DISCOUNT_SILVER(0.1), 
	  PRODUCT_DISCOUNT_PREMIUM(0.1),
	  PRODUCT_DISCOUNT_GOLD(0.1),
	  PRODUCT_DISCOUNT_SILVER(0.1);
	  
	  private double discount;

      DiscountRate(double discount) {
          this.discount = discount;
      }

      public double getDiscount() {
          return discount;
      }
}

