#include <iostream>
using namespace std;

int main(){
    int real_estate_value;
    cout << "Enter your real estate value: ";
    cin >> real_estate_value;

    if (real_estate_value < 250001.00){
        cout << "Your tax is 5%: " << real_estate_value * 0.05 << endl;
    } else if (real_estate_value >= 250001.00 && real_estate_value <= 500000.00) {
        cout << "Your tax is 10%: " << real_estate_value * 0.10 << endl;
    } else if (real_estate_value > 500000.00) {
        cout << "Your tax is 15%: " << real_estate_value * 0.15 << endl;
    }

    return main();
}