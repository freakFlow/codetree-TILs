#include <iostream>
using namespace std;

int main() {
    char ch;

    for(int i=0; i<5; i++){
        for(int j=0; j<3; j++){
            cin >> ch;
            cout << (char)(ch - ('a' - 'A')) << ' ';
        }
        cout << endl;
    }

    return 0;
}