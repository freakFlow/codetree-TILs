#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    char ch;

    int idx = -1;

    cin >> str >> ch;
    idx = str.find(ch);

    if(idx == -1) cout << "No";
    else cout << idx;

    return 0;
}