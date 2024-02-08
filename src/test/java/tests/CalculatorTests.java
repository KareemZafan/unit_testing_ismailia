package tests;

import org.iti.mobile.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class CalculatorTests {

    private Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all tests");
    }

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.of(100, 10), Arguments.of(81, 9), Arguments.of(400, 20)
        );
    }

    @BeforeEach
    void beforeEachTest() {
        calculator = new Calculator();
        System.out.printf("Before every test\n");
    }

    @Test
    //@Disabled
    void testSumFunctionality() {
        assertEquals(30, calculator.sum(20, 10));
        assertEquals(-30, calculator.sum(-20, -10));
        assertEquals(10, calculator.sum(0, 10), "values are not equal");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testSubFunctionality(String input1, String input2, String expectedValue) {
        assertEquals(Double.parseDouble(expectedValue),
                calculator.sub(Double.parseDouble(input1), Double.parseDouble(input2)));
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testDivisionFunctionality() {
        Exception exp = assertThrowsExactly(ArithmeticException.class, () -> calculator.divide(2, 0));
        assertEquals("Dividing By Zero", exp.getMessage());
        assertEquals(20, calculator.divide(40, 2));
        assertEquals(-20, calculator.divide(40, -2));
        assertEquals(0,calculator.divide(0,100));
    }

    @Test
    void testMulFunctionality() {
        assertEquals(20, calculator.mul(2, 10));
        assertEquals(-80, calculator.mul(40, -2));
        assertEquals(0, calculator.mul(0, 2));
    }


    //@EnabledOnJre(JRE.JAVA_8)
    @ParameterizedTest
    @MethodSource("getData")
    void testSquareRootFunctionality(double a, double b) {
        assertEquals(b, calculator.squareRoot(a));
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 20, 30, 40, 50, 60, 70})
    void testGreaterValuesThan10(int value) {
        assertTrue(value > 10);
    }
}
