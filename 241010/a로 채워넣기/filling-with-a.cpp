#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;

    cin >> str;

    str[1] = str[str.length()-2] = 'a';

    cout << str;

    return 0;
}