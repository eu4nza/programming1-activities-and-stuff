#include <iostream>
using namespace std;

int main() {

  double kwh, rate, totalBill;

  cout << "Enter total kwh consumed: ";
  cin >> kwh;

  if (kwh <= 100) {
    rate = 10.00;

  } else if (kwh <= 200) {
    rate = 15.00;

  } else {

    rate = 20.00;
  }

  totalBill = kwh * rate;

  cout << fixed << endl;
  cout << "Rate per kwh: P" << rate << endl;
  cout << "Total Bill: P" << totalBill << endl;

  return 0;
}