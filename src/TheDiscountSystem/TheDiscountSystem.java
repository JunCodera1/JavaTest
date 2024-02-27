package TheDiscountSystem;

import java.util.Date;

public class TheDiscountSystem {
    public static void main(String[] args) {

        Date date = new Date();

        DiscountRate discountRateProduct = DiscountRate.PRODUCT_DISCOUNT_SILVER;
        DiscountRate discountRateService = DiscountRate.SERVICE_DISCOUNT_PREMIUM;

        Customer customer = new Customer("Jun", true, null);

        double productExpense = 100 * (1 - discountRateProduct.getDiscount());
        double serviceExpense = 100 * (1 - discountRateService.getDiscount());

        Visit visit = new Visit(customer, date, serviceExpense, serviceExpense);
        visit.setProductExpense(productExpense);
        visit.setServiceExpense(serviceExpense);

        System.out.println(visit.toString());
    }
}
