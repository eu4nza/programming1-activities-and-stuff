#include <iostream>
using namespace std;

int main() {
    short int x, y;

    cout << "enter value: ";
    cin >> x;

    cout << y << endl;
    cout << "value provided: " << x << endl;
}

// if you set the variable as "int" then you run the program with a variable with empty value, it would ouput as 32767 
// but using "short int" would output 0
// short int's max value is 32767
