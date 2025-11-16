#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    float kwhConsumed, rate;

    cout << "Enter total kWh consumed: ";
    cin >> kwhConsumed;

    cout << showpoint << fixed << setprecision(2);

    if (kwhConsumed > 200){
        rate = 20.00;
    } else if (kwhConsumed >= 101 && kwhConsumed <= 200) {
        rate = 15.00;
    } else if (kwhConsumed >= 0 && kwhConsumed <= 100) {
        rate = 10.00;
    }
    
    cout << "Rate per kWh: ₱" << rate << endl;
    cout << "Total bill: ₱" << (kwhConsumed * rate) << endl;

    return 0;
}