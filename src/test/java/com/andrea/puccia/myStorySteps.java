package com.andrea.puccia;

import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;

import static org.junit.Assert.assertEquals;

public class myStorySteps {


    private Calculator c;

    @BeforeScenario
    public void beforeEachScenario() {
        System.out.println("Prima di ogni scenario!");
    }

    @Given("a calculator with value <value>")
    public void givenACalculatorWithValueValue(@Named("value") int value) {
        c = new Calculator(value);
    }

    @When("add the number <number>")
    public void whenAddTheNumberNumber(@Named("number") int number) {
        c.add(number);
    }

    @Then("the result is <result>")
    public void thenTheResultIsResult(@Named("result") int result) {
        assertEquals(c.getResult(), result);
    }

    @When("minus the number <number>")
    public void whenMinusTheNumberNumber(@Named("number") int number) {
        c.minus(number);
    }

    @Given("a calculator with value $integer1")
    public void givenACalculatorWithValue(int integer1) {
        c = new Calculator(integer1);
    }

    @When("add the number $integer1")
    public void whenAddTheNumber(int integer1) {
        c.add(integer1);
    }

    @Then("the result is $integer1")
    public void thenTheResultIs(int integer1) {
        assertEquals(c.getResult(), integer1);
    }

    @Given("a calculator with this values:$examplesTable")
    public void givenACalculatorWithThisValues(ExamplesTable examplesTable) {
        System.out.println("ciaoooooo");
        for (Parameters row : examplesTable.getRowsAsParameters()) {
            int a = row.valueAs("a", int.class);
            int b = row.valueAs("b", int.class);
            float c = row.valueAs("c", float.class);
            boolean d = row.valueAs("d", boolean.class);
            System.out.println((a+b));
            System.out.println((c+1.2));
            if(d){
                System.out.println("Success!");
            }
        }
    }
}
