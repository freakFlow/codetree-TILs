#include <iostream>
using namespace std;

int main() {
    double ft_to_cm = 30.48;
    double mi_to_cm = 160934;

    double feet = 9.2;
    double mile = 1.3;

    cout << fixed;
    cout.precision(1);

    cout << feet << "ft = " << feet * ft_to_cm << "cm\n";
    cout << mile << "mi = " << mile * mi_to_cm << "cm\n";

    return 0;
}