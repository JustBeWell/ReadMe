package bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    @DisplayName("Starting Balance equals Balance")
    public void startingBalance_equals_balance() {
        // Arrange
        int startingBalance = 100;
        //Act
        BankAccount bankAccount = new BankAccount(startingBalance);
        //Assert
        assertEquals(startingBalance, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit is working well")
    public void deposit_working_well() { 
        //Arrange
        BankAccount bankAccount = new BankAccount(100);
        int depositAmount = 50;
        int moneyAfterDeposit = depositAmount + bankAccount.getBalance();
        //Act
        bankAccount.deposit(depositAmount);
        //Assert
        assertEquals(moneyAfterDeposit, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit throws")
    public void deposit_throws(){
        //Arrange
        BankAccount bankAccount = new BankAccount(100);
        int depositAmount = -1;
        //Assert
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(depositAmount));
    }

    @Test
    @DisplayName("Withdraw is working well")
    public void withdraw_working_well() {
        //Arrange
        BankAccount bankAccount = new BankAccount(100);
        int withdrawalAmount = 50;
        int initialMoney = bankAccount.getBalance();
        //Assert
        assertTrue(bankAccount.withdraw(withdrawalAmount));
        assertEquals(bankAccount.getBalance(), initialMoney-withdrawalAmount);
    }

    @Test
    @DisplayName("Cannot withdraw when withdraw is higher than balance")
    public void withdraw_higher_than_balance() { 
        //Arrange
        BankAccount bankAccount = new BankAccount(50);
        int withdrawalAmount = 100;
        //Assert
        assertFalse(bankAccount.withdraw(withdrawalAmount));
    }

    @Test
    @DisplayName("Payment calculation working well")
    public void payment_calculation_working_well() {
        //Arrange
        BankAccount bankAccount = new BankAccount(100);
        double total_amount = 10000;
        double interest = 0.001;
        int npayments = 12;
        double correctPaymentAmount = 838.7599255697181;
        //Act
        double payment = bankAccount.payment(total_amount, interest, npayments);
        //Assert
        assertEquals(payment,correctPaymentAmount);
    }

    @Test
    @DisplayName("Pending amount calculation working well")
    public void pending_amount_calculation_working_well() {
        //Arrange
        BankAccount bankAccount = new BankAccount(100);
        double amount = 500;
        double interest = 0.001;
        int npayments = 12;
        int month = 3;
        double correctPendingAmount = 375.5616557377105;
        //Act
        double pending = bankAccount.pending(amount, interest, npayments, month);
        //Assert
        assertEquals(pending, correctPendingAmount);
    }
}
