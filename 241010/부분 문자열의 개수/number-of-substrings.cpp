#include <iostream>
#include <string>
using namespace std;

int main() {
    string A, B;
    int ans = 0;

    cin >> A >> B;

    for(int i=0; i<A.length()-1; i++){
        if(A.substr(i, 2) == B) ans++;
    }

    cout << ans;

    return 0;
}