#include <iostream> 
#include <iomanip> 
using namespace std;

int main() {
  int num1, num2;

  cout << "Enter first number: ";
  cin >> num1;

  cout << "Enter second number: ";
  cin >> num2;

  cout << "\nResults:" << endl;
  cout << num1 << " + " << num2 << " = " << num1 + num2 << endl;
  cout << num1 << " - " << num2 << " = " << num1 - num2 << endl;
  cout << num1 << " * " << num2 << " = " << num1 * num2 << endl;
  cout << num1 << " / " << num2 << " = " << num1 / num2 << endl;
  cout << num1 << " % " << num2 << " = " << num1 % num2 << "\n" << endl;

  cout << "Relational Operators:" << endl;

  string isGreaterThan = "false", isEqual = "false";

  if (num1 > num2) {
    isGreaterThan = "true";
  }

  if (num1 == num2) {
    isEqual = "true";
  }
 
  cout << num1 << " > " << num2 << " : " << isGreaterThan << endl;
  cout << num1 << " == " << num2 << " : " << isEqual << "\n" << endl;

  cout << "Logical Operators:" << endl;

  string bothGreaterThan = "false", isNotLessThan = "false";

  if (num1 > 0 && num2 > 0) {
    bothGreaterThan = "true";
  }

  if (!(num1 < num2)){
    isNotLessThan = "true";
  }

  cout << "(" << num1 << " > " << 0 << " && " << num2 << " > " << 0 << ") : " << bothGreaterThan << endl;
  cout << "!(" << num1 << " < " << num2 << "): " << isNotLessThan << endl;
  
  return 0;
}
