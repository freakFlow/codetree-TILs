#include <iostream>
#include <string>
using namespace std;

int main() {
    int n;
    int len = 0, cnt = 0;
    string str;

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> str;
        len += str.length();
        if(str[0] == 'a') cnt++;
    }

    cout << len << ' ' << cnt;

    return 0;
}