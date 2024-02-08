package tests;

import org.iti.mobile.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArrayListTests {

    private ArrayList<Integer> myList;

    @Mock
    private MyStack stack ;

    @BeforeEach
    void setUp()
    {
         myList = mock(ArrayList.class);
    }
    @Test
    void checkListSize(){
        when(myList.size()).thenReturn(10);
        System.out.println(myList.size());
        assertEquals(10,myList.size());

        verify(myList, atLeastOnce()).size();
    }

    @Test
    void checkStackList(){
        when(stack.getCurrentStack()).thenReturn(List.of("Kareem","Ali","Ahmed"));

        assertTrue(stack.getCurrentStack().contains("Ali"));

    }

}
