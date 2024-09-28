#include <iostream>
using namespace std;

int main() {
    int b, a;

    cin >> b >> a;

    if(b % 2 == 0) b--;

    for(int i=b; i>=a; i-=2){
        cout << i << ' ';
    }

    return 0;
}