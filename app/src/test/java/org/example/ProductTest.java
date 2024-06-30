package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testProductAttributes(){
        Product product = new Product(new ArrayList<>());
        product.addAttribute(new StringAttribute("Color", "Blue"));
        product.addAttribute(new BooleanAttribute("tarif", FALSE));
        product.addAttribute(new DecimalAttribute("price", new BigDecimal(100.75)));

        assertEquals(3, product.attributes.size());
        assertEquals(product.getAttribute("Color").GetValue(), "Blue");
        assertEquals(product.getAttribute("tarif").GetValue(), FALSE);
    }

    @Test
    public  void testProductCase(){

        Condition<String> colorCondition = new Condition<>("color", new EqualsOperator<String>(), "Blue");
        Condition<BigDecimal> priceCondition = new Condition<>("price", new GreaterThan<>(), new BigDecimal("10.00"));


        List<Condition> conditions = new ArrayList<>();
        conditions.add(colorCondition);
        conditions.add(priceCondition);

        System.out.println("Rule Conditions");
        for (Condition c : conditions) {
            System.out.println(c);
        }
        ProductRule productRule = new ProductRule(conditions, 100);
        System.out.println("---");

        List<Product> products = new ArrayList<>();
        System.out.println(new App().getGreeting());
        Product product = new Product(new ArrayList<>());
        product.addAttribute(new StringAttribute("color", "Blue"));
        product.addAttribute(new BooleanAttribute("tarif", FALSE));
        product.addAttribute(new DecimalAttribute("price", new BigDecimal("100.75")));
        products.add(product);

        ProductRule.MatchStatus result = productRule.apply(product);
        assertEquals(2, result.numMatches);

        Product product2 = new Product(new ArrayList<>());
        product2.addAttribute(new StringAttribute("color", "Red"));
        product2.addAttribute(new BooleanAttribute("tarif", FALSE));
        product2.addAttribute(new DecimalAttribute("price", new BigDecimal("100.99")));
        products.add(product2);
         result = productRule.apply(product2);
        assertEquals(1, result.numMatches);




    }
}