#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    int n;

    cin >> str >> n;

    for(int i=0; i<n; i++){
        int idx = str.length() - 1 - i;
        if(idx < 0) break;
        cout << str[idx];
    }

    return 0;
}