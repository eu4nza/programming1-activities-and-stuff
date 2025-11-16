#include <iostream>
using namespace std;

int main() {
  const int correctPin = 1234;  // setting of the correct pin and used const for added security to be unchangeble  :)
  int pinAttempt = 0, pinInput; // set the pin attempt count default as 0 and declaration of pin input variable

  cout << "Enter your PIN: "; // asks user to enter the correct pin
  cin >> pinInput;            // receives user pin input

  // pin entry checking
PIN_ENTRY:

// check if the pin is correct
  if (pinInput == correctPin) {

    cout << "Access Granted.\n" << endl; // outputs if the pin is correct

    // fallback if pin is incorrect
  } else {

    pinAttempt++; // increase pin attempt count

    // checks if pin is greater than or equal to 3 as the maximum attempt available is 3
    if (pinAttempt >= 3) { 
      cout << "Too many incorrect attempts. Access denied." << endl; // outputs since the maximum attempt of 3 is reached
      return 0; // exits the program since the maximum attempt is reached
    }

    cout << "Incorrect PIN. Attempts left: " << (3 - pinAttempt) << endl; // outputs the remaining attempt
    cout << "Enter your PIN: "; // asks user to enter the correct pin again

    cin >> pinInput; // receives user pin input again
    goto PIN_ENTRY; // goes to the pin entry checking to validate the pin again
  }

  double balance = 10000, deposit, withdrawal; // declaration of the variable for balance with the default 10k amount, deposit and withdrawal
                                                // these variables should be declared outside of the main menu to receive proper calculation and output when depositing or withdrawing

  // bank menu
MAIN_MENU:
  int option; // declare option variable

  // output available options for the user
  cout << "===== Welcome to Euan's Bank =====" << endl;
  cout << "1. Check Balance" << endl;
  cout << "2. Deposit Money" << endl;
  cout << "3. Withdraw Money" << endl;
  cout << "4. Exit" << endl;
  cout << "==============================\n" << endl;

  cout << "Enter option: "; // asks user to enter an option
  cin >> option; // reads user option input

  // checks if option is equal to 1
  if (option == 1) {

    cout << "Your current balance is: ₱" << balance << "\n" << endl; // outputs the user's current balance

    cout << "Returning to main menu...\n" << endl; // tells user that it will return to the main menu
    goto MAIN_MENU; // returns to the main menu

    // checks if option is equal to 2
  } else if (option == 2) {

    cout << "Enter amount to deposit: "; // asks user to input the amount to deposit
    cin >> deposit; // receives the deposit amount input

    cout << "You deposited: ₱" << deposit << endl; // outputs that the user deposited the following amount
    balance = balance + deposit; // adds the new deposit amount to the balance

    cout << "Your new balance is: ₱" << balance << "\n" << endl; // outputs the new calculated balance

    cout << "Returning to main menu...\n" << endl; // tells user that it will return to the main menu
    goto MAIN_MENU; // returns to the main menu

    // checks if option is equal to 3
  } else if (option == 3) {

    cout << "Enter amount to withdraw: "; // asks user to input the amount to withdraw
    cin >> withdrawal; // receives the withdrawal amount input

    // checks if withdrawal amount is greater than the available balance
    if (withdrawal > balance) {

      cout << "Withdraw amount exceeds to your available balance.\n" << endl; // alerts the user that the withdraw amount exceeds to their available balance

      // default fallback if withdrawal amount does not exceed the available balance
    } else {

      cout << "You withdrew: ₱" << withdrawal << endl; // outputs that the user withdraw the following amount
      balance = balance - withdrawal; // subtracts the withdrawal amount to the balance

      cout << "Your new balance is: ₱" << balance << "\n" << endl; // outputs the new calculated balance
    }

    cout << "Returning to main menu...\n" << endl; // tells user that it will return to the main menu
    goto MAIN_MENU; // returns to the main menu

    // checks if option is equal to 4
  } else if (option == 4) {

    cout << "Thank you for banking with Euan's Bank, have a great day!" << endl; // outputs thank you message
    return 0; // exits the program

    // default fallback if option is not in the list of available options
  } else {
    
    cout << "Invalid option." << endl; // alerts the user that the option provided is invalid

    cout << "Returning to main menu...\n" << endl; // tells user that it will return to the main menu
    goto MAIN_MENU; // returns to the main menu
  }

  return 0;
}
