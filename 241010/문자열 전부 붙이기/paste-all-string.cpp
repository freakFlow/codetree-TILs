#include <iostream>
#include <string>
using namespace std;

int main() {
    int n;
    string str, ans = "";

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> str;
        ans += str;
    }

    cout << ans;

    return 0;
}