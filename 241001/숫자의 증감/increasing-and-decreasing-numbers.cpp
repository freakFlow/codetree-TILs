#include <iostream>
using namespace std;

int main() {
    char ch;
    int n;

    cin >> ch >> n;

    if(ch == 'A'){
        for(int i=1; i<=n; i++) cout << i << ' ';
    }else if(ch == 'D'){
        for(int i=n; i>0; i--) cout << i << ' ';
    }
    
    return 0;
}