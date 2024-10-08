#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;

    for(int i=0; i<10; i++){
        cin >> str;
        if(i % 2 == 0) cout << str << endl;
    }

    return 0;
}