#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;

    cin >> str;

    cout << (str.find("ee") != string::npos ? "Yes" : "No");
    cout << ' ' << (str.find("ab") != string::npos ? "Yes" : "No");

    return 0;
}