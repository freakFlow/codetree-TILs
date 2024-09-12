#include <iostream>
using namespace std;

int main() {
    char ch;

    cin >> ch;

    if(ch == 'S') cout << "Superior";
    else if(ch == 'A') cout << "Excellent";
    else if(ch == 'B') cout << "Good";
    else if(ch == 'C') cout << "Usually";
    else if(ch == 'D') cout << "Effort";
    else cout << "Failure";

    return 0;
}