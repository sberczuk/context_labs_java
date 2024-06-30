package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRuleTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testMatchResult(){
        ProductRule.MatchStatus r = new ProductRule.MatchStatus(10, 20, 100);
        assertEquals(50,r.resultScore() );
    }

    @Test
    void testMatchResult2(){
        ProductRule.MatchStatus r = new ProductRule.MatchStatus(20, 20, 100);
        assertEquals(100,r.resultScore() );
    }

    @Test
    void testApplyRuleToProduct() {
        List<ProductAttribute> attribs= new ArrayList<>();
        attribs.add(new DecimalAttribute("price", new BigDecimal("23.75")));
        attribs.add(new StringAttribute("color", "Blue"));

        Product product1 = new Product(attribs);

        Condition<String> colorCondition = new Condition<>("color", new EqualsOperator<String>(), "Blue");
        Condition<BigDecimal> priceCondition = new Condition<>("price", new GreaterThan<>(), new BigDecimal("10.00"));

        List<Condition> conditions = new ArrayList<>();
        conditions.add(colorCondition);
        conditions.add(priceCondition);

        ProductRule productRule = new ProductRule(conditions, 100);
        ProductRule.MatchStatus result = productRule.apply(product1);

        assertEquals(100, result.resultScore());


    }

    @Test
    void testApplyRuleToProduct2() {
        List<ProductAttribute> attribs= new ArrayList<>();
        attribs.add(new DecimalAttribute("price", new BigDecimal("23.75")));
        attribs.add(new StringAttribute("color", "Orange"));

        Product product1 = new Product(attribs);

        Condition<String> colorCondition = new Condition<>("color", new EqualsOperator<String>(), "Blue");
        Condition<BigDecimal> priceCondition = new Condition<>("price", new GreaterThan<>(), new BigDecimal("10.00"));

        List<Condition> conditions = new ArrayList<>();
        conditions.add(colorCondition);
        conditions.add(priceCondition);

        ProductRule productRule = new ProductRule(conditions, 100);
        ProductRule.MatchStatus result = productRule.apply(product1);

        assertEquals(50, result.resultScore());


    }
}