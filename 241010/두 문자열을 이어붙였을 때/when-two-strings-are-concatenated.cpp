#include <iostream>
#include <string>
using namespace std;

int main() {
    string A, B;

    cin >> A >> B;

    cout << (A+B == B+A ? "true" : "false");

    return 0;
}