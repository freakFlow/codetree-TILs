#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    int max = 0, min = 21;

    for(int i=0; i<3; i++){
        cin >> str;
        int len = str.length();
        if(len > max) max = len;
        if(len < min) min = len;
    }

    cout << max - min;

    return 0;
}