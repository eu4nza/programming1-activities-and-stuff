#include <iostream> 
#include <iomanip> 
using namespace std;

int main() {
  int subjects = 3;    // Declare variable to store number of subjects (3)
  int grade[3];        // Declare array to store grades for 3 subjects
  double average;      // Declare variable to store calculated average

  // Loop through each subject to get grades from user
  for (int i = 0; i < subjects; i++) {
    cout << "Enter grade in Subject " << (i + 1) << ": "; // Prompt user for grade input
    cin >> grade[i];   // Read grade input from user and store in array
    average += grade[i]; // Add current grade to running total for average calculation
  }

  average /= subjects; // Calculate average by dividing total by number of subjects

  // Display the calculated average with 2 decimal places
  cout << "Average: " << fixed << setprecision(2) << average << endl;

  return 0;
}
