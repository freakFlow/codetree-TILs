#include <iostream>
#include <string>
using namespace std;

int main() {
    string str, temp;
    int idx = -1;

    cin >> str >> temp;

    idx = str.find(temp);

    cout << idx;

    return 0;
}