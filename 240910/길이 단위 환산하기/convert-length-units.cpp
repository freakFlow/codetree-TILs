#include <iostream>
using namespace std;

int main() {
    double ft_to_cm = 30.48;
    double feet;

    cin >> feet;

    cout << fixed;
    cout.precision(1);

    cout << feet * ft_to_cm;

    return 0;
}