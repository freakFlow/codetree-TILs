#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    bool isYes = false;

    cin >> a >> b >> c;

    for(int i=a; i<=b; i++){
        if(i % c == 0){
            isYes = true;
            break;
        }
    }

    cout << (isYes ? "YES" : "NO");

    return 0;
}