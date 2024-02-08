package tests;

import org.iti.mobile.BankSystem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankSystemTests {


    @Test
    void checkDefaultBalanceIsThan3000(){
        BankSystem bankSystem = new BankSystem();
        assertEquals(3000,  bankSystem.getGetBalance().doubleValue());
    }

    @Test
    void checkDepositFunctionality() {
        BankSystem bankSystem = new BankSystem(new BigDecimal(50000));
        double prevBalance = bankSystem.getGetBalance().doubleValue();

        bankSystem.deposit(2000);

        assertEquals(prevBalance + 2000,bankSystem.getGetBalance().doubleValue());
    }

    @Test
    void checkWithdrawFunctionality() {
        BankSystem bankSystem = new BankSystem(new BigDecimal(50000));
        double prevBalance = bankSystem.getGetBalance().doubleValue();

        bankSystem.withdraw(4000);

        assertEquals(prevBalance - 4000, bankSystem.getGetBalance().doubleValue());
    }

}
