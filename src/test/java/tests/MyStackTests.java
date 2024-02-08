package tests;

import org.iti.mobile.MyStack;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Execution(ExecutionMode.CONCURRENT)
public class MyStackTests {

    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
    }

    @Test
    @Order(1)
    @DisplayName("Check pushing to stack")
    @Tag("Regression")
    void testPushToStack() {
        assertTrue(myStack.isEmpty());
        myStack.push("Effective Java");
        myStack.push("Modern Java in Action");

        assertEquals(2, myStack.getStackSize());
        assertEquals(List.of("Effective Java", "Modern Java in Action"), myStack.getCurrentStack());

    }


    @RepeatedTest(4)
    @DisplayName("Avoiding stack overflow")
    @Order(2)
    void testPushToStackWhenStackIsFull() {
        myStack.push("Effective Java");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        assertTrue(myStack.isFull());
        Exception ex = assertThrowsExactly(ArrayIndexOutOfBoundsException.class,()-> myStack.push("Modern Java in Action"));
        assertEquals("Stack Overflow!",ex.getMessage());
        assertEquals(myStack.getStackSize(), myStack.getStackLimit());

    }


    @Test
    @DisplayName("Removing last Item")
    @Tag("Regression")
    @Order(3)
    void testPopFromStack() {

        myStack.push("Effective Java");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Android using Java");
        assertEquals(6, myStack.getStackSize());
        assertFalse(myStack.isEmpty());
        assertEquals("Android using Java", myStack.pop());
        assertEquals(5, myStack.getStackSize());
        assertEquals(List.of("Effective Java", "Modern Java in Action", "Modern Java in Action", "Modern Java in Action", "Modern Java in Action"), myStack.getCurrentStack());

    }

    @Test
    @DisplayName("Check Removing from Empty Stack")
    @Order(4)
    void testPopFromEmptyStack() {
        assertTrue(myStack.isEmpty());
        Exception exp = assertThrowsExactly(IllegalStateException.class,()->myStack.pop());
        assertEquals("Stack is Empty!",exp.getMessage());
    }

    @Test
    @Order(5)
    @DisplayName("Get Last Item")
    @Timeout(value = 1,unit = TimeUnit.MINUTES)
    void testGetPeek() {
        assertTrue(myStack.isEmpty());
        assertNull(myStack.getPeek());
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Modern Java in Action");
        myStack.push("Android using Java");
        myStack.push("Spring Boot");

        assertEquals("Spring Boot", myStack.getPeek());

    }


}
