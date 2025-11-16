#include <iostream>
using namespace std;

int main () {
    int num1, num2, result;

    // Prompt user for input
    cout << "Enter first number: ";

    while (!(cin >> num1)){
        cout << "Invalid input for the first number. Please enter a whole number: ";
        cin.clear(); // clear the error flag
        cin.ignore(numeric_limits<streamsize>::max(), '\n'); // discard invalid input
    }

    cout << "Enter second number: ";

    while (!(cin >> num2)){
        cout << "Invalid input for the second number. Please enter a whole number: ";
        cin.clear(); // clear the error flag
        cin.ignore(numeric_limits<streamsize>::max(), '\n'); // discard invalid input
    }

    result = num1 + num2;
    cout << "Result: " << result << endl;

    return 0;
}