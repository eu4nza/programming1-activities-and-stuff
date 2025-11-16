#include <iostream>
#include <cctype>
using namespace std;

int main () {
    char option;
    string currency, symbol;
    double rate, amount;

    cout << "\nExchange Rates:" << endl;
    cout << "A = US Dollar: PH₱50.34" << endl;
    cout << "B = Yen: PH₱0.44" << endl;
    cout << "C = Pound: PH₱66.80" << endl;
    cout << "D = Riyal: PH₱13.42" << endl;
    cout << "E = Ringgit: PH₱11.95" << endl;

    cout << "\nPlease select your currency to exchange: ";
    cin >> option;
    option = tolower(option);

    switch (option) {
        case 'a':
            currency = "US Dollar";
            symbol = "USD$";
            rate = 50.34;
        break;
        case 'b':
            currency = "Yen";
            symbol = "JP¥";
            rate = 0.44;
        break;
        case 'c':
            currency = "Pound";
            symbol = "POUND£";
            rate = 66.80;
        break;
        case 'd':
            currency = "Riyal";
            symbol = "SAR";
            rate = 13.42;
        break;
        case 'e':
            currency = "Ringgit";
            symbol = "RM";
            rate = 11.95;
        break;
        default:
        cout << "\nInvalid option. Please try again.\n" << endl;
        return main();
    }

    cout << "\n" << currency << " has been selected as the currency to exchange.\n";
    cout << "Please type the amount to exchange: ";
    cin >> amount;

    cout << "\nYou will receive: PH₱" << (amount * rate) <<  endl;
}
