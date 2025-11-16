#include <iostream>
using namespace std;

int main() {
    int grade;
    string remark;

    cout << "Enter grade: ";
    cin >> grade;

    if (grade >= 90 && grade <= 100) {
        remark = "Remark: Excellent";
    } else if (grade >= 80 && grade < 90) {
        remark = "Remark: Very Good";
    } else if (grade  >= 75 && grade < 80) {
        remark = "Remark: Fair";
    } else if (grade >= 0 && grade < 75 ) {
        remark = "Remark: Failed";
    } else {
        remark = "Error: Invalid grade input";
    }

    cout << remark << endl;

    return 0;
}