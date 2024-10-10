#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    int ee = 0, eb = 0;

    cin >> str;

    for(int i=0; i<str.length()-1; i++){
        if(str.substr(i, 2) == "ee") ee++;
        if(str.substr(i, 2) == "eb") eb++;
    }

    cout << ee << ' ' << eb;

    return 0;
}