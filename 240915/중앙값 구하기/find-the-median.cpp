#include <iostream>
using namespace std;

int main() {
    int a, b, c;

    cin >> a >> b >> c;

    if(a > b){
        if(a < c) cout << a;
        else cout << (b > c ? b : c);
    }else{
        if(b < c) cout << b;
        else cout << (a > c ? a : c);
    }

    return 0;
}