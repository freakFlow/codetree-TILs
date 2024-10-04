#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    bool isYes = true;

    cin >> a >> b >> c;

    for(int i=1; i<=b; i++){
        if(i % c == 0){
            isYes = false;
            break;
        }
    }

    cout << (isYes ? "YES" : "NO");

    return 0;
}