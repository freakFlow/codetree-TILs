#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    char ch;
    int ans = 0;

    getline(cin, str);
    cin >> ch;

    for(int i=0; i<str.length(); i++){
        if(ch == str[i]) ans++;
    }

    cout << ans;

    return 0;
}