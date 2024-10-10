#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    char ch1, ch2;

    cin >> str;
    ch1 = str[0];
    ch2 = str[1];

    for(int i=0; i<str.length(); i++){
        if(str[i] == ch1) cout << ch2;
        else if(str[i] == ch2) cout << ch1;
        else cout << str[i];
    }

    return 0;
}