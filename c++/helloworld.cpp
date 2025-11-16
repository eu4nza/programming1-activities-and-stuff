#include <iostream>
using namespace std;

int main() {
   string variableName = "my variable";

  cout << "unmodified string: " << variableName << endl;

  variableName = "new value";

  cout << "modified string: " << variableName << endl;
  return 0;
}